/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitecturaproyecto;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author jocel
 */
public class login extends javax.swing.JPanel {

    /**
     * Creates new form login
     */
    public login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtContraseniaUsuario = new javax.swing.JTextField();
        tCorreoUsuario = new javax.swing.JTextField();
        bttnRegistrarse = new javax.swing.JButton();
        bttnIniciarSesion = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Iniciar sesión");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, -1, -1));

        jLabel3.setText("Contraseña:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, -1, -1));

        jLabel2.setText("Correo:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 200, 180));
        add(txtContraseniaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 230, -1));
        add(tCorreoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 230, -1));

        bttnRegistrarse.setText("Registrarse");
        bttnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnRegistrarseActionPerformed(evt);
            }
        });
        add(bttnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, -1, -1));

        bttnIniciarSesion.setText("Iniciar sesión");
        bttnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnIniciarSesionActionPerformed(evt);
            }
        });
        add(bttnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void bttnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnIniciarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttnIniciarSesionActionPerformed

    private void bttnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnRegistrarseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttnRegistrarseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnIniciarSesion;
    private javax.swing.JButton bttnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tCorreoUsuario;
    private javax.swing.JTextField txtContraseniaUsuario;
    // End of variables declaration//GEN-END:variables

    public JButton getBttnIniciarSesion() {
        return bttnIniciarSesion;
    }

    public JButton getBttnRegistrarse() {
        return bttnRegistrarse;
    }

    public JTextField gettCorreoUsuario() {
        return tCorreoUsuario;
    }

    public JTextField getTxtContraseniaUsuario() {
        return txtContraseniaUsuario;
    }

    
}
