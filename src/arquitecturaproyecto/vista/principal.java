package arquitecturaproyecto.vista;

import arquitecturaproyecto.modelo.DAOProyecto;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class principal extends javax.swing.JFrame {

    private final menu pnlMenu = new menu();
    private login pnlLogin = null;
    private registro pnlRegistro = null;
    private perfil pnlPerfil = null;
    private foro pnlForo = null;
    private eventos pnlEvento = null;

    String db = "casoestudiobd";
    String url = "jdbc:mysql://localhost/" + db;
    String user = "root";
    String pass = "";
    String clase = "com.mysql.cj.jdbc.Driver";
    
    ResultSet usuario = null;
    String correoUsuario = "";
    int id_usuario = -1;
    int totalEventos = 0;
    ResultSet eventos = null;

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
            DAOProyecto dao = new DAOProyecto();
            String nombreUsuario = pnlRegistro.getTxtNombre().getText().trim();
            String apPaterno = pnlRegistro.getTxtApPat().getText().trim();
            String apMaterno = pnlRegistro.getTxtApMat().getText().trim();
            String correo = pnlRegistro.getTxtCorreo().getText().trim();
            String contrasenia = pnlRegistro.getTxtContrasenia().getText().trim();
            String contraseniaRep = pnlRegistro.getTxtContraseniaRep().getText().trim();
            
            if (nombreUsuario == null ||
                apPaterno == null ||
                apMaterno == null ||
                correo == null ||
                contrasenia == null ||
                contraseniaRep == null) {
                JOptionPane.showMessageDialog(this, "Debe capturar todos los datos.", "Faltan Datos", JOptionPane.ERROR_MESSAGE);
            } else {
                dao.conectarBD(clase, url, user, pass);
                String mensaje = dao.registrarUsuario(nombreUsuario, correo, apPaterno, apMaterno, contrasenia);
                JOptionPane.showMessageDialog(this, mensaje, "Estado de Registro", JOptionPane.INFORMATION_MESSAGE);
                dao.desconectarBD();
                changeToLogin();
            }
        });
        pnlLogin.getBttnIniciarSesion().addActionListener((ActionEvent e) -> {
            DAOProyecto dao = new DAOProyecto();
            String correo = pnlLogin.gettCorreoUsuario().getText().trim();
            String contrasenia = pnlLogin.getTxtContraseniaUsuario().getText().trim();
            
            if (correo == null ||
                contrasenia == null) {
                JOptionPane.showMessageDialog(this, "Debe capturar todos los datos.", "Faltan Datos", JOptionPane.ERROR_MESSAGE);
            } else {
                dao.conectarBD(clase, url, user, pass);
                try {
                    usuario = dao.loggearUsuario(correo, contrasenia);
                    usuario.next();
                    correoUsuario = usuario.getString("Correo");
                    id_usuario = usuario.getInt("ID_Usuario");
                    System.out.println(correoUsuario);
                    unloadLoginRegister();
                    loadMain();
                    changeToPerfil();
                    loadPerfil();
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "No se encontró el usuario.", "Error al Iniciar Sesión", JOptionPane.ERROR_MESSAGE);
                }
                dao.desconectarBD();
            }
        });

        pnlMenu.getBttnPerfil().addActionListener((ActionEvent e) -> {
            changeToPerfil();
            loadPerfil();
        });
        pnlMenu.getBttnForo().addActionListener((ActionEvent e) -> {
            changeToForo();
            loadForo();
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
    
    private void loadForo() {
        totalEventos = 0;
        DAOProyecto dao = new DAOProyecto();
        dao.desconectarBD();
        dao.conectarBD(clase, url, user, pass);
        eventos = null;
        
        eventos = dao.selectEventos();
        
        try {
            pnlForo.getBttnEventoSiguiente().setEnabled(true);
            eventos.beforeFirst();
            while (eventos.next()) {
                totalEventos++;
            }
            eventos.beforeFirst();
            eventos.next();
            pnlForo.getLblNombre().setText(eventos.getString("nombre"));
            pnlForo.getLblDireccion().setText(eventos.getString("direccion"));
            pnlForo.getLblFecha().setText(eventos.getString("fecha"));
            pnlForo.getLblNumeroEvento().setText(eventos.getString("ID_Evento"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        pnlForo.getLblTotalEventos().setText(""+totalEventos+"");
    }
    
    private void loadPerfil() {
        DAOProyecto dao = new DAOProyecto();
        dao.desconectarBD();
        dao.conectarBD(clase, url, user, pass);
        ResultSet infoUsuario = null;
        
        infoUsuario = dao.informacionPerfil(correoUsuario);
        String datos = "";
        DefaultTableModel eventoModel = null;
        try {
            infoUsuario.next();
            datos = "Nombre: " + infoUsuario.getString("nombreUsuario");
            pnlPerfil.getLblNombre().setText(datos);
            datos = "Apellido Paterno: " + infoUsuario.getString("apellidoPaternoUsuario");
            pnlPerfil.getLblApePat().setText(datos);
            datos = "Apellido Materno: " + infoUsuario.getString("apellidoMaternoUsuario");
            pnlPerfil.getLblApeMat().setText(datos);
            datos = "Correo: " + infoUsuario.getString("Correo");
            pnlPerfil.getLblCorreo().setText(datos);
            
            eventoModel = (DefaultTableModel) pnlPerfil.getTblEventosUsuario().getModel();
            eventoModel.setRowCount(0);
            do {
                // System.out.println(rst.getString(1) + rst.getString(2) + rst.getString(3)
                // + rst.getString(4) + rst.getString(5));
                eventoModel.addRow(new String[]{infoUsuario.getString("nombre"), infoUsuario.getString("direccion"),
                                infoUsuario.getString("fecha")});
            } while (infoUsuario.next());
            dao.desconectarBD(); //Desconectamos la BD
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadMain() {
        if (pnlPerfil == null)
            pnlPerfil = new perfil();
        if (pnlForo == null) {
            pnlForo = new foro();
            pnlForo.getBttnEventoAnterior().addActionListener((ActionEvent e) -> {
                try {
                    // Cambiar el evento al siguiente y asegurar que el botón de evento anterior está habilitado.
                    if (eventos.previous()) {
                        pnlForo.getLblNombre().setText(eventos.getString("nombre"));
                        pnlForo.getLblDireccion().setText(eventos.getString("direccion"));
                        pnlForo.getLblFecha().setText(eventos.getString("fecha"));
                        pnlForo.getLblNumeroEvento().setText(eventos.getString("ID_Evento"));
                        pnlForo.getBttnEventoSiguiente().setEnabled(true);
                        if (eventos.isFirst())
                            pnlForo.getBttnEventoAnterior().setEnabled(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            pnlForo.getBttnEventoSiguiente().addActionListener((ActionEvent e) -> {
                try {
                    // Cambiar el evento al siguiente y asegurar que el botón de evento anterior está habilitado.
                    if (eventos.next()) {
                        pnlForo.getLblNombre().setText(eventos.getString("nombre"));
                        pnlForo.getLblDireccion().setText(eventos.getString("direccion"));
                        pnlForo.getLblFecha().setText(eventos.getString("fecha"));
                        pnlForo.getLblNumeroEvento().setText(eventos.getString("ID_Evento"));
                        pnlForo.getBttnEventoAnterior().setEnabled(true);
                        if (eventos.isLast())
                            pnlForo.getBttnEventoSiguiente().setEnabled(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            pnlForo.getBttnVerDetallesEvento().addActionListener((ActionEvent e) -> {
                changeToEvento();
                loadDetallesEvento();
            });
        }
        if (pnlEvento == null) {
            pnlEvento = new eventos();
            pnlEvento.getBttnPublicarComentario().addActionListener((ActionEvent e) -> {
                DAOProyecto dao = new DAOProyecto();
                dao.conectarBD(clase, url, user, pass);
                try {
                    String mensaje = dao.insertarComentario(pnlEvento.getTxtComentario().getText().trim(), eventos.getInt("ID_Evento"), id_usuario);
                    JOptionPane.showMessageDialog(this, mensaje, "Comentario", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        this.add(pnlMenu, BorderLayout.EAST);
        this.validate();
    }
    
    private void loadDetallesEvento() {
        DAOProyecto dao = new DAOProyecto();
        dao.desconectarBD();
        dao.conectarBD(clase, url, user, pass);
        ResultSet infoEvento = null;
        String datos = "";
        DefaultTableModel ponenciasModel = null;
        try {
            infoEvento = dao.informacionEvento(eventos.getInt("ID_Evento"));
            infoEvento.next();
            datos = "Nombre: " + infoEvento.getString("nombre");
            pnlEvento.getLblDescripcionEvento().setText(datos);
            
            ponenciasModel = (DefaultTableModel) pnlEvento.getTblPonencias().getModel();
            ponenciasModel.setRowCount(0);
            do {
                // System.out.println(rst.getString(1) + rst.getString(2) + rst.getString(3)
                // + rst.getString(4) + rst.getString(5));
                ponenciasModel.addRow(new String[]{infoEvento.getString("tema"), infoEvento.getString("documentacion")});
            } while (infoEvento.next());
            dao.desconectarBD(); //Desconectamos la BD
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        
        pnlLogin.getTxtContraseniaUsuario().setText("");
        pnlLogin.gettCorreoUsuario().setText("");
        
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
