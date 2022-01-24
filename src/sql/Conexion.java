/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conexion = null;
    String url = "jdbc:postgresql://localhost:5433/Biblioteca_2parte";
    String usuario = "postgres";
    String clave = "123456";

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave);
            //JOptionPane.showMessageDialog(null,"Conexion Exitosa ","Conexion",JOptionPane.INFORMATION_MESSAGE);
            //conexion.setAutoCommit(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
    /*Connection conexion=null;
    String usuario="postgres";
    String contrasenia="Jade#2684";
    String db="Biblioteca_2parte";
    String ip="localhost";
    String puerto="5433";
    String cadena ="jdbc:postgresql://"+ip+":"+puerto+"/"+db;
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection(cadena,usuario,contrasenia);
            JOptionPane.showMessageDialog(null,"Conexion Exitosa ","Conexion",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al conectar "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }*/
}
