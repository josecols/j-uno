package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.ImageIcon;
import juego.ListaUsuarios;
import juego.Usuario;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Clase puntual para manipular un archivo XML con una estructura determinada para usuarios.
 * Permite la escritura y lectura de los elementos en el archivo.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class XMLUsuarios {

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
    public XMLUsuarios() {
        directorio = System.getProperty("user.dir") + "\\J-UNO - Usuarios.xml";
        archivo = new File(directorio);
        sax = new SAXBuilder();
        doc = new Document();
        salida = new XMLOutputter();
        if (abrirArchivo() == null) {
            crearArchivo();
        }
    }

    /**
     * Crea un archivo XML con el formato básico para la manipulación de usuarios.
     */
    public final void crearArchivo() {
        try {
            String xml = "<usuarios></usuarios>";
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
     * Valida si un nombre de usuario y una clave asociada corresponden a un usuario
     * registrado en el sistema.
     * 
     * @param nickname Nombre de usuario (campo único).
     * @param clave Clave asociada al nickname.
     * @return Null en caso de un error de archivo. Los datos del usuario
     * en caso de que la identificación haya sido existosa.
     */
    public Usuario esUsuario(String nickname, String clave) {
        abrirArchivo();
        for (Element elemento : raiz.getChildren("usuario")) {
            if (elemento.getChildText("nickname").equals(nickname)
                    && elemento.getChildText("clave").equals(clave)) {
                return leerUsuario(elemento);
            }
        }
        return null;
    }

    /**
     * Genera un nuevo Usuario dados los datos de un elemento XMLUsuarios dado.
     * 
     * @param usuario Elemento XML a leer.
     * @return Usuario con el valor de los atributos igual al contenido
     * de los hijos del elemento reviso por parámetro.
     */
    public Usuario leerUsuario(Element usuario) {
        return new Usuario(usuario.getChildText("nombre"),
                usuario.getChildText("apellido"),
                usuario.getChildText("email"),
                new ImageIcon(usuario.getChildText("avatar"), usuario.getChildText("avatar")),
                usuario.getChildText("nickname"),
                usuario.getChildText("clave"),
                usuario.getChildText("estado"));
    }

    /**
     * Genera una lista de usuarios que se corresponde a todos los elementos
     * del archivo XML especificado.
     * 
     * @return Lista de usuarios registrados.
     */
    public ListaUsuarios leerUsuarios() {
        ListaUsuarios usuarios = new ListaUsuarios();
        abrirArchivo();
        for (Element usuario : raiz.getChildren("usuario")) {
            usuarios.add(leerUsuario(usuario));
        }
        return usuarios;
    }

    /**
     * Origina un elemento XML con los datos de usuario dado.
     * 
     * @param usuario Usuario utilizado para construir el elemento.
     * @return Elemento con todos sus hijos y valores correspondientes.
     */
    private Element nuevoUsuario(Usuario usuario) {
        Element nuevo = new Element("usuario");
        nuevo.addContent(new Element("nombre").setText(usuario.getNombre()));
        nuevo.addContent(new Element("apellido").setText(usuario.getApellido()));
        nuevo.addContent(new Element("email").setText(usuario.getEmail()));
        nuevo.addContent(new Element("nickname").setText(usuario.getNickname()));
        nuevo.addContent(new Element("clave").setText(usuario.getClave()));
        nuevo.addContent(new Element("avatar").setText(usuario.getAvatar().getDescription()));
        nuevo.addContent(new Element("estado").setText(usuario.getEstado()));
        return nuevo;
    }

    /**
     * Elimina un usuario del archivo.
     * 
     * @param usuario Usuario a eliminar.
     */
    public void eliminarUsuario(Usuario usuario) {
        abrirArchivo();
        for (Element elemento : raiz.getChildren("usuario")) {
            if (elemento.getChildText("nickname").equals(usuario.getNickname())) {
                raiz.removeContent(raiz.indexOf(elemento));
                break;
            }
        }
        escribirArchivo();
    }

    /**
     * Agrega un usuario al final del archivo XML.
     * 
     * @param usuario Usuario a anexar.
     */
    public boolean agregarUsuario(Usuario usuario) {
        Element elemento = nuevoUsuario(usuario);
        abrirArchivo();
        if (!leerUsuarios().contiene(usuario)) {
            raiz.addContent(elemento);
            escribirArchivo();
            return true;
        }
        return false;
    }

    /**
     * Modifica los datos de un usuario en el archivo XML.
     * Se basa en que los nombres de usuario (nickname) son campos únicos.
     * 
     * @param usuario Usuario a modificar.
     */
    public void actualizarUsuario(Usuario usuario) {
        eliminarUsuario(usuario);
        agregarUsuario(usuario);
    }
}
