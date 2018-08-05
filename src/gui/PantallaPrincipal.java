package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;

/**
 * Representa la interfaz del menú principal del juego.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Mendez.
 */
public class PantallaPrincipal extends Pantalla {

    private JButton jButtonNuevaPartida;
    private JButton jButtonGestionarUsuarios;
    private JButton jButtonEstadisticas;

    /**
     * Crea una pantalla que contiene el menú principal del juego.
     */
    public PantallaPrincipal() {
        super("J-UNO", "fondo.png", FondoPanel.REAL, 0.5f, 0.5f);
        jButtonNuevaPartida = new JButton("Nueva partida");
        jButtonGestionarUsuarios = new JButton("Gestionar usuarios");
        jButtonEstadisticas = new JButton("Estadísticas");
        initComponents();

    }

    /**
     * Inicializa los componentes.
     */
    private void initComponents() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        contenedor.setLayout(new GridLayout(0, 1));
        contenedor.add(jButtonNuevaPartida);
        contenedor.add(jButtonGestionarUsuarios);
        contenedor.add(jButtonEstadisticas);
        jButtonNuevaPartida.setFont(jButtonNuevaPartida.getFont().deriveFont((float) 20));
        jButtonGestionarUsuarios.setFont(jButtonGestionarUsuarios.getFont().deriveFont((float) 20));
        jButtonEstadisticas.setFont(jButtonEstadisticas.getFont().deriveFont((float) 20));
        initListeners();
    }

    /**
     * Crea los listeners de los componentes de la pantalla.
     */
    private void initListeners() {
        //Nueva partida.
        jButtonNuevaPartida.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                nuevaPartida();
            }
        });

        //Gestionar usuarios.
        jButtonGestionarUsuarios.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultarFormularios();
                formularioUsuarios.setVisible(true);
            }
        });

        //Estadisticas.
        jButtonEstadisticas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultarFormularios();
                formularioEstadisticas.setVisible(true);
            }
        });



        //Gestionar usuarios: Agregar. Llama al formularioUsuario para agregar el usuario.
        formularioUsuarios.getjButtonAgregar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                formularioUsuario.setModoGuardardo(FormularioUsuario.AGREGAR);
                formularioUsuario.llamar(formularioUsuarios);
            }
        });

        //Gestionar usuarios: Modificar. Llama a formularioUsuario para modificar el usuario.
        formularioUsuarios.getjButtonModificar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (usuarioActual == null) {
                    formularioLogin.setModoAutenticacion(FormularioLogin.MODIFICAR);
                    administrarSesionUsuario();
                } else {
                    administrarUsuario();
                    formularioUsuario.llamar(formularioUsuarios);
                }
            }
        });

        //Gestionar usuarios: Desactivar. Llama a formularioLogin si es invitado. Desactiva el usuario.
        formularioUsuarios.getjButtonDesactivar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (formularioUsuarios.getjButtonDesactivar().getText().equals("Reactivar")) {
                    usuarioActual = formularioUsuarios.getUsuarioSeleccionado();
                    formularioUsuario.setModoGuardardo(FormularioUsuario.REACTIVAR);
                    guardarUsuario();
                } else {
                    formularioUsuario.setModoGuardardo(FormularioUsuario.DESACTIVAR);
                    if (usuarioActual == null) {
                        formularioLogin.setModoAutenticacion(FormularioLogin.DESACTIVAR);
                        administrarSesionUsuario();
                    } else {
                        guardarUsuario();
                    }
                }
            }
        });

        //Interacciones sobre la ventana.
        this.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent evt) {
                contenedor.setBounds(PantallaPrincipal.this.getWidth() / 2 - 200, PantallaPrincipal.this.getHeight() / 2 - 40, 385, 200);
            }

            @Override
            public void componentMoved(ComponentEvent ce) {
            }

            @Override
            public void componentShown(ComponentEvent ce) {
            }

            @Override
            public void componentHidden(ComponentEvent ce) {
            }
        });
    }
}
