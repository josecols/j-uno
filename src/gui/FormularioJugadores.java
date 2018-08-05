package gui;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import juego.Jugador;
import juego.ListaJugadores;

/**
 * Gestiona la configuración de los datos de los jugadores que serán controlados
 * por computadora.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class FormularioJugadores extends javax.swing.JInternalFrame {

    public static final int JUGAR = 0;
    private ListaJugadores jugadores;
    private DefaultListModel modelo;
    private int modoFinalizar;
    private int avatarFlag = 0;

    /**
     * Crea un nuevo formulario para configurar los datos de los jugadores.
     */
    public FormularioJugadores() {
        jugadores = new ListaJugadores();
        modelo = new DefaultListModel();
        jugadores.generarJugadores(9);
        initComponents();
        actualizarLista();
        this.setSize(549, 223);
        jFileChooserArchivo.setVisible(false);
        jFileChooserArchivo.setFileFilter(new ExtensionFileFilter("JPG y JPEG", new String[]{"JPG", "JPEG"}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGestionar = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        jLabelAvatar = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJugadores = new javax.swing.JList();
        jLabelJugadores = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonGenerar = new javax.swing.JButton();
        jButtonListo = new javax.swing.JButton();
        jFileChooserArchivo = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios computarizados");

        jLabelGestionar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelGestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/editar-computador.png"))); // NOI18N
        jLabelGestionar.setText("Gestionar jugadores");

        jLabelAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatar.setMaximumSize(new java.awt.Dimension(64, 64));
        jLabelAvatar.setMinimumSize(new java.awt.Dimension(64, 64));
        jLabelAvatar.setPreferredSize(new java.awt.Dimension(64, 64));
        jLabelAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarMouseClicked(evt);
            }
        });

        jLabelNombre.setText("Nombre:");

        jLabelApellido.setText("Apellido:");

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addComponent(jLabelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelApellido)
                            .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jListJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jugadorSeleccionado(evt);
            }
        });
        jScrollPane1.setViewportView(jListJugadores);

        jLabelJugadores.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelJugadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/computador.png"))); // NOI18N
        jLabelJugadores.setText("Jugadores (PC)");

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setEnabled(false);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonGuardar);

        jButtonGenerar.setText("Generar");
        jButtonGenerar.setEnabled(false);
        jButtonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonGenerar);

        jButtonListo.setText("Listo");
        jPanelBotones.add(jButtonListo);

        jFileChooserArchivo.setControlButtonsAreShown(false);
        jFileChooserArchivo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                archivoSeleccionado(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(jPanelContenedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelGestionar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelJugadores)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jFileChooserArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGestionar)
                    .addComponent(jLabelJugadores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFileChooserArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Actualiza la lista del modelo del componente JList.
     */
    public final void actualizarLista() {
        int i = 0;
        if (jugadores.size() > 0) {
            modelo.removeAllElements();
            for (Jugador jugador : jugadores) {
                modelo.addElement(++i + " - " + jugador.getNombre() + " " + jugador.getApellido());
            }
        }
        jListJugadores.setModel(modelo);
    }

    /**
     * Reinicia los valores de los campos del formulario a su valor original.
     */
    public void resetFormulario() {
        jLabelAvatar.setIcon(null);
        jLabelAvatar.setName(null);
        jTextFieldNombre.setText(null);
        jTextFieldApellido.setText(null);
    }

    /**
     * Verifica que los campos no estén vacíos.
     * 
     * @return El resultado de la comprobación.
     */
    private boolean validarEntrada() {
        if (!"".equals(jTextFieldNombre.getText()) && !"".equals(jTextFieldApellido.getText())) {
            return true;
        }
        JOptionPane.showInternalMessageDialog(this.getParent(), "Error, por favor revise los campos e intente de nuevo.",
                "Valores inválidos en los campos", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    //Getters y Setters.
    public JButton getjButtonListo() {
        return jButtonListo;
    }

    public int getModoFinalizar() {
        return modoFinalizar;
    }

    public void setModoFinalizar(int modoConfiguracion) {
        this.modoFinalizar = modoConfiguracion;
    }

    public ListaJugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaJugadores jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Guarda los datos del jugador.
     * 
     * @param evt 
     */
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        if (validarEntrada()) {
            Jugador jugador;
            if (avatarFlag == 0) {
                jugador = new Jugador(jTextFieldNombre.getText(), jTextFieldApellido.getText(),
                        new ImageIcon(getClass().getResource(jLabelAvatar.getName()), jLabelAvatar.getName()));
            } else {
                jugador = new Jugador(jTextFieldNombre.getText(), jTextFieldApellido.getText(),
                        new ImageIcon(jLabelAvatar.getName(), jLabelAvatar.getName()));
            }
            jugador.setMano(jugadores.get(jListJugadores.getSelectedIndex()).getMano());
            jugadores.set(jListJugadores.getSelectedIndex(), jugador);
            resetFormulario();
            actualizarLista();
            avatarFlag = 0;
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    /**
     * Genera aletoriamente los datos de un jugador.
     * 
     * @param evt 
     */
    private void jButtonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarActionPerformed
        Jugador jugador = jugadores.generarJugador();
        jLabelAvatar.setIcon(jugador.getAvatar());
        jLabelAvatar.setName(jugador.getAvatar().getDescription());
        jTextFieldNombre.setText(jugador.getNombre());
        jTextFieldApellido.setText(jugador.getApellido());
    }//GEN-LAST:event_jButtonGenerarActionPerformed

    /**
     * Cambia la apariencia visual del formulario para la selección de la
     * imagen que corresponde al avatar del jugador.
     * 
     * @param evt 
     */
    private void jLabelAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarMouseClicked
        this.setSize(548, 554);
        jFileChooserArchivo.setVisible(true);
    }//GEN-LAST:event_jLabelAvatarMouseClicked

    /**
     * Establece el archivo seleccionado como avatar en el formulario.
     * 
     * @param evt 
     */
    private void archivoSeleccionado(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_archivoSeleccionado
        if (javax.swing.JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
            try {
                String directorio = jFileChooserArchivo.getSelectedFile().getPath();
                jLabelAvatar.setIcon(new ImageIcon(directorio));
                jLabelAvatar.setName(directorio);
                avatarFlag = 1;
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_archivoSeleccionado

    /**
     * Establece los campos del formulario con los datos del jugador seleccionado.
     * 
     * @param evt 
     */
    private void jugadorSeleccionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugadorSeleccionado
        Jugador jugador = jugadores.get(jListJugadores.getAnchorSelectionIndex());
        jLabelAvatar.setIcon(jugador.getAvatar());
        jLabelAvatar.setName(jugador.getAvatar().getDescription());
        jTextFieldNombre.setText(jugador.getNombre());
        jTextFieldApellido.setText(jugador.getApellido());
        jButtonGuardar.setEnabled(true);
        jButtonGenerar.setEnabled(true);
    }//GEN-LAST:event_jugadorSeleccionado
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonListo;
    private javax.swing.JFileChooser jFileChooserArchivo;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JLabel jLabelGestionar;
    private javax.swing.JLabel jLabelJugadores;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JList jListJugadores;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
