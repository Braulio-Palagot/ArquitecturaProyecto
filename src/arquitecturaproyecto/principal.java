package arquitecturaproyecto;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class principal extends javax.swing.JFrame {

    private menu pnlMenu = new menu();
    private login pnlLogin = null;
    private registro pnlRegistro = null;
    private perfil pnlPerfil = null;
    private foro pnlForo = null;
    private eventos pnlEvento = null;

    public principal() {
        initComponents();
        this.setLayout(new BorderLayout());

        loadLoginRegister();
        changeToLogin();

        pnlLogin.getBttnRegistrarse().addActionListener((ActionEvent e) -> {
            changeToRegistro();
        });
        pnlRegistro.getBttnRegresar().addActionListener((ActionEvent e) -> {
            changeToLogin();
        });
        pnlRegistro.getBttnConfirmarRegistrar().addActionListener((ActionEvent e) -> {
            // Agregar usuario a la base de datos.
            changeToLogin();
        });
        pnlLogin.getBttnIniciarSesion().addActionListener((ActionEvent e) -> {
            // Revisar en la BD del usuario.
            unloadLoginRegister();
            loadMain();
            changeToPerfil();
        });

        pnlMenu.getBttnPerfil().addActionListener((ActionEvent e) -> {
            changeToPerfil();
        });
        pnlMenu.getBttnForo().addActionListener((ActionEvent e) -> {
            changeToForo();
        });
        pnlMenu.getBttnLogout().addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION) == 0) {
                unloadMain();
                changeToLogin();
            }
        });
        pnlRegistro.getBttnConfirmarRegistrar().addActionListener((ActionEvent e) -> {
            // Registrar en la BD del usuario.
        });
    }

    private void loadMain() {
        if (pnlPerfil == null)
            pnlPerfil = new perfil();
        if (pnlForo == null) {
            pnlForo = new foro();
            pnlForo.getBttnEventoAnterior().addActionListener((ActionEvent e) -> {
                // Cambiar el evento al anterior y asegurar que el botón de evento siguiente está habilitado.
                if (!pnlForo.getBttnEventoSiguiente().isEnabled())
                    pnlForo.getBttnEventoSiguiente().setEnabled(true);
                // Si no hay otro evento anterior, deshabilitar el botón.
                pnlForo.getBttnEventoAnterior().setEnabled(false);
            });
            pnlForo.getBttnEventoSiguiente().addActionListener((ActionEvent e) -> {
                // Cambiar el evento al siguiente y asegurar que el botón de evento anterior está habilitado.
                if (!pnlForo.getBttnEventoAnterior().isEnabled())
                    pnlForo.getBttnEventoAnterior().setEnabled(true);
                // Si no hay otro evento siguiente, deshabilitar el botón.
                pnlForo.getBttnEventoSiguiente().setEnabled(false);
            });
            pnlForo.getBttnVerDetallesEvento().addActionListener((ActionEvent e) -> {
                changeToEvento();
            });
        }
        if (pnlEvento == null) {
            pnlEvento = new eventos();
            pnlEvento.getBttnPublicarComentario().addActionListener((ActionEvent e) -> {
                // Agregar comentario a la base de datos.
                // Mostrar dialog de éxito.
                JOptionPane.showMessageDialog(this, "Comentario publicado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            });
        }
        this.add(pnlMenu, BorderLayout.EAST);
        this.validate();
    }

    private void unloadMain() {
        pnlPerfil.setVisible(false);
        pnlForo.setVisible(false);
        pnlEvento.setVisible(false);
        pnlMenu.setVisible(false);
        this.remove(pnlMenu);
        this.remove(pnlPerfil);
        this.remove(pnlForo);
        this.remove(pnlEvento);
        this.validate();
    }

    private void changeToPerfil() {
        pnlMenu.setVisible(true);
        pnlPerfil.setVisible(true);
        pnlForo.setVisible(false);
        pnlEvento.setVisible(false);
        pnlMenu.getBttnPerfil().setVisible(false);
        pnlMenu.getBttnForo().setVisible(true);
        this.setTitle("Perfil");
        this.add(pnlPerfil, BorderLayout.CENTER);
        this.validate();
    }

    private void changeToForo() {
        pnlMenu.setVisible(true);
        pnlPerfil.setVisible(false);
        pnlForo.setVisible(true);
        pnlEvento.setVisible(false);
        pnlMenu.getBttnPerfil().setVisible(true);
        pnlMenu.getBttnForo().setVisible(false);
        pnlForo.getBttnEventoAnterior().setEnabled(false);
        this.setTitle("Foro");
        this.add(pnlForo, BorderLayout.CENTER);
        this.validate();
    }

    private void changeToEvento() {
        pnlMenu.setVisible(true);
        pnlPerfil.setVisible(false);
        pnlForo.setVisible(false);
        pnlEvento.setVisible(true);
        pnlMenu.getBttnPerfil().setVisible(true);
        pnlMenu.getBttnForo().setVisible(true);
        this.setTitle("Detalles del Evento");
        this.add(pnlEvento, BorderLayout.CENTER);
        this.validate();
    }

    private void loadLoginRegister() {
        if (pnlLogin == null)
            pnlLogin = new login();
        if (pnlRegistro == null)
            pnlRegistro = new registro();
    }

    private void unloadLoginRegister() {
        pnlLogin.setVisible(false);
        pnlRegistro.setVisible(false);
        this.remove(pnlLogin);
        this.remove(pnlRegistro);
        this.validate();
    }

    private void changeToRegistro() {
        pnlLogin.setVisible(false);
        pnlRegistro.setVisible(true);
        this.add(pnlRegistro, BorderLayout.CENTER);
        this.setTitle("Registrarse");
        this.validate();
    }

    private void changeToLogin() {
        pnlLogin.setVisible(true);
        pnlRegistro.setVisible(false);
        this.add(pnlLogin, BorderLayout.CENTER);
        this.setTitle("Iniciar Sesión");
        this.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
