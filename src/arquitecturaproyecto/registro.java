/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitecturaproyecto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author jocel
 */
public class registro extends javax.swing.JPanel {

    /**
     * Creates new form x
     */
    public registro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtContraseniaRep = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bttnRegresar = new javax.swing.JButton();
        bttnConfirmarRegistrar = new javax.swing.JButton();
        cmbGenero = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 170, 150));

        jLabel1.setText("Nombre");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 60, -1));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 170, -1));

        jLabel2.setText("Edad");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 60, -1));
        add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 170, -1));

        jLabel3.setText("Dirección");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 60, -1));
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 170, -1));

        jLabel4.setText("Teléfono");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, -1, -1));
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, 140, -1));

        jLabel5.setText("Correo");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, -1, -1));
        add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 140, -1));

        jLabel6.setText("Contraseña");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, -1, -1));
        add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 470, 140, -1));

        jLabel7.setText("Género");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 60, -1));

        jLabel8.setText("Repetir contraseña");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, -1, -1));
        add(txtContraseniaRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 510, 140, -1));

        jLabel9.setText("Registrarse");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, -1, -1));

        bttnRegresar.setText("Cancelar");
        add(bttnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 600, -1, -1));

        bttnConfirmarRegistrar.setText("Registrarse");
        bttnConfirmarRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConfirmarRegistrarActionPerformed(evt);
            }
        });
        add(bttnConfirmarRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 600, -1, -1));

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGeneroActionPerformed(evt);
            }
        });
        add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 170, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cmbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGeneroActionPerformed

    private void bttnConfirmarRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmarRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttnConfirmarRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnConfirmarRegistrar;
    private javax.swing.JButton bttnRegresar;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtContraseniaRep;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public JButton getBttnConfirmarRegistrar() {
        return bttnConfirmarRegistrar;
    }

    public JButton getBttnRegresar() {
        return bttnRegresar;
    }

    public JComboBox<String> getCmbGenero() {
        return cmbGenero;
    }

    public JTextField getTxtContrasenia() {
        return txtContrasenia;
    }

    public JTextField getTxtContraseniaRep() {
        return txtContraseniaRep;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    
}
