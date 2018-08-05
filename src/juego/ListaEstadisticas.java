package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Agrupa todos los elementos del tipo Estadistica para su manipulación en conjunto.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class ListaEstadisticas extends ArrayList<Estadistica> {

    public ListaEstadisticas() {
    }

    /**
     * Permite la comparación de la estadísticas para ordenarlas por el 
     * número de partidas ganadas.
     * 
     * 25/06/2012 - 25 de junio del 2012.
     * 
     * @author José Cols, Larisa Méndez.
     */
    public class ComparadorEstadisticas implements Comparator<Estadistica> {

        @Override
        public int compare(Estadistica estadistica, Estadistica estadistica1) {
            int t = estadistica.getPartidasGanadas(), t1 = estadistica1.getPartidasGanadas();
            return (t > t1 ? -1 : (t == t1 ? 0 : 1));
        }
    }

    /**
     * Actualiza los valores de una estadistica determinada.
     * 
     * @param estadistica Estadistica con los valores a agregar.
     * @return Estadistica actualizada.
     */
    public Estadistica modificarEstadistica(Estadistica estadistica) {
        for (Estadistica e : this) {
            if (e.getJugador().getNickname().equals(estadistica.getJugador().getNickname())) {
                e.setPartidasJugadas(e.getPartidasJugadas() + estadistica.getPartidasJugadas());
                e.setPartidasGanadas(e.getPartidasGanadas() + estadistica.getPartidasGanadas());
                e.setPartidasPerdidas(e.getPartidasPerdidas() + estadistica.getPartidasPerdidas());
                e.setPartidasAbandonadas(e.getPartidasAbandonadas() + estadistica.getPartidasAbandonadas());
                return e;
            }
        }
        return null;
    }

    /**
     * Verifica si una lista contiene una estadística determinada
     * 
     * @param usuario Usuario asociado a la estadística.
     * @return Resultado de la comprobación.
     */
    public boolean contiene(Usuario usuario) {
        for (Iterator<Estadistica> it = this.iterator(); it.hasNext();) {
            Usuario usuario1 = it.next().getJugador();
            if (usuario1.getNickname().equals(usuario.getNickname())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ordena la lista de estadísticas.
     */
    public void ordenar() {
        Collections.sort(this, new ComparadorEstadisticas());
    }
}
