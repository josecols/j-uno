package gui;

import datos.Grafico;
import datos.XMLEstadisticas;
import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import juego.Estadistica;
import juego.ListaEstadisticas;

/**
 * Permite la visualización, a través de una interfaz gráfica,
 * de las estadísticas de los jugadores.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class FormularioEstadisticas extends javax.swing.JInternalFrame {

    private ListaEstadisticas estadisticas;
    private DefaultListModel modelo;
    private XMLEstadisticas datos;

    /**
     * Crea una nueva ventana para la visualización de estadísticas e inicializa
     * sus componentes.
     */
    public FormularioEstadisticas() {
        modelo = new DefaultListModel();
        datos = new XMLEstadisticas();
        initComponents();
        actualizarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListEstadisticas = new javax.swing.JList();
        jLabelEstadisticas = new javax.swing.JLabel();
        jLabelLeyenda = new javax.swing.JLabel();
        jPanelTorta = new javax.swing.JPanel();
        jLabelPartidas = new javax.swing.JLabel();
        jPanelGrafico = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estadísticas");

        jListEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEstadisticasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListEstadisticas);

        jLabelEstadisticas.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/estadisticas.png"))); // NOI18N
        jLabelEstadisticas.setText("Estadísticas de los jugadores");
        jLabelEstadisticas.setToolTipText("");

        jLabelLeyenda.setText("Leyenda: Nombre Apellido - Nickname | PJ | PG| PP| PA");

        jLabelPartidas.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelPartidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/torta.png"))); // NOI18N
        jLabelPartidas.setText("Gráfico de partidas");
        jLabelPartidas.setToolTipText("");

        jPanelGrafico.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanelTortaLayout = new javax.swing.GroupLayout(jPanelTorta);
        jPanelTorta.setLayout(jPanelTortaLayout);
        jPanelTortaLayout.setHorizontalGroup(
            jPanelTortaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTortaLayout.createSequentialGroup()
                .addComponent(jLabelPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
            .addComponent(jPanelGrafico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        jPanelTortaLayout.setVerticalGroup(
            jPanelTortaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTortaLayout.createSequentialGroup()
                .addComponent(jLabelPartidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
        );

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLeyenda, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addGap(319, 319, 319)
                        .addComponent(jButtonCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEstadisticas)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelTorta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEstadisticas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelTorta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLeyenda)
                    .addComponent(jButtonCerrar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Actualiza la lista del modelo del componente JList.
     */
    public final void actualizarLista() {
        if ((estadisticas = datos.leerEstadisticas()) == null) {
            datos.crearArchivo();
        } else {
            modelo.removeAllElements();
            if (estadisticas.size() > 0) {
                for (Estadistica e : estadisticas) {
                    modelo.addElement(e.getJugador().getNombre() + " "
                            + e.getJugador().getApellido() + " - "
                            + e.getJugador().getNickname() + " | "
                            + e.getPartidasJugadas() + " | "
                            + e.getPartidasGanadas() + " | "
                            + e.getPartidasPerdidas() + " | "
                            + e.getPartidasAbandonadas() + " |");
                }
            }
            jListEstadisticas.setModel(modelo);
        }
    }

    /**
     * Guarda, a través de una instancia de XMLEstadisticas, una estadística dada.
     * 
     * @param estadistica Estadística a guardar.
     */
    public void guardarEstadistica(Estadistica estadistica) {
        Estadistica e;
        if (!datos.agregarEstadistica(estadistica)) {
            if ((e = estadisticas.modificarEstadistica(estadistica)) != null) {
                datos.actualizarEstadistica(e);
            }
        }
    }

    /**
     * Cierra la ventana.
     * 
     * @param evt 
     */
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.setVisible(false);
        jPanelGrafico.setVisible(false);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    /**
     * Genera un gráfico de torta según los datos de la estadística seleccionada.
     * 
     * @param evt 
     */
    private void jListEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEstadisticasMouseClicked
        try {
            Estadistica estadistica = estadisticas.get(jListEstadisticas.getSelectedIndex());
            Grafico grafico = new Grafico(estadistica.getPartidasGanadas(),
                    estadistica.getPartidasPerdidas(),
                    estadistica.getPartidasAbandonadas());
            jPanelGrafico.add(grafico.getGrafico(), BorderLayout.CENTER);
            jPanelGrafico.validate();
            jPanelGrafico.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "No hay ninguna estadística guardada.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            System.err.println("La lista se cargó con problemas.");
        }
    }//GEN-LAST:event_jListEstadisticasMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabelEstadisticas;
    private javax.swing.JLabel jLabelLeyenda;
    private javax.swing.JLabel jLabelPartidas;
    private javax.swing.JList jListEstadisticas;
    private javax.swing.JPanel jPanelGrafico;
    private javax.swing.JPanel jPanelTorta;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
