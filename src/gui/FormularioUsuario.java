package gui;

import datos.ValidadorUsuario;
import datos.XMLUsuarios;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import juego.Usuario;

/**
 * Formulario para ingresar los datos de un usuario.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class FormularioUsuario extends javax.swing.JInternalFrame {

    public static final int AGREGAR = 0;
    public static final int MODIFICAR = 1;
    public static final int DESACTIVAR = 2;
    public static final int REACTIVAR = 3;
    private int modoGuardardo;
    private JInternalFrame frame;

    /**
     * Crea un nuevo formulario para el registro y actualización de usuarios.
     */
    public FormularioUsuario() {
        initComponents();
        this.setSize(320, 320);
        jFileChooserArchivo.setVisible(false);
        jFileChooserArchivo.setFileFilter(new ExtensionFileFilter("JPG y JPEG", new String[]{"JPG", "JPEG"}));
        frame = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelIngreseDatos = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        jLabelAvatar = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldNickname = new javax.swing.JTextField();
        jLabelNickname = new javax.swing.JLabel();
        jLabelClave = new javax.swing.JLabel();
        jPasswordFieldClave = new javax.swing.JPasswordField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jFileChooserArchivo = new javax.swing.JFileChooser();

        setTitle("Datos del usuario");
        setMinimumSize(new java.awt.Dimension(297, 320));

        jLabelIngreseDatos.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelIngreseDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/datos-usuario.png"))); // NOI18N
        jLabelIngreseDatos.setLabelFor(jPanelContenedor);
        jLabelIngreseDatos.setText("Ingrese sus datos");
        jLabelIngreseDatos.setToolTipText("");

        jLabelAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/avatar.png"))); // NOI18N
        jLabelAvatar.setLabelFor(jPanelContenedor);
        jLabelAvatar.setToolTipText("Avatar");
        jLabelAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatar.setName("/iconos/avatar.png"); // NOI18N
        jLabelAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatarSeleccionado(evt);
            }
        });

        jLabelNombre.setText("Nombre:");

        jLabelApellido.setText("Apellido:");

        jLabelNickname.setText("Nickname:");

        jLabelClave.setText("Clave:");

        jLabelEmail.setText("Email:");

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                                .addComponent(jLabelNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                                .addComponent(jLabelApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))))
                    .addGroup(jPanelContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNickname)
                            .addComponent(jLabelClave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordFieldClave)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jTextFieldNickname, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
                    .addGroup(jPanelContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEmail)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNickname)
                    .addComponent(jTextFieldNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClave)
                    .addComponent(jPasswordFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonGuardar.setText("Guardar");
        jPanelBotones.add(jButtonGuardar);

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonLimpiar);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonCancelar);

        jFileChooserArchivo.setAcceptAllFileFilterUsed(false);
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
                    .addComponent(jFileChooserArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIngreseDatos)
                    .addComponent(jPanelContenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIngreseDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFileChooserArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Lleva el formulario a su configuración inicial.
     */
    public void resetFormulario() {
        jButtonLimpiarActionPerformed(null);
        this.setSize(320, 320);
        jButtonLimpiar.setEnabled(true);
        jTextFieldNickname.setEnabled(true);
        jFileChooserArchivo.setVisible(false);
    }

    /**
     * Establece los campos según los datos de un usuario dado.
     * 
     * @param usuario Usuario a modificar.
     */
    public void setCampos(Usuario usuario) {
        jTextFieldNombre.setText(usuario.getNombre());
        jTextFieldApellido.setText(usuario.getApellido());
        jTextFieldEmail.setText(usuario.getEmail());
        jTextFieldNickname.setText(usuario.getNickname());
        jPasswordFieldClave.setText(usuario.getClave());
        jLabelAvatar.setIcon(usuario.getAvatar());
        jLabelAvatar.setName(usuario.getAvatar().getDescription());
        jTextFieldNickname.setEnabled(false);
        jButtonLimpiar.setEnabled(false);
    }

    /**
     * Verifica, a través de ValidadorUsuario, si los datos ingresados son correctos.
     * 
     * @return Resultado de la comprobación.
     */
    public boolean datosValidos() {
        if (!ValidadorUsuario.validarNombre(this.getNombre())) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Solo puede ingresar caracteres.",
                    "Error, nombre inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidadorUsuario.validarNombre(this.getApellido())) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Solo puede ingresar caracteres.",
                    "Error, apellido inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidadorUsuario.validarNickname(this.getNickname())) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Verifique el formato del nickname suministrado.",
                    "Error, nickname inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidadorUsuario.validarCorreo(this.getEmail())) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Verifique el formato del correo suministrado.",
                    "Error, correo inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.getClave().equals("")) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Verifique el formato de la clave suministrada.",
                    "Error, clave inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.getAvatar().equals("")) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Debe suministrar un avatar.",
                    "Error, avatar inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Crea un nuevo usuario a partir de los datos contenidos en los campos.
     * 
     * @return Nuevo usuario.
     */
    private Usuario nuevoUsuario() {
        if (datosValidos()) {
            return new Usuario(this.getNombre(), this.getApellido(), this.getEmail(),
                    new ImageIcon(this.getAvatar(), this.getAvatar()), this.getNickname(),
                    this.getClave(), Usuario.ACTIVADO);
        }
        return null;
    }

    /**
     * Agrega, a través de una instancia de XMLUsuarios, un nuevo usuario.
     * 
     * @param datos Gestor de la agregación.
     */
    public void agregarUsuario(XMLUsuarios datos) {
        Usuario usuario;
        if ((usuario = nuevoUsuario()) != null) {
            if (datos.agregarUsuario(usuario)) {
                JOptionPane.showInternalMessageDialog(this.getParent(), "El usuario se ha agregado correctamente.",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                mostrarEmisor();
                this.dispose();
            } else {
                JOptionPane.showInternalMessageDialog(this.getParent(), "Error, debe cambiar el nickname.",
                        "El usuario ya existe", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Modifica, a través de una instancia de XMLUsuarios, un usuario existente.
     * 
     * @param datos Gestor de la agregación.
     * @param usuarioActual Usuario a modificar.
     * @return Usuario modificado.
     */
    public Usuario modificarUsuario(XMLUsuarios datos, Usuario usuarioActual) {
        if (nuevoUsuario() != null) {
            datos.actualizarUsuario(usuarioActual = nuevoUsuario());
            JOptionPane.showInternalMessageDialog(this.getParent(),
                    "El usuario " + usuarioActual.getNickname() + " se ha modificado correctamente.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmisor();
            this.dispose();
        }
        return usuarioActual;
    }

    /**
     * Desactiva, a través de una instancia de XMLUsuarios, un usuario existente.
     * 
     * @param datos Gestor de la desactivación.
     * @param usuarioActual Usuario a desactivar.
     */
    public void desactivarUsuario(XMLUsuarios datos, Usuario usuarioActual) {
        if (usuarioActual != null) {
            usuarioActual.setEstado(Usuario.DESACTIVADO);
            datos.actualizarUsuario(usuarioActual);
            JOptionPane.showInternalMessageDialog(this.getParent(),
                    "El usuario " + usuarioActual.getNickname() + " se ha desactivado correctamente.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmisor();
        }
    }

    /**
     * Activa, a través de una instancia de XMLUsuarios, un usuario existente.
     * 
     * @param datos Gestor de la activación.
     * @param usuarioActual Usuario a reactivar.
     */
    public void reactivarUsuario(XMLUsuarios datos, Usuario usuarioActual) {
        if (usuarioActual != null) {
            usuarioActual.setEstado(Usuario.ACTIVADO);
            datos.actualizarUsuario(usuarioActual);
            JOptionPane.showInternalMessageDialog(this.getParent(), "El usuario " + usuarioActual.getNickname() + " se ha activado correctamente.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmisor();
        }
    }

    /**
     * Muestra la ventana establecida como emisora de la 
     * llamada a la instancia de FormularioUsuario.
     */
    public void mostrarEmisor() {
        if (frame != null) {
            frame.setVisible(true);
            frame = null;
        }
    }

    /**
     * Muestra esta ventana, y de existir, oculta el emisor.
     * 
     * @param frame Emisor.
     */
    public void llamar(JInternalFrame frame) {
        this.setVisible(true);
        if (frame != null) {
            this.frame = frame;
            frame.setVisible(false);
        }
    }

    /**
     * Reinicia y oculta el formulario.
     */
    @Override
    public void dispose() {
        this.resetFormulario();
        super.dispose();
    }

    //Getters y Setters.
    public JButton getjButtonGuardar() {
        return jButtonGuardar;
    }

    public JButton getjButtonLimpiar() {
        return jButtonLimpiar;
    }

    public JTextField getjTextFieldNickname() {
        return jTextFieldNickname;
    }

    public String getNombre() {
        return jTextFieldNombre.getText();
    }

    public String getApellido() {
        return jTextFieldApellido.getText();
    }

    public String getEmail() {
        return jTextFieldEmail.getText();
    }

    public String getNickname() {
        return jTextFieldNickname.getText();
    }

    public String getClave() {
        return String.valueOf(jPasswordFieldClave.getPassword());
    }

    public String getAvatar() {
        return jLabelAvatar.getName();
    }

    public int getModoGuardardo() {
        return modoGuardardo;
    }

    public void setModoGuardardo(int modoGuardardo) {
        this.modoGuardardo = modoGuardardo;
    }

    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        this.frame = frame;
    }

    /**
     * Limpia los campos del formulario.
     * 
     * @param evt 
     */
    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        jTextFieldNombre.setText(null);
        jTextFieldApellido.setText(null);
        jTextFieldEmail.setText(null);
        jTextFieldNickname.setText(null);
        jPasswordFieldClave.setText(null);
        jLabelAvatar.setIcon(new ImageIcon(getClass().getResource("/imagenes/iconos/avatar.png"), "/imagenes/iconos/avatar.png"));
        jLabelAvatar.setName("/imagenes/iconos/avatar.png");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    /**
     * Cambia la apariencia visual del formulario para la selección de la
     * imagen que corresponde al avatar del usuario.
     * 
     * @param evt 
     */
    private void avatarSeleccionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatarSeleccionado
        this.setSize(440, 610);
        jFileChooserArchivo.setVisible(true);
    }//GEN-LAST:event_avatarSeleccionado

    /**
     * Establece el archivo seleccionado como avatar en el formulario.
     * 
     * @param evt 
     */
    private void archivoSeleccionado(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_archivoSeleccionado
        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
            try {
                String directorio = jFileChooserArchivo.getSelectedFile().getPath();
                jLabelAvatar.setIcon(new ImageIcon(directorio));
                jLabelAvatar.setName(directorio);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_archivoSeleccionado

    /**
     * Oculta el formulario.
     * 
     * @param evt 
     */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        mostrarEmisor();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JFileChooser jFileChooserArchivo;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelIngreseDatos;
    private javax.swing.JLabel jLabelNickname;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPasswordField jPasswordFieldClave;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNickname;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
