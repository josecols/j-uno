package juego;

import java.util.ArrayList;
import java.util.Random;

/**
 * Agrupa todos los elementos del tipo Jugador para su manipulación en conjunto.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class ListaJugadores extends ArrayList<Jugador> {

    public static final int RELOJ = 1;
    public static final int CONTRA_RELOJ = -1;
    private final String nombres[] = {"José", "Larisa", "Juan", "María", "Daniel", "Marie", "David", "Carolina", "Jesús", "Valentina", "Pedro", "Paola"};
    private final String apellidos[] = {"Cols", "Méndez", "Giorgianni", "Díaz", "Vera", "Parra", "Matheus", "Ortega", "Neruda", "Borges", "Peréz", "Medina"};
    private final int posiciones[] = {0, 2, 4, 6, 8, 9, 7, 5, 3, 1};
    private int secuencia[];
    private int sentido;
    private int jugadorPointer;

    /**
     * Reserva espacio para 10 jugadores, ya que este valor es el máximo
     * de jugadores en el juego.
     */
    public ListaJugadores() {
        super(10);
    }

    /**
     * Crea una lista de jugadores a partir de otra dada.
     * @param jugadores Lista base.
     */
    public ListaJugadores(ListaJugadores jugadores) {
        super(jugadores);
    }

    /**
     * Copia la lista dada en un nuevo espacio de memoria.
     * 
     * @param lista Lista a copiar
     * @return Copia de la lista dada.
     */
    public static ListaJugadores copiarLista(ListaJugadores lista) {
        return new ListaJugadores(lista);
    }

    /**
     * Genera un nuevo jugador con nombre y apellido obtenidos aleatoriamente.
     * El avatar es el predeterminado.
     * 
     * @return Nuevo jugador.
     */
    public Jugador generarJugador() {
        return new Jugador(nombres[new Random().nextInt(9)], apellidos[new Random().nextInt(9)],
                new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/avatar.png"), "/imagenes/iconos/avatar.png"));
    }

    /**
     * Agrega a la lista un número de jugadores generados aleatoriamente.
     * 
     * @param cantidad Número de jugadores que contendrá la lista.
     */
    public void generarJugadores(int cantidad) {
        if (cantidad > 0 && cantidad < 10) {
            for (int i = 0; i < cantidad; ++i) {
                this.add(i, generarJugador());
            }
        }
    }

    /**
     * Determina qué jugador es el siguiente en la secuencia.
     * 
     * @return Índice del siguiente jugador en la secuencia.
     */
    public int getSiguiente() {
        if (sentido == RELOJ) {
            return (jugadorPointer == this.size() - 1) ? (0) : (jugadorPointer + 1);
        }
        return (jugadorPointer == 0) ? (this.size() - 1) : (jugadorPointer - 1);
    }

    /**
     * Determina qué jugador es el anterior en la secuencia.
     * 
     * @return Índice del anterior jugador en la secuencia.
     */
    public int getAnterior() {
        if (sentido == RELOJ) {
            return (jugadorPointer == 0) ? (this.size() - 1) : (jugadorPointer - 1);
        }
        return (jugadorPointer == this.size() - 1) ? (0) : (jugadorPointer + 1);
    }

    /**
     * Determina qué jugador es el siguiente en la secuencia.
     * 
     * @return Siguiente jugador en la secuencia.
     */
    public Jugador getSiguienteJugador() {
        return this.get(secuencia[getSiguiente()]);
    }

    /**
     * Determina qué jugador es el anterior en la secuencia.
     * 
     * @return Jugador anterior en la secuencia.
     */
    public Jugador getAnteriorJugador() {
        return this.get(secuencia[getAnterior()]);
    }

    /**
     * Avanza el puntero de jugador actual.
     */
    public void siguiente() {
        jugadorPointer = getSiguiente();
    }

    /**
     * Define la secuencia de los turnos de los jugadores en la lista.
     */
    private void definirSecuencia() {
        int n = this.size();
        for (int j = 0, i = 0; j < 10; ++j) {
            if (posiciones[j] < n && i < n) {
                secuencia[i++] = posiciones[j];
            }
        }
    }

    /**
     * Reinicia el ciclo de turnos.
     */
    public void reiniciarCiclo() {
        sentido = CONTRA_RELOJ;
        jugadorPointer = 0;
        secuencia = new int[this.size()];
        definirSecuencia();

    }

    /**
     * Borra todas las cartas de todos los jugadores en la lista.
     */
    public void limpiarManos() {
        for (Jugador jugador : this) {
            jugador.getMano().removeAll(jugador.getMano());
        }
    }

    /**
     * Retorna el jugador que le corresponde jugar.
     * 
     * @return Jugador actual.
     */
    public Jugador jugadorActual() {
        return this.get(secuencia[jugadorPointer]);
    }

    /**
     * Retorna el índice del jugador que le corresponde jugar.
     * 
     * @return Índice del jugador actual.
     */
    public int jugadorActualIndice() {
        return secuencia[jugadorPointer];
    }

    /**
     * Determina si el turno actual corresponde al jugador humano
     * 
     * @return Resultado de la comprobación.
     */
    public boolean isTurnoUsuario() {
        return (secuencia[jugadorPointer] == this.size() - 1);
    }

    //Getters y Setters.
    public int getSentido() {
        return sentido;
    }

    public void setSentido(int sentido) {
        this.sentido = sentido;
    }

    public int getJugadorPointer() {
        return jugadorPointer;
    }

    public void setJugadorPointer(int jugadorPointer) {
        this.jugadorPointer = jugadorPointer;
    }

    public int[] getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int[] secuencia) {
        this.secuencia = secuencia;
    }
}
