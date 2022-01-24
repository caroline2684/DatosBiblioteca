/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Caroline
 */
public class Conexioncrud {
    Connection conexion = null;
    String url = "jdbc:postgresql://localhost:5433/Biblioteca_2parte";
    String usuario = "postgres";
    String clave = "123456";

    public Connection conectartransaccion() {
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave);
            //JOptionPane.showMessageDialog(null,"Conexion Exitosa ","Conexion",JOptionPane.INFORMATION_MESSAGE);
            conexion.setAutoCommit(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
}
