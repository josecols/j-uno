package datos;

import juego.Estadistica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import juego.ListaEstadisticas;
import juego.Usuario;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Clase puntual para manipular un archivo XML con una estructura determinada para estadísticas.
 * Permite la escritura y lectura de los elementos en el archivo.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class XMLEstadisticas {

    private String directorio;
    private SAXBuilder sax;
    private Document doc;
    private File archivo;
    private XMLOutputter salida;
    private Element raiz;

    /**
     * Inicializa el atributo directorio en la dirección de la aplicación más
     * el nombre del archivo a tratar.
     */
    public XMLEstadisticas() {
        directorio = System.getProperty("user.dir") + "\\J-UNO - Estadisticas.xml";
        archivo = new File(directorio);
        sax = new SAXBuilder();
        doc = new Document();
        salida = new XMLOutputter();
        if (abrirArchivo() == null) {
            crearArchivo();
        }
    }

    /**
     * Crea un archivo XML con el formato básico para la manipulación de estadísticas.
     */
    public final void crearArchivo() {
        try {
            String xml = "<estadisticas></estadisticas>";
            doc = sax.build(new StringReader(xml));
            salida.output(doc, new FileWriter(directorio));
        } catch (JDOMException ex) {
            System.err.println("No se ha podido crear el archivo.");
        } catch (IOException ex) {
            System.err.println("No se ha podido crear el archivo.");
        }
    }

    /**
     * Abre el archivo XML.
     * 
     * @return Raíz del archivo XML.
     */
    public final Element abrirArchivo() {
        raiz = null;
        try {
            doc = sax.build(archivo);
            raiz = doc.getRootElement();
        } catch (JDOMException ex) {
            System.err.println("No se ha podido abrir el archivo.");
        } catch (IOException ex) {
            System.err.println("No se ha podido abrir el archivo.");
        }
        return raiz;
    }

    /**
     * Escribe los datos en el archivo.    
     */
    public void escribirArchivo() {
        try {
            salida.setFormat(Format.getPrettyFormat());
            salida.output(doc, new FileWriter(directorio));
        } catch (IOException ex) {
            System.err.println("No se ha podido escribir el archivo.");
        }
    }

    /**
     * Genera una nueva Estadistica dados los datos de un elemento XML.
     * 
     * @param estadistica Elemento XML a leer.
     * @return Estadistica con el valor de los atributos igual al contenido
     * de los hijos del elemento recibido por parámetro.
     */
    public Estadistica leerEstadistica(Element estadistica) {
        return new Estadistica(new Usuario(estadistica.getChildText("nombre"),
                estadistica.getChildText("apellido"),
                estadistica.getChildText("nickname")),
                Integer.valueOf(estadistica.getChildText("partidasJugadas")),
                Integer.valueOf(estadistica.getChildText("partidasGanadas")),
                Integer.valueOf(estadistica.getChildText("partidasPerdidas")),
                Integer.valueOf(estadistica.getChildText("partidasAbandonadas")));

    }

    /**
     * Genera una lista de estadísticas que corresponde a todos los elementos
     * del archivo XML especificado.
     * 
     * @return Lista de estadísticas guardadas.
     */
    public ListaEstadisticas leerEstadisticas() {
        ListaEstadisticas estadisticas = new ListaEstadisticas();
        abrirArchivo();
        for (Element usuario : raiz.getChildren("estadistica")) {
            estadisticas.add(leerEstadistica(usuario));
        }
        estadisticas.ordenar();
        return estadisticas;
    }

    /**
     * Genera un elemento XML con los datos de la estadística dada.
     * 
     * @param estadistica Estadistica utilizada para construir el elemento.
     * @return Elemento con todos sus hijos y valores correspondientes.
     */
    private Element nuevaEstadistica(Estadistica estadistica) {
        Element nuevo = new Element("estadistica");
        nuevo.addContent(new Element("nombre").setText(estadistica.getJugador().getNombre()));
        nuevo.addContent(new Element("apellido").setText(estadistica.getJugador().getApellido()));
        nuevo.addContent(new Element("nickname").setText(estadistica.getJugador().getNickname()));
        nuevo.addContent(new Element("partidasJugadas").setText(String.valueOf(estadistica.getPartidasJugadas())));
        nuevo.addContent(new Element("partidasGanadas").setText(String.valueOf(estadistica.getPartidasGanadas())));
        nuevo.addContent(new Element("partidasPerdidas").setText(String.valueOf(estadistica.getPartidasPerdidas())));
        nuevo.addContent(new Element("partidasAbandonadas").setText(String.valueOf(estadistica.getPartidasAbandonadas())));
        return nuevo;
    }

    /**
     * Elimina una estadística del archivo.
     * 
     * @param estadistica Estadística a eliminar.
     */
    public void eliminarEstadistica(Estadistica estadistica) {
        abrirArchivo();
        Usuario jugador = estadistica.getJugador();
        for (Element elemento : raiz.getChildren("estadistica")) {
            if (elemento.getChildText("nickname").equals(jugador.getNickname())) {
                raiz.removeContent(raiz.indexOf(elemento));
                break;
            }
        }
        escribirArchivo();
    }

    /**
     * Agrega una estadística al final del archivo XML.
     * 
     * @param estadistica Estadística a anexar.
     */
    public boolean agregarEstadistica(Estadistica estadistica) {
        Element elemento = nuevaEstadistica(estadistica);
        abrirArchivo();
        if (!leerEstadisticas().contiene(estadistica.getJugador())) {
            raiz.addContent(elemento);
            escribirArchivo();
            return true;
        }
        return false;
    }

    /**
     * Modifica los datos de una estadística en el archivo XML.
     * Se basa en que los nombres de usuario (nickname) del jugador son campos únicos.
     * 
     * @param estadistica Estadistica a modificar.
     */
    public void actualizarEstadistica(Estadistica estadistica) {
        eliminarEstadistica(estadistica);
        agregarEstadistica(estadistica);
    }
}
