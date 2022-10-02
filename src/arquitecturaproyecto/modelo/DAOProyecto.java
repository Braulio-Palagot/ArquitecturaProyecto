/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquitecturaproyecto.modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAOProyecto {

    Connection link = null;
    
    public Connection conectarBD(String clase, String url, String user, String pass) {

        try {
            Class.forName(clase);
            link = DriverManager.getConnection(url, user, pass);
            System.out.println("CONECTADO A LA BD");
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }
    
    public void desconectarBD() {
        try {
            link.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar con la base de datos");
        }
    }

    public String registrarUsuario(String nombreUsuario, String Correo, String apellidoPaternoUsuario,String apellidoMaternoUsuario,String contrasenia ) {
        String mensaje="";
        try {
            Statement st = null;
            //Sentencia SQl para registro de categoría
            String sentenciaSQL = "INSERT INTO usuario(nombreUsuario, Correo, apellidoPaternoUsuario, apellidoMaternoUsuario, contrasenia) VALUES ('" + nombreUsuario + "', '" + Correo + "', '" + apellidoPaternoUsuario + "', '" + apellidoMaternoUsuario + "', '" + contrasenia + "');";

            st = link.createStatement();
            st.executeUpdate(sentenciaSQL);
            mensaje = "Usuario registrado exitosamente.";
        } catch (SQLException e) {
            mensaje = "No se pudo registrar el usuario.";
            System.out.println(e);
        }
        return mensaje;
    }
    
    public ResultSet loggearUsuario(String Correo, String contrasenia) {
        ResultSet usuario = null;
        try {
            String sentenciaSQL = "SELECT * FROM usuario WHERE Correo = '"+Correo+"' AND contrasenia = '"+contrasenia+"';";
            PreparedStatement OBPST = link.prepareStatement(sentenciaSQL);

            usuario = OBPST.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuario;
    }
    
    public ResultSet informacionPerfil(String Correo) {
        ResultSet usuario = null;
        try {
            String sentenciaSQL = "SELECT t1.ID_Usuario, t1.nombreUsuario, t1.Correo, t1.apellidoPaternoUsuario, t1.apellidoMaternoUsuario, t2.nombre, t2.direccion, t2.fecha FROM usuario t1 "
                    + "           INNER JOIN  evento t2  ON t1.id_usuario = t2.id_usuario "
                    + "           WHERE t1.Correo = '"+Correo+ "';";
            PreparedStatement OBPST = link.prepareStatement(sentenciaSQL);

            usuario = OBPST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public ResultSet informacionEvento(int id_evento) {
        ResultSet evento = null;
        try {
            String sentenciaSQL = "SELECT t1.ID_Evento, t1.nombre, t2.tema, t2.documentacion FROM evento t1 " +
                                    "INNER JOIN ponencia t2 ON t1.ID_Ponencia = t2.ID_Ponencia " +
                                    "WHERE t1.ID_Evento = "+id_evento+";";
            PreparedStatement OBPST = link.prepareStatement(sentenciaSQL);
            
            evento = OBPST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evento;
    }
    
    public String insertarComentario(String Comentario, int id_evento, int id_usuario) {
        String mensaje="";
        try {
            Statement st = null;
            //Sentencia SQl para registro de categoría
            String sentenciaSQL = "INSERT INTO comentario(Comentario, ID_Evento, ID_Usuario) VALUES ('"+Comentario+"', "+id_evento+", "+id_usuario+");";

            st = link.createStatement();
            st.executeUpdate(sentenciaSQL);
            mensaje = "Comentario publicado exitosamente.";
            System.out.println("Entró al try");
        } catch (SQLException e) {
            mensaje = "No se pudo publicar su comentario.";
            System.out.println("Entró al catch");
            System.out.println(e);
        }
        return mensaje;
    }
    
    public ResultSet selectEventos() {
       ResultSet eventos = null;
       String sentenciaSQL = "SELECT * FROM evento;";
       
        try {  
            PreparedStatement OBPST = link.prepareCall(sentenciaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            eventos = OBPST.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventos;
    }
}
