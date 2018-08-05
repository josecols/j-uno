package juego;

import java.util.ArrayList;

/**
 * Agrupa todos los elementos del tipo Carta para su manipulación en conjunto,
 * por un jugador.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class Mano extends ArrayList<Carta> {

    /**
     * Reserva espacio para 86 cartas ya que este es el valor máximo
     * de cartas que puede tener un jugador durante la ejecución de
     * una partida.
     */
    public Mano() {
        super(86);
    }

    /**
     * Verifica si una carta dada está contenida en la lista.
     * 
     * @param carta1 Carta a comprobar.
     * @return Resultado de la comprobación.
     */
    public boolean contiene(Carta carta1) {
        for (Carta carta : this) {
            if (carta.getNombre().equals(carta1.getNombre()));
            return true;
        }
        return false;
    }
    
    /**
     * Suma el valor de todas las cartas en la mano.
     * 
     * @return Suma del valor de todas las cartas en la mano.
     */
    public int sumarCartas() {
        int valor = 0;
        for (Carta carta : this) {
            valor += carta.valor();
        }
        return valor;
    }

    /**
     * Elimina una carta dada de la mano.
     * 
     * @param carta Carta a eliminar.
     */
    public void eliminar(Carta carta) {
        int i = 0;
        for (Carta auxiliar : this) {
            if (auxiliar.igual(carta)) {
                this.remove(i);
                break;
            }
            ++i;
        }
    }
}
