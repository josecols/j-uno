package juego;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Agrupa todos los elementos del tipo Usuario para su manipulación en conjunto.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class ListaUsuarios extends ArrayList<Usuario> {

    /**
     * Crea una nueva lista de elementos del tipo Usuario.
     */
    public ListaUsuarios() {
    }

    /**
     * Versión alternativa al función contains heredada de ArrayList.
     * 
     * @param usuario Usuario a determinar si está contenido en la lista.
     * @return Verdadero en caso de que el usuario esté en la lista. Falso,
     * en el caso contrario.
     */
    public boolean contiene(Usuario usuario) {
        for (Iterator<Usuario> it = this.iterator(); it.hasNext();) {
            Usuario usuario1 = it.next();
            if (usuario1.getNickname().equals(usuario.getNickname())) {
                return true;
            }
        }
        return false;
    }
}
