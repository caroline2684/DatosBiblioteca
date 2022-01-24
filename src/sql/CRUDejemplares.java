/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import Variables.VariablesDatos;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Caroline
 */
public class CRUDejemplares extends Conexion {

    java.sql.Statement at;
    ResultSet rs;
    VariablesDatos var = new VariablesDatos();

    public void insertar(Integer idlibro, String estadoejemplar, String precioejemplar) {
        try {
            Connection conexion = conectar();
            at = conexion.createStatement();
            String sql = "insert into ejemplares(id_libro,estado_ejemplar,precio_ejemplar) values('" + idlibro + "','" + estadoejemplar + "','" + precioejemplar + "');";
            at.execute(sql);
            at.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void busqueda(Integer idejemplar) {
        try {
            Connection conexion = conectar();
            at = conexion.createStatement();
            String sql = "select * from ejemplares where id_ejemplar='" + idejemplar + "';";
            rs = at.executeQuery(sql);
            if (rs.next()) {
                VariablesDatos.setIdejemplar(rs.getInt("id_ejemplar"));
                VariablesDatos.setIdlibro(rs.getInt("id_libro"));
                VariablesDatos.setEstadoejemplar(rs.getString("estado_ejemplar"));
                VariablesDatos.setPrecioejemplar(rs.getString("precio_ejemplar"));
            } else {
                VariablesDatos.setIdejemplar(null);
                VariablesDatos.setIdlibro(null);
                VariablesDatos.setEstadoejemplar("");
                VariablesDatos.setPrecioejemplar("");
                JOptionPane.showMessageDialog(null, "no se encontro registro", "sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            at.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en programa " + e, "Erro de sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar(Integer idejemplar, Integer idlibro, String estadoejemplar, String precioejemplar) {
        try {
            Connection conexion = conectar();
            at = conexion.createStatement();
            String sql = "update ejemplares set id_libro='" + idlibro + "',estado_ejemplar='" + estadoejemplar + "',precio_ejemplar='" + precioejemplar + "' where id_ejemplar='" + idejemplar + "'; ";
            at.executeUpdate(sql);
            at.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(Integer idejemplar) {
        try {
            Connection conexion = conectar();
            at = conexion.createStatement();
            String sql = "delete from ejemplares where id_ejemplar='" + idejemplar + "'; ";
            at.executeUpdate(sql);
            at.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
