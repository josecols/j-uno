package juego;

import javax.swing.ImageIcon;

/**
 * Extensión de la clase Usuario para incorporar la mano asociada y
 * ocultar atributos no primordiales durante la ejecución del juego.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class Jugador extends Usuario {

    private Mano mano;

    public Jugador() {
    }

    /**
     * Crea un nuevo jugador con memoria reservada para su mano de cartas,
     * la cual será establecida luego de la construcción del jugador.
     * 
     * @param nombre Nombre del jugador.
     * @param apellido Apellido del jugador.
     * @param avatar Avatar del jugador.
     */
    public Jugador(String nombre, String apellido, ImageIcon avatar) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.avatar = avatar;
        this.mano = new Mano();
    }

    /**
     * Devuelve al usuario dado con la estructura de Jugador
     * @param usuario Usuario a transformar.
     * @return Usuario transformado como Jugador.
     */
    public static Jugador asJugador(juego.Usuario usuario) {
        return new Jugador(usuario.getNombre(), usuario.getApellido(), usuario.getAvatar());
    }

    /**
     * Agrega una carta a la mano del jugador.
     * @param carta Carta a anexar.
     */
    public void agragarAMano(Carta carta) {
        mano.add(carta);
    }

    /**
     * Remueve todos las cartas existentes de la mano del jugador.
     */
    public void limpiarMano() {
        if (mano.size() > 0) {
            mano.clear();
        }
    }

    /**
     * Busca una jugada que se pueda realizar.
     * 
     * @param descarte Carta a comparar.
     * @return Índice de la carta que se puede jugar o -1 en caso de que no exista ninguna
     * jugada posible.
     */
    public int jugadaPosible(Carta descarte) {
        for (int i = 0, n = mano.size(); i < n; ++i) {
            if (mano.get(i).coincide(descarte)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Juega la carta dada.
     * 
     * @param carta Índice de la carta a jugar.
     */
    public void jugar(int carta) {
        mano.remove(carta);
    }

    /**
     * Juega la carta dada, verificando antes si es posible jugarla.
     * 
     * @param carta Carta a jugar.
     * @param descarte Carta a comparar.
     * @return Resultado de la verificación.
     */
    public boolean jugar(Carta carta, Carta descarte) {
        if (carta.coincide(descarte)) {
            mano.eliminar(carta);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return (this.getNombre() + " " + this.getApellido());
    }

    //Getters y Setters.
    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }
}
