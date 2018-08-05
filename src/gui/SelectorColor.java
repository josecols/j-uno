package gui;

/**
 * Representa la interfaz para la selección del color correspondiente
 * a una carta especial.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class SelectorColor extends javax.swing.JInternalFrame {

    private String seleccionado;

    /**
     * Crea una ventana con el título dado e inicializa sus componentes.
     * 
     * @param titulo Título de la ventana.
     */
    public SelectorColor(String titulo) {
        super(titulo);
        seleccionado = "";
        initComponents();
    }

    //Getters y setters.   
    public String getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(String seleccionado) {
        this.seleccionado = seleccionado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSelector1 = new javax.swing.JLabel();
        jLabelSelector3 = new javax.swing.JLabel();
        jLabelSelector4 = new javax.swing.JLabel();
        jLabelSelector2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(245, 260));
        setMinimumSize(new java.awt.Dimension(245, 260));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(245, 260));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jLabelSelector1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/selector1.png"))); // NOI18N
        jLabelSelector1.setText("jLabel1");
        jLabelSelector1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSelector1.setPreferredSize(new java.awt.Dimension(104, 104));
        jLabelSelector1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                azulSeleccionado(evt);
            }
        });
        getContentPane().add(jLabelSelector1);

        jLabelSelector3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/selector2.png"))); // NOI18N
        jLabelSelector3.setText("jLabel1");
        jLabelSelector3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSelector3.setPreferredSize(new java.awt.Dimension(104, 104));
        jLabelSelector3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verdeSeleccionado(evt);
            }
        });
        getContentPane().add(jLabelSelector3);

        jLabelSelector4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/selector3.png"))); // NOI18N
        jLabelSelector4.setText("jLabel1");
        jLabelSelector4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSelector4.setPreferredSize(new java.awt.Dimension(104, 104));
        jLabelSelector4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rojoSeleccionado(evt);
            }
        });
        getContentPane().add(jLabelSelector4);

        jLabelSelector2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/selector4.png"))); // NOI18N
        jLabelSelector2.setText("jLabel1");
        jLabelSelector2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSelector2.setPreferredSize(new java.awt.Dimension(104, 104));
        jLabelSelector2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amarilloSeleccionado(evt);
            }
        });
        getContentPane().add(jLabelSelector2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Establece como color seleccionado el azul.
     * 
     * @param evt 
     */
    private void azulSeleccionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_azulSeleccionado
        seleccionado = "azul";
    }//GEN-LAST:event_azulSeleccionado
    
    /**
     * Establece como color seleccionado el verde.
     * 
     * @param evt 
     */
    private void verdeSeleccionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verdeSeleccionado
        seleccionado = "verde";
    }//GEN-LAST:event_verdeSeleccionado
   
    /**
     * Establece como color seleccionado el rojo.
     * 
     * @param evt 
     */
    private void rojoSeleccionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rojoSeleccionado
        seleccionado = "rojo";
    }//GEN-LAST:event_rojoSeleccionado
    
    /**
     * Establece como color seleccionado el amarillo.
     * 
     * @param evt 
     */
    private void amarilloSeleccionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amarilloSeleccionado
        seleccionado = "amarillo";
    }//GEN-LAST:event_amarilloSeleccionado
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelSelector1;
    private javax.swing.JLabel jLabelSelector2;
    private javax.swing.JLabel jLabelSelector3;
    private javax.swing.JLabel jLabelSelector4;
    // End of variables declaration//GEN-END:variables
}
