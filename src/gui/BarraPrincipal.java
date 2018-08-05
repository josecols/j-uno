package gui;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Clase de la barra principal del juego, encargada de presentar las opciones principales
 * para la configuración del mismo.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class BarraPrincipal extends JMenuBar {

    private JMenu opciones[];
    private JMenuItem juego[];
    private JMenuItem partida[];
    private JMenuItem usuario[];

    public BarraPrincipal() {
        opciones = new JMenu[3];
        juego = new JMenuItem[3];
        partida = new JMenuItem[4];
        usuario = new JMenuItem[2];
        initComponents();
    }

    /**
     * Inicializa los elementos de la Barra Principal.
     */
    private void initComponents() {
        opciones[0] = new JMenu("Juego");
        juego[0] = new JMenuItem("Pantalla completa");
        juego[0].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/fullscreen.png")));
        juego[1] = new JMenuItem("Ayuda");
        juego[1].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/ayuda.png")));
        juego[2] = new JMenuItem("Salir");
        juego[2].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/salir.png")));

        opciones[1] = new JMenu("Partida");
        partida[0] = new JMenuItem("Nueva partida rápida");
        partida[0].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/rapida.png")));
        partida[1] = new JMenuItem("Nueva partida acumulativa");
        partida[1].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/acumulativa.png")));
        partida[2] = new JMenuItem("Configurar jugadores");
        partida[2].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/configurar.png")));
        partida[3] = new JMenuItem("Finalizar partida");
        partida[3].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/finalizar.png")));
        partida[3].setVisible(false);

        opciones[2] = new JMenu("Usuario");
        usuario[0] = new JMenuItem("Iniciar sesión");
        usuario[0].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/login.png")));
        usuario[1] = new JMenuItem("Agregar usuario");
        usuario[1].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/agregar.png")));

        for (JMenu jMenu : opciones) {
            this.add(jMenu);
        }

        for (JMenuItem jMenuItem : juego) {
            opciones[0].add(jMenuItem);
        }

        for (JMenuItem jMenuItem : partida) {
            opciones[1].add(jMenuItem);
        }

        for (JMenuItem jMenuItem : usuario) {
            opciones[2].add(jMenuItem);
        }
    }
    
    /**
     * Cambia el icono y el texto del menú Usuario cuando un usuario inicia y
     * cierra sesión.
     * 
     * @param usuario 
     */
    public void setMenuUsuario(juego.Usuario usuario) {
        if (usuario == null) {
            this.opciones[2].setText("Usuario");
            this.usuario[0].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/login.png")));
            this.usuario[0].setText("Iniciar sesión");
            this.usuario[1].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/agregar.png")));
            this.usuario[1].setText("Agregar usuario");
        } else {
            this.opciones[2].setText(usuario.getNickname());
            this.usuario[0].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/logout.png")));
            this.usuario[0].setText("Cerrar sesión");
            this.usuario[1].setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/modificar.png")));
            this.usuario[1].setText("Modificar mis datos");
        }
    }

    //Getters y Setters.
    public JMenuItem[] getJuego() {
        return juego;
    }

    public void setJuego(JMenuItem[] juego) {
        this.juego = juego;
    }

    public JMenu[] getOpciones() {
        return opciones;
    }

    public void setOpciones(JMenu[] opciones) {
        this.opciones = opciones;
    }

    public JMenuItem[] getPartida() {
        return partida;
    }

    public void setPartida(JMenuItem[] partida) {
        this.partida = partida;
    }

    public JMenuItem[] getUsuario() {
        return usuario;
    }

    public void setUsuario(JMenuItem[] usuario) {
        this.usuario = usuario;
    }
}
