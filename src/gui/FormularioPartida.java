package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import juego.Usuario;

/**
 * Gestiona la configuración de una partida.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class FormularioPartida extends javax.swing.JInternalFrame {

    public static final int PARTIDA_RAPIDA = 0;
    public static final int PARTIDA_ACUMULATIVA = 1;

    /**
     * Crea un nuevo formulario para configurar la partida.
     */
    public FormularioPartida() {
        initComponents();
        jLabelPuntos.setEnabled(false);
        jSpinnerPuntos.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelConfigurar = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        jLabelModalidad = new javax.swing.JLabel();
        jComboBoxModalidad = new javax.swing.JComboBox();
        jLabelJugadores = new javax.swing.JLabel();
        jLabelGenerar = new javax.swing.JLabel();
        jCheckBoxGenerar = new javax.swing.JCheckBox();
        jSpinnerJugadores = new javax.swing.JSpinner();
        jPanelMensaje = new javax.swing.JPanel();
        jLabelMensaje = new javax.swing.JLabel();
        jButtonIdentificar = new javax.swing.JButton();
        jLabelPuntos = new javax.swing.JLabel();
        jSpinnerPuntos = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jButtonJugar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva partida");

        jLabelConfigurar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/configuracion.png"))); // NOI18N
        jLabelConfigurar.setText("Configurar partida");

        jPanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelModalidad.setText("Modalidad de partida:");
        jPanelContenedor.add(jLabelModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        jComboBoxModalidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Partida rápida", "Partida acumulativa" }));
        jComboBoxModalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModalidadActionPerformed(evt);
            }
        });
        jPanelContenedor.add(jComboBoxModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 129, -1));

        jLabelJugadores.setText("Número de jugadores:");
        jPanelContenedor.add(jLabelJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jLabelGenerar.setText("Generar jugadores:");
        jPanelContenedor.add(jLabelGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jCheckBoxGenerar.setSelected(true);
        jCheckBoxGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGenerarActionPerformed(evt);
            }
        });
        jPanelContenedor.add(jCheckBoxGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 30, -1));

        jSpinnerJugadores.setModel(new javax.swing.SpinnerNumberModel(2, 2, 10, 1));
        jPanelContenedor.add(jSpinnerJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 33, -1));

        jLabelMensaje.setText("Está identificado como invitado,");
        jPanelMensaje.add(jLabelMensaje);

        jButtonIdentificar.setText("Iniciar sesión");
        jPanelMensaje.add(jButtonIdentificar);

        jPanelContenedor.add(jPanelMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 320, 30));

        jLabelPuntos.setText("Número de puntos:");
        jPanelContenedor.add(jLabelPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jSpinnerPuntos.setModel(new javax.swing.SpinnerNumberModel(10, 10, 500, 5));
        jPanelContenedor.add(jSpinnerPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jButtonJugar.setText("Jugar");
        jPanel1.add(jButtonJugar);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelConfigurar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabelConfigurar)
                .addGap(6, 6, 6)
                .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Muestra la ventana.
     * 
     * @param usuarioActual Usuario registrado.
     */
    public void llamar(Usuario usuarioActual) {
        this.setVisible(true);
        jPanelMensaje.setVisible(usuarioActual == null);
    }

    //Getters y Setters.
    public void setModalidad(int modalidad) {
        if (modalidad == PARTIDA_ACUMULATIVA) {
            jComboBoxModalidad.setSelectedIndex(PARTIDA_ACUMULATIVA);
            jLabelPuntos.setEnabled(true);
            jSpinnerPuntos.setEnabled(true);
        } else {
            jComboBoxModalidad.setSelectedIndex(PARTIDA_RAPIDA);
            jLabelPuntos.setEnabled(false);
            jSpinnerPuntos.setEnabled(false);
        }
        jComboBoxModalidad.setEnabled(false);
    }

    public JButton getjButtonIdentificar() {
        return jButtonIdentificar;
    }

    public JButton getjButtonJugar() {
        return jButtonJugar;
    }

    public JPanel getjPanelMensaje() {
        return jPanelMensaje;
    }

    public int getjSpinnerJugadores() {
        return ((Integer) jSpinnerJugadores.getValue()).intValue();
    }

    public int getjSpinnerPuntos() {
        if (jSpinnerPuntos.isEnabled()) {
            return ((Integer) jSpinnerPuntos.getValue()).intValue();
        }
        return -1;
    }
    
    public int getModalidad() {
        return jComboBoxModalidad.getSelectedIndex();
    }

    /**
     * Oculta la ventanada.
     * 
     * @param evt 
     */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * Establece la siguiente acción después de configurar la partida.
     * 
     * @param evt 
     */
    private void jCheckBoxGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGenerarActionPerformed
        if (jButtonJugar.getText().equals("Jugar")) {
            jButtonJugar.setText("Configurar jugadores");
        } else {
            jButtonJugar.setText("Jugar");
        }
    }//GEN-LAST:event_jCheckBoxGenerarActionPerformed

    /**
     * Cambia la modalidad de la partida.
     * 
     * @param evt 
     */
    private void jComboBoxModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModalidadActionPerformed
        if (jComboBoxModalidad.getSelectedIndex() == PARTIDA_ACUMULATIVA) {
            jLabelPuntos.setEnabled(true);
            jSpinnerPuntos.setEnabled(true);
        } else {
            jLabelPuntos.setEnabled(false);
            jSpinnerPuntos.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxModalidadActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonIdentificar;
    private javax.swing.JButton jButtonJugar;
    private javax.swing.JCheckBox jCheckBoxGenerar;
    private javax.swing.JComboBox jComboBoxModalidad;
    private javax.swing.JLabel jLabelConfigurar;
    private javax.swing.JLabel jLabelGenerar;
    private javax.swing.JLabel jLabelJugadores;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JLabel jLabelModalidad;
    private javax.swing.JLabel jLabelPuntos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelMensaje;
    private javax.swing.JSpinner jSpinnerJugadores;
    private javax.swing.JSpinner jSpinnerPuntos;
    // End of variables declaration//GEN-END:variables
}
