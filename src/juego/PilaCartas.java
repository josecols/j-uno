package juego;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Agrupa todos los elementos del tipo Carta para su manipulación en conjunto,
 * mediante algoritmos LIFO.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class PilaCartas extends Stack<Carta> {

    public static final String COLORES[] = {"azul", "verde", "rojo", "amarillo"};

    public PilaCartas() {
    }

    /**
     * Construye la pila de cartas dada una lista.
     * 
     * @param cartas Lista con los elementos que formarán parte de la pila.
     */
    public PilaCartas(ArrayList<Carta> cartas) {
        for (Iterator<Carta> it = cartas.iterator(); it.hasNext();) {
            Carta carta = it.next();
            this.push(carta);
        }
    }

    /**
     * Mezcla aleatoreamente los elementos de la pila de cartas.
     */
    public void barajar() {
        Collections.shuffle(this);
    }

    /**
     * Transfiere todas las cartas de una pila (fuente) a otra (instancia).
     * Baraja las cartas al terminar la transferencia.
     * 
     * @param fuente Pila de cartas a transferir.
     */
    public void transferir(PilaCartas fuente) {
        for (int i = 0, n = fuente.size(); i < n; ++i) {
            if (("+4".equals(fuente.peek().getNombre())
                    || "color".equals(fuente.peek().getNombre()))
                    && !"negro".equals(fuente.peek().getColor())) {
                fuente.peek().setColor("negro");
            }
            this.push(fuente.pop());
        }
        this.barajar();
        fuente.push(this.pop());
    }

    /**
     * Genera todas las cartas que contiene el mazo de UNO según las reglas 
     * especificadas.
     * 
     * @return Lista con todas las cartas.
     */
    public static ArrayList<Carta> mazoCompleto() {
        ArrayList<Carta> mazo = new ArrayList<Carta>();

        //Generando números.
        for (int i = 0; i < 4; ++i) {
            mazo.add(new Carta(PilaCartas.COLORES[i], "0"));
            for (int j = 1; j < 10; ++j) {
                mazo.add(new Carta(PilaCartas.COLORES[i], String.valueOf(j)));
                mazo.add(new Carta(PilaCartas.COLORES[i], String.valueOf(j)));
            }
        }

        //Generando +2, reversa y salta.
        for (int i = 0; i < 4; ++i) {
            mazo.add(new Carta(PilaCartas.COLORES[i], "+2"));
            mazo.add(new Carta(PilaCartas.COLORES[i], "+2"));
            mazo.add(new Carta(PilaCartas.COLORES[i], "reversa"));
            mazo.add(new Carta(PilaCartas.COLORES[i], "reversa"));
            mazo.add(new Carta(PilaCartas.COLORES[i], "salta"));
            mazo.add(new Carta(PilaCartas.COLORES[i], "salta"));
        }

        //Cartas especiales.
        for (int i = 0; i < 4; ++i) {
            mazo.add(new Carta("negro", "+4"));
            mazo.add(new Carta("negro", "color"));
        }
        return mazo;
    }
}
