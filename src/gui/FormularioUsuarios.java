package gui;

import datos.XMLUsuarios;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import juego.ListaUsuarios;
import juego.Usuario;

/**
 * Representa la interfaz para la gestión de los usuarios registrados.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class FormularioUsuarios extends javax.swing.JInternalFrame {

    private ListaUsuarios usuarios;
    private DefaultListModel modelo;
    private XMLUsuarios datos;

    /**
     * Crea un nuevo formulario para la gestión de usuarios.
     */
    public FormularioUsuarios() {
        modelo = new DefaultListModel();
        datos = new XMLUsuarios();
        initComponents();
        actualizarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGestionar = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        jLabelAvatar = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelNickname = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListUsuarios = new javax.swing.JList();
        jLabelUsuarios = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonDesactivar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios registrados");

        jLabelGestionar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelGestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/editar-usuario.png"))); // NOI18N
        jLabelGestionar.setText("Gestionar usuarios");

        jLabelAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAvatar.setText("Avatar");
        jLabelAvatar.setMaximumSize(new java.awt.Dimension(64, 64));
        jLabelAvatar.setMinimumSize(new java.awt.Dimension(64, 64));
        jLabelAvatar.setPreferredSize(new java.awt.Dimension(64, 64));

        jLabelNombre.setText("Nombre");

        jLabelApellido.setText("Apellido");

        jLabelNickname.setText("Nickname");

        jLabelEmail.setText("Email");

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jLabelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
                    .addGroup(jPanelContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNickname))
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
                        .addComponent(jLabelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelApellido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNickname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEmail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jListUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioSeleccionado(evt);
            }
        });
        jScrollPane1.setViewportView(jListUsuarios);

        jLabelUsuarios.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/usuario.png"))); // NOI18N
        jLabelUsuarios.setText("Usuarios");

        jButtonAgregar.setText("Agregar");
        jPanelBotones.add(jButtonAgregar);

        jButtonModificar.setText("Modificar");
        jButtonModificar.setEnabled(false);
        jPanelBotones.add(jButtonModificar);

        jButtonDesactivar.setText("Desactivar");
        jButtonDesactivar.setActionCommand("e");
        jButtonDesactivar.setEnabled(false);
        jPanelBotones.add(jButtonDesactivar);

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setEnabled(false);
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonEliminar);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonCerrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelGestionar)
                        .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsuarios)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelGestionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Lleva el formulario a su configuración inicial.
     */
    public void resetFormulario() {
        jLabelNombre.setText("Nombre");
        jLabelApellido.setText("Apellido");
        jLabelNickname.setText("Nickname");
        jLabelEmail.setText("Email");
        jLabelAvatar.setIcon(null);
        jButtonModificar.setEnabled(false);
        jButtonDesactivar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
    }

    /**
     * Actualiza la lista del modelo del componente JList.
     */
    public final void actualizarLista() {
        if ((usuarios = datos.leerUsuarios()) == null) {
            datos.crearArchivo();
        } else {
            modelo.removeAllElements();
            if (usuarios.size() > 0) {
                for (Usuario usuario : usuarios) {
                    modelo.addElement(usuario.getNombre() + " " + usuario.getApellido() + " - " + usuario.getNickname());
                }
            }
            jListUsuarios.setModel(modelo);
        }
    }

    @Override
    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (datos != null) {
            actualizarLista();
        }
    }

    //Getters y Setters.
    public ListaUsuarios getUsuarios() {
        return usuarios;
    }

    public JButton getjButtonAgregar() {
        return jButtonAgregar;
    }

    public JButton getjButtonDesactivar() {
        return jButtonDesactivar;
    }

    public JButton getjButtonModificar() {
        return jButtonModificar;
    }

    public Usuario getUsuarioSeleccionado() {
        try {
            return usuarios.get(jListUsuarios.getSelectedIndex());
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "Error, debe seleccionar un usuario.",
                    "No se seleccionó ningún usuario.", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Oculta el formulario.
     * 
     * @param evt 
     */
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    /**
     * Muestra los datos del usuario registrado en los campos.
     * 
     * @param evt 
     */
    private void usuarioSeleccionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioSeleccionado
        try {
            Usuario usuario = usuarios.get(jListUsuarios.getSelectedIndex());
            jLabelNombre.setText("Nombre: " + usuario.getNombre());
            jLabelApellido.setText("Apellido: " + usuario.getApellido());
            jLabelNickname.setText("Nickname: " + usuario.getNickname());
            jLabelEmail.setText("Email: " + usuario.getEmail());
            jLabelAvatar.setIcon(usuario.getAvatar());
            if (usuario.getEstado().equals(Usuario.ACTIVADO)) {
                jButtonDesactivar.setText("Desactivar");
                jButtonDesactivar.setEnabled(true);
                jButtonModificar.setEnabled(true);
                jButtonEliminar.setEnabled(false);
            } else {
                jButtonDesactivar.setText("Reactivar");
                jButtonDesactivar.setEnabled(true);
                jButtonEliminar.setEnabled(true);
                jButtonModificar.setEnabled(false);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showInternalMessageDialog(this.getParent(), "No hay ningún usuario registrado.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            System.err.println("La lista se cargó con problemas.");
        }

    }//GEN-LAST:event_usuarioSeleccionado

    /**
     * Guarda, a través de una instancia de XMLUsuarios, el usuario seleccionado.
     * 
     * @param evt
     */
    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        datos.eliminarUsuario(usuarios.get(jListUsuarios.getSelectedIndex()));
        resetFormulario();
        actualizarLista();
    }//GEN-LAST:event_jButtonEliminarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonDesactivar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelGestionar;
    private javax.swing.JLabel jLabelNickname;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelUsuarios;
    private javax.swing.JList jListUsuarios;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
