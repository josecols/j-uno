package juego;

/**
 * Agrupación de datos que permiten ver el rendimiento de los jugadores, 
 * a lo largo de su historial de partidas.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class Estadistica {

    private Usuario jugador;
    private int partidasJugadas;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int partidasAbandonadas;

    public Estadistica() {
    }

    /**
     * Crea una nueva estadística según los datos dados.
     * 
     * @param jugador Jugador asociado a la estadística.
     * @param partidasJugadas Número de partidas jugadas.
     * @param partidasGanadas Número de partidas ganadas.
     * @param partidasPerdidas Número de partidas perdidas.
     * @param partidasAbandonadas Número de partidas abandonadas.
     */
    public Estadistica(Usuario jugador, int partidasJugadas, int partidasGanadas, int partidasPerdidas, int partidasAbandonadas) {
        this.jugador = jugador;
        this.partidasJugadas = partidasJugadas;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.partidasAbandonadas = partidasAbandonadas;
    }

    @Override
    public String toString() {
        return jugador + " - " + ((jugador.getNickname() == null) ? ("computador") : (jugador.getNickname()))
                + " | " + partidasJugadas + " | " + partidasGanadas + " | " 
                + partidasPerdidas + " | " + partidasAbandonadas + " |";
    }
    
    //Getters y Setters.
    public Usuario getJugador() {
        return jugador;
    }

    public void setJugador(Usuario jugador) {
        this.jugador = jugador;
    }

    public int getPartidasAbandonadas() {
        return partidasAbandonadas;
    }

    public void setPartidasAbandonadas(int partidasAbandonadas) {
        this.partidasAbandonadas = partidasAbandonadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }    
}
