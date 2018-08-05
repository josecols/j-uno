package juego;

/**
 * Permite crear objetos con un color y un nombre o función asociados.
 * Toda instancia de esta clase es una carta lógica sin representación gráfica
 * a través de la misma.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez
 */
public class Carta {

    private String color;
    private String nombre;

    public Carta() {
    }

    /**
     * Crea una carta según el color y el nombre dado.
     * 
     * @param color Color de la carta.
     * @param nombre Nombre o función de la carta.
     */
    public Carta(String color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    /**
     * Determina si la carta dada coincide según las reglas con la carta instanciada,
     * es decir, si el color o el número son iguales.
     * 
     * @param carta Carta a comparar.
     * @return Resultado de la comparación.
     */
    public boolean coincide(Carta descarte) {
        if (descarte.getColor() == null
                && (descarte.getNombre().equals("color") || descarte.getNombre().equals("+4"))) {
            descarte.setColor("negro");
        }
        return (descarte.getColor().equals(this.getColor())
                || descarte.getNombre().equals(this.getNombre())
                || "negro".equals(this.getColor()));
    }

    /**
     * Verifica si una carta dada es igual a la carta instanciada.
     * 
     * @param carta Carta a comparar.
     * @return Resultado de la comprobación.
     */
    public boolean igual(Carta carta) {
        return (nombre.equals(carta.getNombre()) && color.equals(carta.getColor()));
    }

    /**
     * Genera el valor en puntos de la carta.
     * @return Valor.
     */
    public int valor() {
        int valor = 0;
        if ("+4".equals(this.getNombre()) || "color".equals(this.getNombre())) {
            return 50;
        }
        if ("+2".equals(this.getNombre()) || "reversa".equals(this.getNombre()) || "salta".equals(this.getNombre())) {
            return 20;
        }
        try {
            valor = Integer.parseInt(this.getNombre());
        } catch (NumberFormatException e) {
        }
        return valor;
    }

    @Override
    public String toString() {
        return (nombre + color);
    }

    //Getters y Setters.
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
