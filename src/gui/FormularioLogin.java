package gui;

import datos.XMLUsuarios;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import juego.Usuario;

/**
 * Representa la interfaz que le permite a un usuario registrado autenticarse.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class FormularioLogin extends javax.swing.JInternalFrame {

    public static final int MODIFICAR = 0;
    public static final int JUGAR = 1;
    public static final int DESACTIVAR = 2;
    public static final int REACTIVAR = 3;
    private XMLUsuarios datos;
    private int modoAutenticacion;

    /**
     * Crea un nuevo formulario para el inicio de sesión de los usuarios.
     */
    public FormularioLogin() {
        datos = new XMLUsuarios();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDatos = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        jLabelNickname = new javax.swing.JLabel();
        jLabelClave = new javax.swing.JLabel();
        jTextFieldNickname = new javax.swing.JTextField();
        jPasswordFieldClave = new javax.swing.JPasswordField();
        jPanelBotones = new javax.swing.JPanel();
        jButtonEnviar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar sesión");

        jLabelDatos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/datos-usuario.png"))); // NOI18N
        jLabelDatos.setText("Ingrese sus datos");

        jLabelNickname.setText("Nickname:");

        jLabelClave.setText("Clave:");

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNickname)
                    .addComponent(jLabelClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordFieldClave)
                    .addComponent(jTextFieldNickname, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNickname)
                    .addComponent(jTextFieldNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClave)
                    .addComponent(jPasswordFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonEnviar.setText("Iniciar sesión");
        jPanelBotones.add(jButtonEnviar);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(jPanelContenedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDatos, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Comprueba si los datos ingresados pertenecen a un usuario activo.
     * 
     * @return Resultado de la comprobación.
     */
    public Usuario validarDatos() {
        Usuario usuario = datos.esUsuario(jTextFieldNickname.getText(), String.valueOf(jPasswordFieldClave.getPassword()));

        if (usuario == null) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Error, revise sus datos y vuelva a intentar.",
                    "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (usuario.getEstado().equals(Usuario.DESACTIVADO)) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Error, debe reactivar el usuario.",
                    "El usuario está inactivo", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            return null;
        }
        return usuario;
    }

    /**
     * Oculta la ventana y borra el texto de los campos del formulario.
     */
    @Override
    public void dispose() {
        jTextFieldNickname.setText(null);
        jPasswordFieldClave.setText(null);
        super.dispose();
    }

    //Getters y Setters.
    public int getModoAutenticacion() {
        return modoAutenticacion;
    }

    public void setModoAutenticacion(int modoAutenticacion) {
        this.modoAutenticacion = modoAutenticacion;
    }

    public JButton getjButtonEnviar() {
        return jButtonEnviar;
    }

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelDatos;
    private javax.swing.JLabel jLabelNickname;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPasswordField jPasswordFieldClave;
    private javax.swing.JTextField jTextFieldNickname;
    // End of variables declaration//GEN-END:variables
}
