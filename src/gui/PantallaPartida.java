package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import juego.Carta;
import juego.Estadistica;
import juego.Jugador;
import juego.ListaJugadores;
import juego.Mano;
import juego.Partida;
import juego.Usuario;

/**
 * Gestiona la interfaz del flujo de una partida.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * Nota: En los comentarios de esta clase, cuando se habla de jugador se refiere al computador.
 * Cuando se habla de usuario se refiere al jugador humano.
 * 
 * @author José Cols, Larisa Méndez
 */
public class PantallaPartida extends Pantalla {

    private Partida partida;
    private SelectorColor selectorColor;
    private JPanel jugadores[] = new JPanel[9];
    private JLabel[] nombres = new JLabel[9];
    private JLabel[] avatares = new JLabel[9];
    private JLabel[] puntos = new JLabel[9];
    private JLabel[] cartas = new JLabel[9];
    private boolean cartasActivas = false;

    /**
     * Crea una nueva pantalla para la ejecución de una partida.
     * 
     * @param lista Lista de jugadores que están en la partida.
     * @param puntos Número de puntos a los que se jugará. Si el valor
     * es -1, la partida será del modo rápida.
     * @param usuario Usuario registrado que está jugando.
     */
    public PantallaPartida(ListaJugadores listaJugadores, int puntos, Usuario usuarioActual) {
        super("J-UNO", "fondo-partida.png", FondoPanel.REAL, 0.5f, 0.5f);
        this.partida = new Partida();
        this.selectorColor = new SelectorColor("Selector de color");
        this.fondo.add(selectorColor);
        this.usuarioActual = usuarioActual;
        listaJugadores.reiniciarCiclo();
        this.partida.setJugadores(listaJugadores);
        this.partida.repartir();
        this.formularioJugadores.setJugadores(ListaJugadores.copiarLista(listaJugadores));
        this.formularioJugadores.getJugadores().remove(this.formularioJugadores.getJugadores().size() - 1);
        this.formularioJugadores.actualizarLista();
        initPartida();
        initInterfaz(puntos);
    }

    /**
     * Crea una ventana de pantalla principal y cierra la pantalla de partida.
     */
    private void salir() {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }

    /**
     * Le pregunta al usuario si está seguro de abandonar la partida. 
     * De estarlo se guardan las estadísticas relacionadas.
     */
    private void finalizarPartida() {
        String[] opciones = {"Si", "No"};
        int respuesta = JOptionPane.showInternalOptionDialog(fondo,
                "Esta seguro que desea abandonar la partida?",
                "Abandonar partida",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);
        if (respuesta == JOptionPane.YES_OPTION) {
            //Actualizar estadisticas.
            formularioEstadisticas.guardarEstadistica(new Estadistica(new Usuario("Computador", "", "computador"), 1, 0, 0, 0));
            if (usuarioActual == null) {
                formularioEstadisticas.guardarEstadistica(new Estadistica(new Usuario("Invitado", "", "invitado"), 1, 0, 1, 1));
            } else {
                formularioEstadisticas.guardarEstadistica(new Estadistica(usuarioActual, 1, 0, 1, 1));
            }
            salir();
        }
    }

