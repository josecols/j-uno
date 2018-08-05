package gui;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 * Permite pintar con un estilo determinado un panel con una imagen de fondo.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class FondoPanel extends JPanel {

    public static final int ESCALADO = 0;
    public static final int MOSAICO = 1;
    public static final int REAL = 2;
    private Paint pintor;
    private Image fondo;
    private int estilo = ESCALADO;
    private float alineacionX = 0.5f;
    private float alineacionY = 0.5f;
    private boolean esTransparente = true;

    public FondoPanel() {
    }

    /**
     * Establece imagen como fondo del Panel con el estilo ESCALADO.
     *
     * @param imagen Imagen de fondo.
     */
    public FondoPanel(Image imagen) {
        this(imagen, ESCALADO);
    }

    /**
     * Establece imagen como fondo del Panel con el estilo especificado.
     *
     * @param imagen Imagen de fondo.
     * @param estilo Estilo de la imagen (ESCALADO, MOSAICO o REAL).
     */
    public FondoPanel(Image imagen, int estilo) {
        setFondo(imagen);
        setEstilo(estilo);
        setLayout(new BorderLayout());
    }

    /**
     * Establece imagen como fondo del panel con el estilo y la alineación
     * especificados.
     *
     * @param imagen Imagen de fondo.
     * @param estilo Estilo de la imagen (ESCALADO, MOSAICO o REAL).
     * @param alineacionX Alineacion de la imagen con el eje X.
     * @param alineacionY Alineacion de la imagen con el eje Y.
     */
    public FondoPanel(Image imagen, int estilo, float alineacionX, float alineacionY) {
        setFondo(imagen);
        setEstilo(estilo);
        setAlignmentX(alineacionX);
        setAlignmentY(alineacionY);
        setLayout(new BorderLayout());
    }

    /**
     * Establece como fondo del panel la imagen con el nombre descrito y el
     * estilo y la alineación especificados.
     *
     * @param nombre Nombre de la imagen de fondo.
     * @param estilo Estilo de la imagen (ESCALADO, MOSAICO o REAL).
     * @param alineacionX Alineacion de la imagen con el eje X.
     * @param alineacionY Alineacion de la imagen con el eje Y.
     */
    public FondoPanel(String nombre, int estilo, float alineacionX, float alineacionY) {
        setFondo(new ImageIcon(getClass().getResource("/imagenes/" + nombre)).getImage());
        setEstilo(estilo);
        setAlignmentX(alineacionX);
        setAlignmentY(alineacionY);
        setLayout(new BorderLayout());
    }

    /**
     * Usa la interfaz Paint para dibujar un fondo.
     *
     * @param pintor
     */
    public FondoPanel(Paint pintor) {
        setPintor(pintor);
        setLayout(new BorderLayout());
    }

    /**
     * Estable imagen como el nuevo fondo del Panel.
     *
     * @param imagen Imagen de fondo.
     */
    public final void setFondo(Image imagen) {
        this.fondo = imagen;
        repaint();
    }

    /**
     * Establece el estilo especificado para pintar el fondo del Panel.
     *
     * @param estilo Estilo de la imagen (ESCALADO, MOSAICO o REAL).
     */
    public final void setEstilo(int estilo) {
        this.estilo = estilo;
        repaint();
    }

    /**
     * Establece el objeto Paint para pintar el fondo.
     *
     * @param pintor
     */
    public final void setPintor(Paint pintor) {
        this.pintor = pintor;
        repaint();
    }

    /**
     * Especifica la alineación horizontal de la imagen al usar el estilo REAL.
     *
     * @param alineacionX Alineación de la imagen con el eje X.
     */
    @Override
    public final void setAlignmentX(float alineacionX) {
        this.alineacionX = (alineacionX > 1.0f) ? (1.0f) : (alineacionX < 0.0f ? 0.0f : alineacionX);
        repaint();
    }

    /**
     * Especifica la alineación vertical de la imagen al usar el estilo REAL.
     *
     * @param alineacionY Alineación de la imagen con el eje Y.
     */
    @Override
    public final void setAlignmentY(float alineacionY) {
        this.alineacionY = (alineacionY > 1.0f) ? (1.0f) : (alineacionY < 0.0f ? 0.0f : alineacionY);
        repaint();
    }

    /**
     * Sobreescribe el método add de Container para hacer el componente transparente.
     *
     * @param componente Componente adicionado al final.
     */
    public void add(JComponent componente) {
        add(componente, null);
    }

    /**
     * Sobreescribe el método getPreferredSize de Container para proveer una
     * dimensión igual al tamaño de la imagen.
     *
     * @return Dimensión de la imagen de fondo del panel, si esta existe.
     */
    @Override
    public Dimension getPreferredSize() {
        if (fondo == null) {
            return super.getPreferredSize();
        } else {
            return new Dimension(fondo.getWidth(null), fondo.getHeight(null));
        }
    }

    /**
     * Sobreescribe el método add de Container para hacer el componente transparente.
     * 
     * @param Componente componente adicionado al final
     * @param limites 
     */
    public void add(JComponent componente, Object limites) {
        if (esTransparente) {
            hacerComponenteTransparente(componente);
        }

        super.add(componente, limites);
    }

    /**
     * Controla si el componente agregado al panel se debe hacer transparente
     * automáticamente. Esto significa, que se llamará setOpaque(false). El valor
     * por defecto es verdadero (true).
     * 
     * @param esTransparente Verdadero para hacer el componente transparente. 
     */
    public void setEsTransparente(boolean esTransparente) {
        this.esTransparente = esTransparente;
    }

    /**
     * Intenta hacer el componente transparente.
     *
     * Para componentes que usan renderers, como JTable, se necesita hacer
     * también el renderer transparente. Una forma sencilla de hacerlo es
     * cambiar el fondo de la tabla a un Color usando cero (0) como el valor de
     * alpha.
     *
     * @param componente Componente a hacer transparente.
     */
    private void hacerComponenteTransparente(JComponent componente) {
        componente.setOpaque(false);

        if (componente instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) componente;
            JViewport viewport = scrollPane.getViewport();
            viewport.setOpaque(false);
            Component c = viewport.getView();

            if (c instanceof JComponent) {
                ((JComponent) c).setOpaque(false);
            }
        }
    }

    /**
     * Pinta el componente con la imagen de fondo y el estilo especificado.
     * 
     * @param g Graphics para dibujar la imagen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (pintor != null) {
            Dimension d = getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(pintor);
            g2.fill(new Rectangle(0, 0, d.width, d.height));
        }

        if (fondo == null) {
            return;
        }

        switch (estilo) {
            case ESCALADO:
                dibujarEscalado(g);
                break;
            case MOSAICO:
                dibujarMosaico(g);
                break;
            case REAL:
                dibujarReal(g);
                break;
            default:
                dibujarEscalado(g);
        }
    }

    /**
     * Dibuja la imagen asociada como fondo de forma ESCALADA.
     *
     * @param g Graphics para dibujar la imagen.
     */
    private void dibujarEscalado(Graphics g) {
        Dimension d = getSize();
        g.drawImage(fondo, 0, 0, d.width, d.height, null);
    }

    /**
     * Dibuja la imagen asociada como fondo de forma MOSAICO.
     * 
     * @param g Graphics para dibujar la imagen.
     */
    private void dibujarMosaico(Graphics g) {
        Dimension d = getSize();
        int ancho = fondo.getWidth(null);
        int alto = fondo.getHeight(null);

        for (int x = 0; x < d.width; x += ancho) {
            for (int y = 0; y < d.height; y += alto) {
                g.drawImage(fondo, x, y, null, null);
            }
        }
    }

    /**
     * Dibuja la imagen asociada como fondo de forma REAL. 
     * La imagen es posicionada en el panel basándose en la alineación horizontal
     * y vertical especificada.
     * 
     * @param g Graphics para dibujar la imagen.
     */
    private void dibujarReal(Graphics g) {
        Dimension d = getSize();
        Insets insets = getInsets();
        int ancho = d.width - insets.left - insets.right;
        int alto = d.height - insets.top - insets.left;
        float x = (ancho - fondo.getWidth(null)) * alineacionX;
        float y = (alto - fondo.getHeight(null)) * alineacionY;
        g.drawImage(fondo, (int) x + insets.left, (int) y + insets.top, this);
    }
}