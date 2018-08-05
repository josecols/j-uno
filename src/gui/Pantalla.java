package gui;

import datos.XMLUsuarios;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juego.Jugador;
import juego.Usuario;

/**
 * Representa la interfaz base para todas las pantallas del juego.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class Pantalla extends JFrame {

    public static final Dimension MINIMO = new Dimension(800, 700);
    public static final Dimension MAXIMO = new Dimension(1280, 720);
    public final Color FONDO = new Color(0x0C3508);
    protected FondoPanel fondo;
    protected JPanel contenedor;
    protected BarraPrincipal barra;
    protected FormularioUsuario formularioUsuario;
    protected FormularioLogin formularioLogin;
    protected FormularioPartida formularioPartida;
    protected FormularioJugadores formularioJugadores;
    protected FormularioUsuarios formularioUsuarios;
    protected FormularioEstadisticas formularioEstadisticas;
    protected Usuario usuarioActual;
    protected JInternalFrame formularios[] = new JInternalFrame[6];
    private XMLUsuarios datos;

    /**
     * Crea una nueva ventana con una configuración y características determinadas.
     * 
     * @param nombre Título de la ventana.
     * @param fondo Nombre de la imagen de fondo.
     * @param estilo Estilo de la imagen de fondo.
     * @param alineacionX Alineación horizontal de la imagen de fondo.
     * @param alineacionY Alineación vertical de la imagen de fondo.
     */
    public Pantalla(String nombre, String fondo, int estilo, float alineacionX, float alineacionY) {
        super(nombre);
        this.datos = new XMLUsuarios();
        this.contenedor = new JPanel();
        this.barra = new BarraPrincipal();
        this.fondo = new FondoPanel(fondo, estilo, alineacionX, alineacionY);
        this.usuarioActual = null;
        this.formularioUsuario = new FormularioUsuario();
        this.formularioLogin = new FormularioLogin();
        this.formularioPartida = new FormularioPartida();
        this.formularioJugadores = new FormularioJugadores();
        this.formularioUsuarios = new FormularioUsuarios();
        this.formularioEstadisticas = new FormularioEstadisticas();
        this.formularios[0] = this.formularioLogin;
        this.formularios[1] = this.formularioUsuario;
        this.formularios[2] = this.formularioPartida;
        this.formularios[3] = this.formularioJugadores;
        this.formularios[4] = this.formularioUsuarios;
        this.formularios[5] = this.formularioEstadisticas;
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconos/icono-juego.png")).getImage());
        initComponents();
    }

    /**
     * Oculta todos los formularios.
     */
    protected void ocultarFormularios() {
        for (JInternalFrame jInternalFrame : formularios) {
            jInternalFrame.setVisible(false);
        }
    }

    /**
     * Agrega los formularios a la pantalla.
     */
    private void agregarFormularios() {
        for (JInternalFrame jInternalFrame : formularios) {
            fondo.add(jInternalFrame);
        }
    }

    /**
     * Inicializa la ventana y sus componentes.
     */
    private void initComponents() {
        agregarFormularios();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(MAXIMO);
        this.setMinimumSize(MINIMO);
        this.setPreferredSize(MAXIMO);
        this.setMaximumSize(MAXIMO);
        this.setBackground(FONDO);
        this.setContentPane(fondo);
        this.setJMenuBar(barra);
        fondo.setBackground(FONDO);
        fondo.setLayout(null);
        fondo.add(contenedor);
        initListeners();
    }

    /**
     * Crea los listeners de los componentes de la pantalla.
     */
    private void initListeners() {
        //Opcion: Pantalla completa.
        barra.getJuego()[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pantallaCompleta();
            }
        });

        //Opcion: Ayuda.
        barra.getJuego()[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mostrarAyuda();
            }
        });

        //Opcion: Salir.
        barra.getJuego()[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Pantalla.this.dispose();
            }
        });

        //Opcion: Nueva partida rapida.
        barra.getPartida()[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                nuevaPartidaRapida();
            }
        });

        //Opcion: Nueva partida acumulativa.
        barra.getPartida()[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                nuevaPartidaAcumulativa();
            }
        });

        //Opcion: Gestionar jugadores.
        barra.getPartida()[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                gestionarJugadores();
            }
        });

        //Opcion: Agregar usuario/Modificar datos
        barra.getUsuario()[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                administrarUsuario();
                formularioUsuario.llamar(null);
            }
        });

        //Opcion: Iniciar sesión/Cerrar sesión
        barra.getUsuario()[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                administrarSesionUsuario();
                formularioLogin.setModoAutenticacion(-1);
            }
        });

        //Guardar datos del usuario.
        formularioUsuario.getjButtonGuardar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                guardarUsuario();
            }
        });

        //Iniciar sesión.
        formularioLogin.getjButtonEnviar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                iniciarSesion();
            }
        });

        //Finalizar la configuración de los jugadores.
        formularioJugadores.getjButtonListo().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                finalizarConfiguracionJugadores();
            }
        });

        //Inicio de sesión desde la configuración de partida
        formularioPartida.getjButtonIdentificar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultarFormularios();
                formularioLogin.setVisible(true);
                formularioLogin.setModoAutenticacion(FormularioLogin.JUGAR);
            }
        });

        //Iniciar partida.
        formularioPartida.getjButtonJugar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                iniciarPartida();
            }
        });
    }

    /**
     * Procedimiento que se ejecuta como resultado de una interración con
     * la opción "Pantalla completa" del menú "Juego" de la barra principal. 
     * Si la ventana instanciada con la clase Pantalla se encuentra en
     * FullScreen la ventana es retornada a su dimensión normal.
     * De lo contrario se lleva a pantalla completa.
     */
    protected void pantallaCompleta() {
        GraphicsDevice dispositivo = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (barra.getJuego()[0].getText().equals("Pantalla completa")) {
            this.setResizable(false);
            dispositivo.setFullScreenWindow(this);
            barra.getJuego()[0].setText("Salir de pantalla completa");
        } else {
            this.setResizable(true);
            dispositivo.setFullScreenWindow(null);
            barra.getJuego()[0].setText("Pantalla completa");
        }
    }

    /**
     * Abre un documento que corresponde a la ayuda del juego.
     */
    private void mostrarAyuda() {
        String directorio = System.getProperty("user.dir") + "\\J-UNO - Ayuda.pdf";
        try {
            if (!(new File(directorio).exists())) {
                InputStream is = getClass().getResourceAsStream("/datos/Ayuda.pdf");
                OutputStream os = new FileOutputStream(directorio);
                byte[] buffer = new byte[4096];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                os.close();
                is.close();
            }
            Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + directorio);
            p.waitFor();
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(fondo, "No se pudo generar el archivo de ayuda",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Llama al formulario para configurar una partida.
     */
    protected void nuevaPartida() {
        ocultarFormularios();
        formularioPartida.llamar(usuarioActual);
    }

    /**
     * Llama al formulario para configurar una partida rápida.
     */
    private void nuevaPartidaRapida() {
        formularioPartida.setModalidad(FormularioPartida.PARTIDA_RAPIDA);
        nuevaPartida();
    }

    /**
     * Llama al formulario para configurar una partida acumulativa.
     */
    private void nuevaPartidaAcumulativa() {
        formularioPartida.setModalidad(FormularioPartida.PARTIDA_ACUMULATIVA);
        nuevaPartida();
    }

    /**
     * Llama al formulario para configurar los jugadores que serán 
     * controlados por computadora.
     */
    private void gestionarJugadores() {
        ocultarFormularios();
        formularioJugadores.setVisible(true);
        formularioJugadores.setModoFinalizar(-1);
    }

    /**
     * Finaliza la configuración de los jugadores. De haberlo establecido, 
     * se iniciará una partida.
     */
    protected void finalizarConfiguracionJugadores() {
        formularioJugadores.dispose();
        if (formularioJugadores.getModoFinalizar() == FormularioJugadores.JUGAR) {
            jugar();
        }
    }

    /**
     * Llama al formulario para administrar un usuario registrado.
     */
    protected void administrarUsuario() {
        ocultarFormularios();
        if (usuarioActual == null) {
            formularioUsuario.setModoGuardardo(FormularioUsuario.AGREGAR);
        } else {
            formularioUsuario.setModoGuardardo(FormularioUsuario.MODIFICAR);
            formularioUsuario.setCampos(usuarioActual);
        }
    }

    /**
     * Guarda el usuario.
     */
    protected void guardarUsuario() {
        switch (formularioUsuario.getModoGuardardo()) {
            case FormularioUsuario.AGREGAR:
                formularioUsuario.agregarUsuario(datos);
                break;
            case FormularioUsuario.MODIFICAR:
                usuarioActual = formularioUsuario.modificarUsuario(datos, usuarioActual);
                break;
            case FormularioUsuario.DESACTIVAR:
                formularioUsuario.desactivarUsuario(datos, usuarioActual);
                formularioUsuarios.setVisible(true);
                cerrarSesion();
                break;
            case FormularioUsuario.REACTIVAR:
                formularioUsuario.reactivarUsuario(datos, usuarioActual);
                formularioUsuarios.setVisible(true);
                cerrarSesion();
                break;
        }
    }

    /**
     * Inicia o cierra la sesión de un usuario registrado.
     */
    protected void administrarSesionUsuario() {
        if (usuarioActual == null) {
            ocultarFormularios();
            formularioLogin.setVisible(true);
        } else {
            cerrarSesion();
        }
    }

    /**
     * Cierra la sesión de un usuario registrado.
     */
    protected void cerrarSesion() {
        usuarioActual = null;
        barra.setMenuUsuario(usuarioActual);
    }

    /**
     * Inicia la sesión de un usuario registrado.
     */
    private void iniciarSesion() {
        if (formularioLogin.validarDatos() != null) {
            usuarioActual = formularioLogin.validarDatos();
            barra.setMenuUsuario(usuarioActual);
            switch (formularioLogin.getModoAutenticacion()) {
                case FormularioLogin.MODIFICAR:
                    administrarUsuario();
                    formularioUsuario.llamar(formularioUsuarios);
                    break;
                case FormularioLogin.JUGAR:
                    jugar();
                    break;
                case FormularioLogin.DESACTIVAR:
                    guardarUsuario();
                    break;
            }
            formularioLogin.dispose();
        }
    }

    /**
     * Llama al método jugar para dar inicio a una partida o llama al formulario
     * para configurar los jugadores que serán controlados por la computadora en
     * la partida.
     */
    private void iniciarPartida() {
        if (formularioPartida.getjButtonJugar().getText().equals("Jugar")) {
            jugar();
        } else {
            ocultarFormularios();
            formularioJugadores.setVisible(true);
            formularioJugadores.setModoFinalizar(FormularioJugadores.JUGAR);
        }
    }

    /**
     * Crea una instancia de PantallaPartida con las configuraciones establecidas.
     */
    private void jugar() {
        PantallaPartida juego;
        ocultarFormularios();
        juego.ListaJugadores jugadores = formularioJugadores.getJugadores();

        //Generando el número de jugadores necesarios.
        if (jugadores.size() < formularioPartida.getjSpinnerJugadores()) {
            jugadores.generarJugadores(formularioPartida.getjSpinnerJugadores() - 1);
        }

        //Eliminando jugadores que sobran.
        for (int i = jugadores.size() - 1, n = formularioPartida.getjSpinnerJugadores() - 2; i > n; --i) {
            jugadores.remove(i);
        }


        //Se envía el usuario para generar las estadísticas. Se toma en cuenta a los invitados como un solo usuario.
        if (usuarioActual == null) {
            jugadores.add(new Jugador("Invitado", "", new ImageIcon(getClass().getResource("/imagenes/iconos/avatar.png"),
                    "/imagenes/iconos/avatar.png")));
            juego = new PantallaPartida(jugadores,
                    (formularioPartida.getModalidad() == FormularioPartida.PARTIDA_ACUMULATIVA) ? formularioPartida.getjSpinnerPuntos() : -1,
                    null);
        } else {
            jugadores.add(Jugador.asJugador(usuarioActual));
            juego = new PantallaPartida(jugadores,
                    (formularioPartida.getModalidad() == FormularioPartida.PARTIDA_ACUMULATIVA) ? formularioPartida.getjSpinnerPuntos() : -1,
                    usuarioActual);
        }
        juego.setVisible(true);
        this.dispose();
    }
}