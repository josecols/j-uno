package datos;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Se encarga de generar el gráfico de torta, comparando las partidas ganadas,
 * las partidas perdidas y las partidas abandonadas de un jugador.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class Grafico {

    private DefaultPieDataset dataset;

    /**
     * Establece los valores dados para la posterior generación del gráfico.
     * 
     * @param partidasGanadas Número de partidas ganadas del jugador.
     * @param partidasPerdidas Número de partidas perdidas del jugador.
     * @param partidasAbandonadas Número de partidas abandonadas del jugador.
     */
    public Grafico(int partidasGanadas, int partidasPerdidas, int partidasAbandonadas) {
        dataset = new DefaultPieDataset();
        dataset.setValue("Partidas Ganadas", new Double(partidasGanadas));
        dataset.setValue("Partidas Perdidas", new Double(partidasPerdidas));
        dataset.setValue("Partidas Abandonadas", new Double(partidasAbandonadas));
    }

    /**
     * Crea el gráfico según los valores establecidos al momento de crear la instancia.
     * 
     * @return Un panel con el gráfico correspondiente.
     */
    public JPanel getGrafico() {
        JFreeChart chart = ChartFactory.createPieChart("", dataset, true, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setCircular(true);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1} = {2}"));
        plot.setBackgroundPaint(Color.white);
        return new ChartPanel(chart);
    }
}
