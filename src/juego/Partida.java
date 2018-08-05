package juego;

import java.util.Iterator;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Contiene los datos y metodos necesarios para llevar a cabo una partida lógica.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class Partida {

    private ListaJugadores jugadores;
    private int modo;
    private int puntos;
    private int turnoInicial;
    private Carta colorEspecial;
    private PilaCartas robar;
    private PilaCartas descartar;
    private boolean uno;

    /**
     * Crea una nueva partida, inicializando los valores de las pilas de cartas
     * principales del juego. La pila robar, que contiene en primera instancia todas las cartas,
     * es barajada.
     */
    public Partida() {
        descartar = new PilaCartas();
        robar = new PilaCartas(PilaCartas.mazoCompleto());
        robar.barajar();
        uno = false;
        colorEspecial = new Carta(null, "base");
    }

    /**
     * Reinicia todos los atributos de la partida. 
     * Reparte las cartas y asigna el turno inicial.
     */
    public void reiniciar() {
        descartar = new PilaCartas();
        robar = new PilaCartas(PilaCartas.mazoCompleto());
        robar.barajar();
        uno = false;
        colorEspecial = new Carta(null, "base");
        jugadores.limpiarManos();
        jugadores.setJugadorPointer(++turnoInicial);
        repartir();
    }

    /**
     * Reparte 7 cartas a cada usuario y la carta inicial de la pila descartar.
     * Emula el algoritmo humano para repartir las cartas en un juego de UNO real.
     */
    public void repartir() {
        for (Iterator<Jugador> it = jugadores.iterator(); it.hasNext();) {
            Jugador jugador = it.next();
            jugador.limpiarMano();
        }
        for (int i = 0; i < 7; ++i) {
            for (Iterator<Jugador> it = jugadores.iterator(); it.hasNext();) {
                Jugador jugador = it.next();
                jugador.agragarAMano(robar.pop());
            }
        }
        while ("+4".equals(robar.peek().getNombre())) {
            robar.add(0, robar.pop());
        }
        descartar.add(robar.pop());
        if ("color".equals(descartar.peek().getNombre())) {
            realizarEfecto(PilaCartas.COLORES[new Random().nextInt(4)]);
        } else {
            realizarEfecto(null);
        }
    }

    /**
     * Maneja la jugada de una carta de la mano de un usuario.
     * 
     * @param carta Carta a jugar.
     * @return Verdadero en caso de que la jugada sea exitosa, falso en el caso contrario.
     */
    public boolean manejarJugada(Carta carta) {
        if (jugadores.jugadorActual().jugar(carta, descartar.peek())) {
            descartar.push(carta);
            //Cantar uno.
            if (jugadores.jugadorActual().getMano().size() == 1 && !uno) {
                for (int i = 0; i < 2; ++i) {
                    jugadores.jugadorActual().agragarAMano(robar.pop());
                }
            } else if (uno) {
                uno = false;
            }
            return true;
        }
        return false;
    }

    /**
     * Maneja la jugada de una carta robada por un usuario.
     * 
     * @param respuesta Posición del usuario respecto a jugar la carta robada.
     * @return Verdadero en caso de que la jugada sea exitosa, falso en el caso contrario.
     */
    public boolean robarCarta(int respuesta) {
        if (respuesta == JOptionPane.YES_OPTION) {
            if ("color".equals(robar.peek().getNombre()) || "+4".equals(robar.peek().getNombre())) {
                descartar.push(robar.pop());
                return true;
            } else {
                descartar.push(robar.pop());
                realizarEfecto(null);
                jugadores.siguiente();
            }
        } else {
            this.getUsuarioJugador().getMano().add(robar.pop());
            jugadores.siguiente();
        }
        return false;
    }

    /**
     * Lleva a cabo la jugada de un computador.
     */
    public void manejarJugadaAutomatica() {
        int i;
        Carta carta;
        if ((i = jugadores.jugadorActual().jugadaPosible(descartar.peek())) != -1) {
            carta = jugadores.jugadorActual().getMano().get(i);
            descartar.push(carta);
            jugadores.jugadorActual().jugar(i);
            if ("color".equals(carta.getNombre()) || "+4".equals(carta.getNombre())) {
                realizarEfecto(PilaCartas.COLORES[new Random().nextInt(4)]);
            } else {
                realizarEfecto(null);
            }
        } else {
            if (robar.peek().coincide(descartar.peek())) {
                descartar.push(carta = robar.pop());
                if ("color".equals(carta.getNombre()) || "+4".equals(carta.getNombre())) {
                    realizarEfecto(PilaCartas.COLORES[new Random().nextInt(4)]);
                } else {
                    realizarEfecto(null);
                }
            } else {
                jugadores.jugadorActual().agragarAMano(robar.pop());
            }
        }
    }

    /**
     * Si la carta jugada es especial se realiza la acción asociada
     * a dicha carta. 
     * 
     * @param color Color de la carta especial (Sólo para +4 y cambia color).
     */
    public void realizarEfecto(String color) {
        //+2.
        if ("+2".equals(descartar.peek().getNombre())) {
            for (int i = 0; i < 2; ++i) {
                jugadores.getSiguienteJugador().agragarAMano(robar.pop());
            }
        }
        //+4.
        if ("+4".equals(descartar.peek().getNombre())) {
            for (int i = 0; i < 4; ++i) {
                jugadores.getSiguienteJugador().agragarAMano(robar.pop());
            }
            descartar.peek().setColor(color);
            colorEspecial.setColor(color);
        }
        //Cambia color.
        if ("color".equals(descartar.peek().getNombre())) {
            descartar.peek().setColor(color);
            colorEspecial.setColor(color);
        }
        //Cambia sentido.
        if ("reversa".equals(descartar.peek().getNombre())) {
            jugadores.setSentido(jugadores.getSentido() * -1);
        }
        //Pierde turno.
        if ("salta".equals(descartar.peek().getNombre())) {
            jugadores.siguiente();
        }
    }

    /**
     * Calcula el total de los puntos correspondientes al jugador ganador de la ronda.
     * 
     * @return Total de puntos.
     */
    public int calcularPuntos() {
        int total = 0;
        for (Jugador jugador : jugadores) {
            total += jugador.getMano().sumarCartas();
        }
        return total;
    }

    /**
     * Maneja lógicamente el desafío (+4) enviado por el usuario al jugador anterior.
     * 
     * @return Verdadero en caso de que la jugada sea ilegal. Falso en el caso contrario.
     */
    public boolean desafiar() {
        if ("+4".equals(descartar.peek().getNombre())) {
            if (jugadores.getAnteriorJugador().jugadaPosible(descartar.get(descartar.size() - 2)) != -1) {
                for (int i = this.getUsuarioJugador().getMano().size() - 1, j = i - 4; i > j; --i) {
                    jugadores.getAnteriorJugador().agragarAMano(this.getUsuarioJugador().getMano().get(i));
                    this.getUsuarioJugador().getMano().remove(i);
                }
                return true;
            }
        }
        return false;
    }

    //Getters y Setters.
    public PilaCartas getDescartar() {
        return descartar;
    }

    public void setDescartar(PilaCartas descartar) {
        this.descartar = descartar;
    }

    public ListaJugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaJugadores jugadores) {
        this.jugadores = jugadores;
    }

    public PilaCartas getRobar() {
        return robar;
    }

    public void setRobar(PilaCartas robar) {
        this.robar = robar;
    }

    public Jugador getUsuarioJugador() {
        return jugadores.get(jugadores.size() - 1);
    }

    public Carta getColorEspecial() {
        return colorEspecial;
    }

    public void setColorEspecial(Carta colorEspecial) {
        this.colorEspecial = colorEspecial;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public boolean isUno() {
        return uno;
    }

    public void setUno(boolean uno) {
        this.uno = uno;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