    /**
     * Configura la mesa para el tipo de partida que se va a realizar.
     * 
     * @param puntos Número de puntos que debe alcanzar un jugador para ganar la partida.
     */
    private void initInterfaz(int puntos) {
        if (puntos == -1) {
            ocultarPuntos();
            partida.setModo(FormularioPartida.PARTIDA_RAPIDA);
        } else {
            partida.setModo(FormularioPartida.PARTIDA_ACUMULATIVA);
            partida.setPuntos(puntos);
        }
        barra.getPartida()[3].setVisible(true);
        barra.setMenuUsuario(usuarioActual);
        barra.getPartida()[3].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                finalizarPartida();
            }
        });
    }

    /**
     * Se guarda referencia de los componentes gráficos en arreglos, para 
     * su manipulación en conjunto.
     */
    private void initArreglosComponentes() {
        //Panel de jugadores.
        jugadores[0] = jPanelJugador1;
        jugadores[1] = jPanelJugador2;
        jugadores[2] = jPanelJugador3;
        jugadores[3] = jPanelJugador4;
        jugadores[4] = jPanelJugador5;
        jugadores[5] = jPanelJugador6;
        jugadores[6] = jPanelJugador7;
        jugadores[7] = jPanelJugador8;
        jugadores[8] = jPanelJugador9;
        //Label del nombre.
        nombres[0] = jLabelNombre1;
        nombres[1] = jLabelNombre2;
        nombres[2] = jLabelNombre3;
        nombres[3] = jLabelNombre4;
        nombres[4] = jLabelNombre5;
        nombres[5] = jLabelNombre6;
        nombres[6] = jLabelNombre7;
        nombres[7] = jLabelNombre8;
        nombres[8] = jLabelNombre9;
        //Label del avatar.
        avatares[0] = jLabelAvatar1;
        avatares[1] = jLabelAvatar2;
        avatares[2] = jLabelAvatar3;
        avatares[3] = jLabelAvatar4;
        avatares[4] = jLabelAvatar5;
        avatares[5] = jLabelAvatar6;
        avatares[6] = jLabelAvatar7;
        avatares[7] = jLabelAvatar8;
        avatares[8] = jLabelAvatar9;
        //Label de los puntos.
        puntos[0] = jLabelPuntos1;
        puntos[1] = jLabelPuntos2;
        puntos[2] = jLabelPuntos3;
        puntos[3] = jLabelPuntos4;
        puntos[4] = jLabelPuntos5;
        puntos[5] = jLabelPuntos6;
        puntos[6] = jLabelPuntos7;
        puntos[7] = jLabelPuntos8;
        puntos[8] = jLabelPuntos9;
        //Label de las cartas.
        cartas[0] = jLabelCartas1;
        cartas[1] = jLabelCartas2;
        cartas[2] = jLabelCartas3;
        cartas[3] = jLabelCartas4;
        cartas[4] = jLabelCartas5;
        cartas[5] = jLabelCartas6;
        cartas[6] = jLabelCartas7;
        cartas[7] = jLabelCartas8;
        cartas[8] = jLabelCartas9;
    }

    /**
     * Configura la visibilidad de los jugadores controlados por computadora.
     */
    private void initJugadores() {
        for (int i = 8, n = formularioJugadores.getJugadores().size() - 1; i > n; --i) {
            jugadores[i].setVisible(false);
        }
    }

    /**
     * Finaliza la configuración de los jugadores por el método de Pantalla y
     * actualiza los datos modificados en los jugadores del tablero de partida.
     */
    @Override
    protected void finalizarConfiguracionJugadores() {
        super.finalizarConfiguracionJugadores();
        actualizarJugadores();
    }

    /**
     * Actualiza los datos de todos los jugadores controlados por computadora.
     */
    private void actualizarJugadores() {
        for (int i = 0, n = formularioJugadores.getJugadores().size(); i < n; ++i) {
            nombres[i].setText(formularioJugadores.getJugadores().get(i).getNombre()
                    + " " + formularioJugadores.getJugadores().get(i).getApellido());
            avatares[i].setIcon(formularioJugadores.getJugadores().get(i).getAvatar());
            cartas[i].setText("Cartas: " + formularioJugadores.getJugadores().get(i).getMano().size());
        }
    }

    /**
     * Actualiza la contraparte gráfica de las cartas del jugador humano.
     */
    private void actualizarCartasUsuario() {
        jPanelCartas.removeAll();
        Mano mano = partida.getJugadores().get(partida.getJugadores().size() - 1).getMano();
        for (int i = 0, n = mano.size(); i < n; ++i) {
            JLabel cartaUI = new JLabel(new ImageIcon(getClass().getResource("/imagenes/cartas/"
                    + mano.get(i).getNombre()
                    + mano.get(i).getColor()
                    + ".png")), JLabel.CENTER);
            cartaUI.setName(mano.get(i).getNombre() + "," + mano.get(i).getColor());
            jPanelCartas.add(cartaUI);
            activarCarta(i);
        }
    }

    /**
     * Guarda la estadística cuando gana un jugador humano.
     */
    public void guardarJugador() {
        JOptionPane.showInternalMessageDialog(fondo,
                "El jugador " + partida.getUsuarioJugador().getNombre() + " "
                + partida.getUsuarioJugador().getApellido() + " ha ganado.",
                "Ganador de la partida", JOptionPane.INFORMATION_MESSAGE);
        formularioEstadisticas.guardarEstadistica(new Estadistica(new Usuario("Computador", "", "computador"), 1, 0, 1, 0));
        if (usuarioActual == null) {
            formularioEstadisticas.guardarEstadistica(new Estadistica(new Usuario("Invitado", "", "invitado"), 1, 1, 0, 0));
        } else {
            formularioEstadisticas.guardarEstadistica(new Estadistica(usuarioActual, 1, 1, 0, 0));
        }
    }

    /**
     * Guarda la estadística cuando gana un jugador controlado por el computador.
     */
    public void guardarComputador(Jugador computador) {
        JOptionPane.showInternalMessageDialog(fondo,
                "El jugador " + computador.getNombre() + " " + computador.getApellido() + " ha ganado.",
                "Ganador de la partida", JOptionPane.INFORMATION_MESSAGE);
        formularioEstadisticas.guardarEstadistica(new Estadistica(new Usuario("Computador", "", "computador"), 1, 1, 0, 0));
        if (usuarioActual == null) {
            formularioEstadisticas.guardarEstadistica(new Estadistica(new Usuario("Invitado", "", "invitado"), 1, 0, 1, 0));
        } else {
            formularioEstadisticas.guardarEstadistica(new Estadistica(usuarioActual, 1, 0, 1, 0));
        }
    }

    /**
     * Actualiza el puntaje de los jugadores y determina cuando hay un ganador.
     */
    private void actualizarScore() {
        //Jugadores controlados por computadora.
        for (int i = 0, n = partida.getJugadores().size() - 1; i < n; ++i) {
            Jugador jugador = partida.getJugadores().get(i);
            cartas[i].setText("Cartas: " + jugador.getMano().size());
            if (jugador.getMano().size() == 0) {
                if (partida.getModo() == FormularioPartida.PARTIDA_RAPIDA) {
                    guardarComputador(jugador);
                    salir();
                    return;
                } else {
                    int k = Integer.parseInt(puntos[i].getText());
                    k += partida.calcularPuntos();
                    puntos[i].setText("Puntos: " + k);
                    if (k >= partida.getPuntos()) {
                        guardarComputador(jugador);
                        salir();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(fondo,
                            "El jugador " + jugador.getNombre() + " " + jugador.getApellido() + " ha ganado la ronda.",
                            "Ganador de la ronda", JOptionPane.INFORMATION_MESSAGE);
                    partida.reiniciar();
                    refrescarIndicadores();
                }
            }
        }

        //Jugadores controlados por personas.
        jLabelCartas10.setText("Cartas: " + partida.getUsuarioJugador().getMano().size());
        if (partida.getUsuarioJugador().getMano().size() == 0) {
            if (partida.getModo() == FormularioPartida.PARTIDA_RAPIDA) {
                guardarJugador();
                salir();
                return;
            } else {
                int k = Integer.parseInt(jLabelPuntos10.getText());
                k += partida.calcularPuntos();
                jLabelPuntos10.setText("Puntos: " + k);
                if (k >= partida.getPuntos()) {
                    guardarJugador();
                    salir();
                    return;
                }
                JOptionPane.showInternalMessageDialog(fondo,
                        "El jugador " + partida.getUsuarioJugador().getNombre() + " "
                        + partida.getUsuarioJugador().getApellido() + " ha ganado la ronda.",
                        "Ganador de la ronda", JOptionPane.INFORMATION_MESSAGE);
                partida.reiniciar();
                refrescarIndicadores();
            }
        }
    }

    /**
     * Actualiza la dimensión del panel de las cartas del usuario.
     */
    private void refrescarCartas() {
        int n = partida.getUsuarioJugador().getMano().size();
        jPanelCartas.setPreferredSize(new Dimension(130 * n, jPanelCartas.getHeight()));
        jPanelCartas.setSize(jPanelCartas.getWidth() + 1, jPanelCartas.getHeight());
    }

    /**
     * Actualiza la imagen correspondiente al indicador de sentido.
     */
    private void refrescarSentido() {
        if (partida.getJugadores().getSentido() == ListaJugadores.RELOJ) {
            jLabelSentido.setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/sentidoR.png")));
        } else {
            jLabelSentido.setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/sentidoCR.png")));
        }
    }

    /**
     * Actualiza la imagen correspondiente al color de una carta especial.
     * Determina si se debe transferir la pila descartar en la de robar.
     * Actualiza la imagen correspondiente al descarte.
     */
    private void refrescarIndicadores() {
        refrescarSentido();
        //Color de carta especial.
        if (partida.getColorEspecial().getColor() != null) {
            jLabelColorEspecial.setIcon(new ImageIcon(getClass().getResource("/imagenes/cartas/"
                    + partida.getColorEspecial().getNombre() + partida.getColorEspecial().getColor() + ".png")));
            jLabelColorEspecial.setVisible(true);
            partida.getColorEspecial().setColor(null);
        } else {
            jLabelColorEspecial.setVisible(false);
        }
        //Robar
        if (partida.getRobar().size() <= 20) {
            partida.getRobar().transferir(partida.getDescartar());
        }
        //Descarte.
        jLabelContadorRobar.setText("Cartas:" + partida.getRobar().size());
        if ("+4".equals(partida.getDescartar().peek().getNombre()) || "color".equals(partida.getDescartar().peek().getNombre())) {
            jLabelDescartar.setIcon(new ImageIcon(getClass().getResource("/imagenes/cartas/" + partida.getDescartar().peek().getNombre()
                    + "negro" + ".png")));
        } else {
            jLabelDescartar.setIcon(new ImageIcon(getClass().getResource("/imagenes/cartas/" + partida.getDescartar().peek().getNombre()
                    + partida.getDescartar().peek().getColor() + ".png")));
        }
    }

    /**
     * Crea los listeners correspondientes a las interacciones que recibirán las cartas gráficas
     * del usuario.
     * 
     * @param i Índice de la carta en el panel.
     */
    private void activarCarta(int i) {
        jPanelCartas.getComponent(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jPanelCartas.getComponent(i).addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if (cartasActivas) {
                    me.getComponent().setSize(130, 160);
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (cartasActivas) {
                    me.getComponent().setSize(118, 150);
                    jugar(new Carta(((JLabel) me.getComponent()).getName().split(",")[1],
                            ((JLabel) me.getComponent()).getName().split(",")[0]));
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                me.getComponent().setSize(me.getComponent().getWidth(), 140);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                me.getComponent().setSize(me.getComponent().getWidth(), 160);
            }
        });
    }

    /**
     * Oculta los indicadores de puntos. Este método es llamado en la configuración
     * de partida rápida.
     */
    private void ocultarPuntos() {
        for (int i = 0, n = partida.getJugadores().size() - 1; i < n; ++i) {
            puntos[i].setVisible(false);
        }
        jLabelPuntos10.setVisible(false);
    }

    /**
     * Inicializa la pantalla. Llama a todos los métodos relacionados con la 
     * gestión e inicialización de la pantalla de partida.
     */
    private void initPartida() {
        initComponents();
        initArreglosComponentes();
        initJugadores();
        actualizarJugadores();
        actualizarCartasUsuario();
        refrescarIndicadores();

        this.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent evt) {
                jScrollPaneCartas.setSize((jPanelContenedor.getWidth() * 630) / 876, 170);
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

        secuenciaPartida();
    }

    /**
     * A través de un temporizador llama al método encargado del control del flujo de las jugadas.
     */
    private void secuenciaPartida() {
        Timer temporizador = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                siguiente();
            }
        });
        temporizador.start();
    }

    /**
     * Indica gráficamente el turno del jugador. Y determina si una jugada debe será manejada
     * por computadora o generada por un usuario.
     */
    private void siguiente() {
        for (JPanel panel : jugadores) {
            panel.setBackground(new Color(0x5C0000));
        }
        if (partida.getJugadores().isTurnoUsuario()) {
            cartasActivas = true;
        } else {
            jugadores[partida.getJugadores().jugadorActualIndice()].setBackground(new Color(0xC21500));
            partida.manejarJugadaAutomatica();
            partida.getJugadores().siguiente();
            refrescarIndicadores();
            actualizarScore();
            refrescarCartas();
            actualizarCartasUsuario();
        }
    }

    /**
     * Controla la jugada del usuario.
     * 
     * @param carta Carta a jugar.
     */
    private void jugar(Carta carta) {
        if (partida.manejarJugada(carta)) {
            if ("color".equals(carta.getNombre()) || "+4".equals(carta.getNombre())) {
                esperarSelector();
            } else {
                partida.realizarEfecto(null);
                partida.getJugadores().siguiente();
            }
            refrescarIndicadores();
            refrescarCartas();
            actualizarCartasUsuario();
            actualizarScore();
            cartasActivas = false;
        } else {
            JOptionPane.showInternalMessageDialog(fondo,
                    "Error, no puede jugar esa carta.",
                    "Carta inválida", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Detiene el flujo de la partida, para que el usuario seleccione el color
     * de la carta especial.
     */
    private void esperarSelector() {
        selectorColor.setVisible(true);
        cartasActivas = false;
        Timer temporizador = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                terminarSelector((Timer) ae.getSource());
            }
        });
        temporizador.start();
    }

    /**
     * Reanuda el flujo de la partida, después de que el usuario elige el color
     * de la carta especial.
     * 
     * @param timer Temporizador encargado de verificar si el usuario seleccionó un color.
     */
    private void terminarSelector(Timer timer) {
        if (!"".equals(selectorColor.getSeleccionado())) {
            selectorColor.setVisible(false);
            partida.realizarEfecto(selectorColor.getSeleccionado());
            selectorColor.setSeleccionado("");
            partida.getJugadores().siguiente();
            refrescarIndicadores();
            timer.stop();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelJugadoresTop = new javax.swing.JPanel();
        jPanelJugador2 = new javax.swing.JPanel();
        jLabelNombre2 = new javax.swing.JLabel();
        jLabelAvatar2 = new javax.swing.JLabel();
        jLabelCartas2 = new javax.swing.JLabel();
        jLabelPuntos2 = new javax.swing.JLabel();
        jPanelJugador1 = new javax.swing.JPanel();
        jLabelNombre1 = new javax.swing.JLabel();
        jLabelAvatar1 = new javax.swing.JLabel();
        jLabelCartas1 = new javax.swing.JLabel();
        jLabelPuntos1 = new javax.swing.JLabel();
        jPanelJugador3 = new javax.swing.JPanel();
        jLabelNombre3 = new javax.swing.JLabel();
        jLabelAvatar3 = new javax.swing.JLabel();
        jLabelCartas3 = new javax.swing.JLabel();
        jLabelPuntos3 = new javax.swing.JLabel();
        jPanelJugadoresLeft = new javax.swing.JPanel();
        jPanelJugador4 = new javax.swing.JPanel();
        jLabelNombre4 = new javax.swing.JLabel();
        jLabelAvatar4 = new javax.swing.JLabel();
        jLabelCartas4 = new javax.swing.JLabel();
        jLabelPuntos4 = new javax.swing.JLabel();
        jPanelJugador6 = new javax.swing.JPanel();
        jLabelNombre6 = new javax.swing.JLabel();
        jLabelAvatar6 = new javax.swing.JLabel();
        jLabelCartas6 = new javax.swing.JLabel();
        jLabelPuntos6 = new javax.swing.JLabel();
        jPanelJugador8 = new javax.swing.JPanel();
        jLabelNombre8 = new javax.swing.JLabel();
        jLabelAvatar8 = new javax.swing.JLabel();
        jLabelCartas8 = new javax.swing.JLabel();
        jLabelPuntos8 = new javax.swing.JLabel();
        jPanelJugadoresRight = new javax.swing.JPanel();
        jPanelJugador5 = new javax.swing.JPanel();
        jLabelCartas5 = new javax.swing.JLabel();
        jLabelPuntos5 = new javax.swing.JLabel();
        jLabelNombre5 = new javax.swing.JLabel();
        jLabelAvatar5 = new javax.swing.JLabel();
        jPanelJugador7 = new javax.swing.JPanel();
        jLabelCartas7 = new javax.swing.JLabel();
        jLabelPuntos7 = new javax.swing.JLabel();
        jLabelNombre7 = new javax.swing.JLabel();
        jLabelAvatar7 = new javax.swing.JLabel();
        jPanelJugador9 = new javax.swing.JPanel();
        jLabelCartas9 = new javax.swing.JLabel();
        jLabelPuntos9 = new javax.swing.JLabel();
        jLabelNombre9 = new javax.swing.JLabel();
        jLabelAvatar9 = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        jPanelSeparadorTop = new javax.swing.JPanel();
        jLabelColorEspecial = new javax.swing.JLabel();
        jLabelDescartar = new javax.swing.JLabel();
        jLabeRobar = new javax.swing.JLabel();
        jPanelFondo = new javax.swing.JPanel();
        jLabelContadorRobar = new javax.swing.JLabel();
        jPanelSeparadorCenter = new javax.swing.JPanel();
        jButtonDesafiar = new javax.swing.JButton();
        jLabelSentido = new javax.swing.JLabel();
        jButtonUno = new javax.swing.JButton();
        jScrollPaneCartas = new javax.swing.JScrollPane();
        jPanelCartas = new javax.swing.JPanel();
        jPaneFondol1 = new javax.swing.JPanel();
        jLabelCartas10 = new javax.swing.JLabel();
        jLabelPuntos10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelJugadoresTop.setMinimumSize(new java.awt.Dimension(300, 150));
        jPanelJugadoresTop.setOpaque(false);
        jPanelJugadoresTop.setPreferredSize(new java.awt.Dimension(300, 150));

        jPanelJugador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador2.setPreferredSize(new java.awt.Dimension(100, 140));

        jLabelNombre2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre2.setText("Jugador");
        jLabelNombre2.setPreferredSize(new java.awt.Dimension(90, 17));
        jPanelJugador2.add(jLabelNombre2);

        jLabelAvatar2.setPreferredSize(new java.awt.Dimension(64, 64));
        jPanelJugador2.add(jLabelAvatar2);

        jLabelCartas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCartas2.setText("Cartas: ");
        jLabelCartas2.setPreferredSize(new java.awt.Dimension(64, 14));
        jPanelJugador2.add(jLabelCartas2);

        jLabelPuntos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPuntos2.setText("Puntos:0 ");
        jLabelPuntos2.setPreferredSize(new java.awt.Dimension(64, 14));
        jPanelJugador2.add(jLabelPuntos2);

        jPanelJugadoresTop.add(jPanelJugador2);

        jPanelJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador1.setPreferredSize(new java.awt.Dimension(100, 140));

        jLabelNombre1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre1.setText("Jugador");
        jLabelNombre1.setPreferredSize(new java.awt.Dimension(90, 17));
        jPanelJugador1.add(jLabelNombre1);

        jLabelAvatar1.setPreferredSize(new java.awt.Dimension(64, 64));
        jPanelJugador1.add(jLabelAvatar1);

        jLabelCartas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCartas1.setText("Cartas: ");
        jLabelCartas1.setPreferredSize(new java.awt.Dimension(64, 14));
        jPanelJugador1.add(jLabelCartas1);

        jLabelPuntos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPuntos1.setText("Puntos:0 ");
        jLabelPuntos1.setPreferredSize(new java.awt.Dimension(64, 14));
        jPanelJugador1.add(jLabelPuntos1);

        jPanelJugadoresTop.add(jPanelJugador1);

        jPanelJugador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador3.setPreferredSize(new java.awt.Dimension(100, 140));

        jLabelNombre3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre3.setText("Jugador");
        jLabelNombre3.setPreferredSize(new java.awt.Dimension(90, 17));
        jPanelJugador3.add(jLabelNombre3);

        jLabelAvatar3.setPreferredSize(new java.awt.Dimension(64, 64));
        jPanelJugador3.add(jLabelAvatar3);

        jLabelCartas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCartas3.setText("Cartas: ");
        jLabelCartas3.setPreferredSize(new java.awt.Dimension(64, 14));
        jPanelJugador3.add(jLabelCartas3);

        jLabelPuntos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPuntos3.setText("Puntos:0 ");
        jLabelPuntos3.setPreferredSize(new java.awt.Dimension(64, 14));
        jPanelJugador3.add(jLabelPuntos3);

        jPanelJugadoresTop.add(jPanelJugador3);

        jPanelJugadoresLeft.setMaximumSize(new java.awt.Dimension(175, 534));
        jPanelJugadoresLeft.setMinimumSize(new java.awt.Dimension(175, 534));
        jPanelJugadoresLeft.setOpaque(false);
        jPanelJugadoresLeft.setPreferredSize(new java.awt.Dimension(175, 534));

        jPanelJugador4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador4.setPreferredSize(new java.awt.Dimension(168, 104));

        jLabelNombre4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNombre4.setText("Jugador");
        jLabelNombre4.setPreferredSize(new java.awt.Dimension(90, 17));

        jLabelAvatar4.setPreferredSize(new java.awt.Dimension(64, 64));

        jLabelCartas4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCartas4.setText("Cartas: ");
        jLabelCartas4.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelPuntos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPuntos4.setText("Puntos:0 ");
        jLabelPuntos4.setPreferredSize(new java.awt.Dimension(64, 14));

        javax.swing.GroupLayout jPanelJugador4Layout = new javax.swing.GroupLayout(jPanelJugador4);
        jPanelJugador4.setLayout(jPanelJugador4Layout);
        jPanelJugador4Layout.setHorizontalGroup(
            jPanelJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador4Layout.createSequentialGroup()
                .addGroup(jPanelJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCartas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelJugador4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelJugador4Layout.setVerticalGroup(
            jPanelJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabelNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanelJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador4Layout.createSequentialGroup()
                        .addComponent(jLabelCartas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelJugadoresLeft.add(jPanelJugador4);

        jPanelJugador6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador6.setPreferredSize(new java.awt.Dimension(168, 104));

        jLabelNombre6.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNombre6.setText("Jugador");
        jLabelNombre6.setPreferredSize(new java.awt.Dimension(90, 17));

        jLabelAvatar6.setPreferredSize(new java.awt.Dimension(64, 64));

        jLabelCartas6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCartas6.setText("Cartas: ");
        jLabelCartas6.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelPuntos6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPuntos6.setText("Puntos:0 ");
        jLabelPuntos6.setPreferredSize(new java.awt.Dimension(64, 14));

        javax.swing.GroupLayout jPanelJugador6Layout = new javax.swing.GroupLayout(jPanelJugador6);
        jPanelJugador6.setLayout(jPanelJugador6Layout);
        jPanelJugador6Layout.setHorizontalGroup(
            jPanelJugador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador6Layout.createSequentialGroup()
                .addGroup(jPanelJugador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelAvatar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelJugador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCartas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPuntos6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelJugador6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelJugador6Layout.setVerticalGroup(
            jPanelJugador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabelNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanelJugador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador6Layout.createSequentialGroup()
                        .addComponent(jLabelCartas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPuntos6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAvatar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelJugadoresLeft.add(jPanelJugador6);

        jPanelJugador8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador8.setPreferredSize(new java.awt.Dimension(168, 104));

        jLabelNombre8.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNombre8.setText("Jugador");
        jLabelNombre8.setPreferredSize(new java.awt.Dimension(90, 17));

        jLabelAvatar8.setPreferredSize(new java.awt.Dimension(64, 64));

        jLabelCartas8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCartas8.setText("Cartas: ");
        jLabelCartas8.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelPuntos8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPuntos8.setText("Puntos:0 ");
        jLabelPuntos8.setPreferredSize(new java.awt.Dimension(64, 14));

        javax.swing.GroupLayout jPanelJugador8Layout = new javax.swing.GroupLayout(jPanelJugador8);
        jPanelJugador8.setLayout(jPanelJugador8Layout);
        jPanelJugador8Layout.setHorizontalGroup(
            jPanelJugador8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador8Layout.createSequentialGroup()
                .addGroup(jPanelJugador8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador8Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelAvatar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelJugador8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCartas8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPuntos8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelJugador8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNombre8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelJugador8Layout.setVerticalGroup(
            jPanelJugador8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabelNombre8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanelJugador8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador8Layout.createSequentialGroup()
                        .addComponent(jLabelCartas8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPuntos8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAvatar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelJugadoresLeft.add(jPanelJugador8);

        jPanelJugadoresRight.setMaximumSize(new java.awt.Dimension(182, 534));
        jPanelJugadoresRight.setMinimumSize(new java.awt.Dimension(182, 534));
        jPanelJugadoresRight.setOpaque(false);
        jPanelJugadoresRight.setPreferredSize(new java.awt.Dimension(182, 534));

        jPanelJugador5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador5.setPreferredSize(new java.awt.Dimension(168, 104));

        jLabelCartas5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCartas5.setText("Cartas: ");
        jLabelCartas5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelCartas5.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelPuntos5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPuntos5.setText("Puntos:0 ");
        jLabelPuntos5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelPuntos5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelPuntos5.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelNombre5.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre5.setText("Jugador");
        jLabelNombre5.setPreferredSize(new java.awt.Dimension(90, 17));

        jLabelAvatar5.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanelJugador5Layout = new javax.swing.GroupLayout(jPanelJugador5);
        jPanelJugador5.setLayout(jPanelJugador5Layout);
        jPanelJugador5Layout.setHorizontalGroup(
            jPanelJugador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelJugador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCartas5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPuntos5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabelAvatar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelJugador5Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabelNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelJugador5Layout.setVerticalGroup(
            jPanelJugador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabelNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelJugador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador5Layout.createSequentialGroup()
                        .addComponent(jLabelCartas5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPuntos5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAvatar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelJugadoresRight.add(jPanelJugador5);

        jPanelJugador7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador7.setPreferredSize(new java.awt.Dimension(168, 104));

        jLabelCartas7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCartas7.setText("Cartas: ");
        jLabelCartas7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelCartas7.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelPuntos7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPuntos7.setText("Puntos:0 ");
        jLabelPuntos7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelPuntos7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelPuntos7.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelNombre7.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre7.setText("Jugador");
        jLabelNombre7.setPreferredSize(new java.awt.Dimension(90, 17));

        jLabelAvatar7.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanelJugador7Layout = new javax.swing.GroupLayout(jPanelJugador7);
        jPanelJugador7.setLayout(jPanelJugador7Layout);
        jPanelJugador7Layout.setHorizontalGroup(
            jPanelJugador7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelJugador7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCartas7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPuntos7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabelAvatar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelJugador7Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabelNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelJugador7Layout.setVerticalGroup(
            jPanelJugador7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabelNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelJugador7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador7Layout.createSequentialGroup()
                        .addComponent(jLabelCartas7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPuntos7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAvatar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelJugadoresRight.add(jPanelJugador7);

        jPanelJugador9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanelJugador9.setPreferredSize(new java.awt.Dimension(168, 104));

        jLabelCartas9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCartas9.setText("Cartas: ");
        jLabelCartas9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelCartas9.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelPuntos9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPuntos9.setText("Puntos: ");
        jLabelPuntos9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelPuntos9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelPuntos9.setPreferredSize(new java.awt.Dimension(64, 14));

        jLabelNombre9.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelNombre9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre9.setText("Jugador");
        jLabelNombre9.setPreferredSize(new java.awt.Dimension(90, 17));

        jLabelAvatar9.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanelJugador9Layout = new javax.swing.GroupLayout(jPanelJugador9);
        jPanelJugador9.setLayout(jPanelJugador9Layout);
        jPanelJugador9Layout.setHorizontalGroup(
            jPanelJugador9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelJugador9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCartas9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPuntos9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabelAvatar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelJugador9Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabelNombre9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelJugador9Layout.setVerticalGroup(
            jPanelJugador9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugador9Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabelNombre9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelJugador9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugador9Layout.createSequentialGroup()
                        .addComponent(jLabelCartas9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPuntos9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAvatar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelJugadoresRight.add(jPanelJugador9);

        jPanelContenedor.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanelContenedor.setOpaque(false);
        jPanelContenedor.setPreferredSize(new java.awt.Dimension(876, 534));

        jPanelSeparadorTop.setOpaque(false);
        jPanelSeparadorTop.setPreferredSize(new java.awt.Dimension(1005, 20));

        javax.swing.GroupLayout jPanelSeparadorTopLayout = new javax.swing.GroupLayout(jPanelSeparadorTop);
        jPanelSeparadorTop.setLayout(jPanelSeparadorTopLayout);
        jPanelSeparadorTopLayout.setHorizontalGroup(
            jPanelSeparadorTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        jPanelSeparadorTopLayout.setVerticalGroup(
            jPanelSeparadorTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanelContenedor.add(jPanelSeparadorTop);

        jLabelColorEspecial.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelColorEspecial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cartas/baseamarillo.png"))); // NOI18N
        jLabelColorEspecial.setAlignmentY(0.0F);
        jLabelColorEspecial.setMaximumSize(new java.awt.Dimension(118, 145));
        jLabelColorEspecial.setMinimumSize(new java.awt.Dimension(118, 145));
        jLabelColorEspecial.setPreferredSize(new java.awt.Dimension(118, 145));
        jPanelContenedor.add(jLabelColorEspecial);

        jLabelDescartar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cartas/+2verde.png"))); // NOI18N
        jLabelDescartar.setAlignmentY(0.0F);
        jLabelDescartar.setMaximumSize(new java.awt.Dimension(118, 145));
        jLabelDescartar.setMinimumSize(new java.awt.Dimension(118, 145));
        jLabelDescartar.setPreferredSize(new java.awt.Dimension(118, 145));
        jPanelContenedor.add(jLabelDescartar);

        jLabeRobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/mazo.png"))); // NOI18N
        jLabeRobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabeRobar.setMaximumSize(new java.awt.Dimension(130, 150));
        jLabeRobar.setMinimumSize(new java.awt.Dimension(130, 150));
        jLabeRobar.setPreferredSize(new java.awt.Dimension(130, 150));
        jLabeRobar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                robar(evt);
            }
        });
        jPanelContenedor.add(jLabeRobar);

        jPanelFondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabelContadorRobar.setText("Robar: 0");
        jPanelFondo.add(jLabelContadorRobar);

        jPanelContenedor.add(jPanelFondo);

        jPanelSeparadorCenter.setMaximumSize(new java.awt.Dimension(1280, 100));
        jPanelSeparadorCenter.setMinimumSize(new java.awt.Dimension(110, 100));
        jPanelSeparadorCenter.setOpaque(false);
        jPanelSeparadorCenter.setPreferredSize(new java.awt.Dimension(1280, 100));

        jButtonDesafiar.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButtonDesafiar.setText("Desafiar");
        jButtonDesafiar.setPreferredSize(new java.awt.Dimension(120, 80));
        jButtonDesafiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesafiarActionPerformed(evt);
            }
        });
        jPanelSeparadorCenter.add(jButtonDesafiar);

        jLabelSentido.setMaximumSize(new java.awt.Dimension(118, 105));
        jLabelSentido.setMinimumSize(new java.awt.Dimension(118, 105));
        jLabelSentido.setPreferredSize(new java.awt.Dimension(118, 105));
        jPanelSeparadorCenter.add(jLabelSentido);

        jButtonUno.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButtonUno.setText("¡UNO!");
        jButtonUno.setPreferredSize(new java.awt.Dimension(120, 80));
        jButtonUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnoActionPerformed(evt);
            }
        });
        jPanelSeparadorCenter.add(jButtonUno);

        jPanelContenedor.add(jPanelSeparadorCenter);

        jScrollPaneCartas.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPaneCartas.setDoubleBuffered(true);
        jScrollPaneCartas.setMaximumSize(new java.awt.Dimension(630, 170));
        jScrollPaneCartas.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPaneCartas.setOpaque(false);
        jScrollPaneCartas.setPreferredSize(new java.awt.Dimension(630, 170));

        jPanelCartas.setMaximumSize(new java.awt.Dimension(22000, 160));
        jPanelCartas.setOpaque(false);
        jPanelCartas.setPreferredSize(new java.awt.Dimension(860, 160));
        jPanelCartas.setLayout(new javax.swing.BoxLayout(jPanelCartas, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPaneCartas.setViewportView(jPanelCartas);

        jPanelContenedor.add(jScrollPaneCartas);

        jPaneFondol1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPaneFondol1.setPreferredSize(new java.awt.Dimension(65, 45));

        jLabelCartas10.setText("Cartas: 7");
        jPaneFondol1.add(jLabelCartas10);

        jLabelPuntos10.setText("Puntos: 0");
        jPaneFondol1.add(jLabelPuntos10);

        jPanelContenedor.add(jPaneFondol1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelJugadoresTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1269, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelJugadoresLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelJugadoresRight, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelJugadoresTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelJugadoresLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelJugadoresRight, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Solicita a la instancia de Partida que maneje la lógica asociada al robo de una carta.
     * @param evt 
     */
    private void robar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_robar
        if (cartasActivas) {
            Carta carta = partida.getRobar().peek();
            String[] opciones = {"Si", "No"};
            int respuesta = JOptionPane.NO_OPTION;
            if (carta.coincide(partida.getDescartar().peek())) {
                respuesta = JOptionPane.showInternalOptionDialog(fondo,
                        "Desea jugar la carta " + carta.getNombre() + " " + carta.getColor(),
                        "Puede jugar esta carta",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);
            }
            if (partida.robarCarta(respuesta)) {
                esperarSelector();
            }
            refrescarIndicadores();
            refrescarCartas();
            actualizarCartasUsuario();
            cartasActivas = false;
        }
    }//GEN-LAST:event_robar

    /**
     * Solicita a la instancia de Partida que maneje la lógica asociada al desafío.
     * @param evt 
     */
    private void jButtonDesafiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesafiarActionPerformed
        if (cartasActivas) {
            if (partida.desafiar()) {
                JOptionPane.showInternalMessageDialog(fondo,
                        "El jugador jugo la carta ilegalmente",
                        "Desafío", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showInternalMessageDialog(fondo,
                        "El jugador jugo la carta correctamente",
                        "Desafío", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonDesafiarActionPerformed

    /**
     * Maneja la acción "cantar uno" del usuario.
     * @param evt 
     */
    private void jButtonUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnoActionPerformed
        partida.setUno(true);
    }//GEN-LAST:event_jButtonUnoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDesafiar;
    private javax.swing.JButton jButtonUno;
    private javax.swing.JLabel jLabeRobar;
    private javax.swing.JLabel jLabelAvatar1;
    private javax.swing.JLabel jLabelAvatar2;
    private javax.swing.JLabel jLabelAvatar3;
    private javax.swing.JLabel jLabelAvatar4;
    private javax.swing.JLabel jLabelAvatar5;
    private javax.swing.JLabel jLabelAvatar6;
    private javax.swing.JLabel jLabelAvatar7;
    private javax.swing.JLabel jLabelAvatar8;
    private javax.swing.JLabel jLabelAvatar9;
    private javax.swing.JLabel jLabelCartas1;
    private javax.swing.JLabel jLabelCartas10;
    private javax.swing.JLabel jLabelCartas2;
    private javax.swing.JLabel jLabelCartas3;
    private javax.swing.JLabel jLabelCartas4;
    private javax.swing.JLabel jLabelCartas5;
    private javax.swing.JLabel jLabelCartas6;
    private javax.swing.JLabel jLabelCartas7;
    private javax.swing.JLabel jLabelCartas8;
    private javax.swing.JLabel jLabelCartas9;
    private javax.swing.JLabel jLabelColorEspecial;
    private javax.swing.JLabel jLabelContadorRobar;
    private javax.swing.JLabel jLabelDescartar;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombre4;
    private javax.swing.JLabel jLabelNombre5;
    private javax.swing.JLabel jLabelNombre6;
    private javax.swing.JLabel jLabelNombre7;
    private javax.swing.JLabel jLabelNombre8;
    private javax.swing.JLabel jLabelNombre9;
    private javax.swing.JLabel jLabelPuntos1;
    private javax.swing.JLabel jLabelPuntos10;
    private javax.swing.JLabel jLabelPuntos2;
    private javax.swing.JLabel jLabelPuntos3;
    private javax.swing.JLabel jLabelPuntos4;
    private javax.swing.JLabel jLabelPuntos5;
    private javax.swing.JLabel jLabelPuntos6;
    private javax.swing.JLabel jLabelPuntos7;
    private javax.swing.JLabel jLabelPuntos8;
    private javax.swing.JLabel jLabelPuntos9;
    private javax.swing.JLabel jLabelSentido;
    private javax.swing.JPanel jPaneFondol1;
    private javax.swing.JPanel jPanelCartas;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelJugador1;
    private javax.swing.JPanel jPanelJugador2;
    private javax.swing.JPanel jPanelJugador3;
    private javax.swing.JPanel jPanelJugador4;
    private javax.swing.JPanel jPanelJugador5;
    private javax.swing.JPanel jPanelJugador6;
    private javax.swing.JPanel jPanelJugador7;
    private javax.swing.JPanel jPanelJugador8;
    private javax.swing.JPanel jPanelJugador9;
    private javax.swing.JPanel jPanelJugadoresLeft;
    private javax.swing.JPanel jPanelJugadoresRight;
    private javax.swing.JPanel jPanelJugadoresTop;
    private javax.swing.JPanel jPanelSeparadorCenter;
    private javax.swing.JPanel jPanelSeparadorTop;
    private javax.swing.JScrollPane jScrollPaneCartas;
    // End of variables declaration//GEN-END:variables
}
