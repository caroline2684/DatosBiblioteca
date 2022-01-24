/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Caroline
 */
public class CRUDtransacciones {

    java.sql.Statement at;
    ResultSet rs;
    Conexioncrud con = new Conexioncrud();

    public void transaccion1(String cedula, String nombre, String apellido, String telefono, Integer ejemplar,
            Integer bibliotecario, Integer cliente, Integer tipo, String fechap, String fechad, String estado, Integer idcliente, String fechas) {
        Connection conexion = con.conectartransaccion();
        try {

            at = conexion.createStatement();
            String sql = "insert into clientes (ced_usuario,nom_usuario,ape_usuario,telf_usuario) "
                    + "values('" + cedula + "','" + nombre + "','" + apellido + "','" + telefono + "');";
            at.execute(sql);
            String sql1 = "insert into prestamos (id_ejemplar,id_bibliotecario,id_cliente,tipo_prestamo,fecha_prestamo,fecha_devolucion,estado_libro) "
                    + "values('" + ejemplar + "','" + bibliotecario + "','" + cliente + "','" + tipo + "','" + fechap + "','" + fechad + "','" + estado + "');";
            at.execute(sql1);
            String sql2 = "insert into visita (id_cliente,hora_salida)values('" + idcliente + "','" + fechas + "');";
            at.execute(sql2);
            String sql3 = "update ejemplares set estado_ejemplar='No disponible' where id_ejemplar='" + ejemplar + "';";
            at.execute(sql3);
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Transaccion realizada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
            if (conexion != null) {
                JOptionPane.showMessageDialog(null, "Rollback " + e, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                try {
                    conexion.rollback();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
                }
            }
        } finally {
            try {
                if (at != null) {
                    at.close();
                    conexion.close();
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public void transaccion2(Integer prestamo, Integer ejemplar, String fechadev, String estado, Integer devolucion, Integer ejemplar1, String anotacion) {
        Connection conexion = con.conectartransaccion();
        try {
            at = conexion.createStatement();
            String sql = "insert into ejemplar_devuelto(id_prestamo,id_ejemplar,fecha_recibido,estado_libro)"
                    + "values('" + prestamo + "','" + ejemplar + "','" + fechadev + "','" + estado + "');";
            at.execute(sql);
            String sql1 = "insert into anotaciones(id_devolucion,id_ejemplar,anotacion)"
                    + "values('" + devolucion + "','" + ejemplar1 + "','" + anotacion + "');";
            at.execute(sql1);
            String sql2 = "update ejemplares set estado_ejemplar='Disponible' where id_ejemplar='" + ejemplar + "';";
            at.execute(sql2);
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Transaccion realizada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
            if (conexion != null) {
                JOptionPane.showMessageDialog(null, "Rollback " + e, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                try {
                    conexion.rollback();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
                }
            }
        } finally {
            try {
                if (at != null) {
                    at.close();
                    conexion.close();
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
