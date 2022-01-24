/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import Variables.VariablesLibros;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 * 
 * @author Caroline
 */
public class CRUDsql extends Conexion {

    java.sql.Statement at;
    ResultSet rs;
    VariablesLibros var = new VariablesLibros();

    public void insertar(String isbn1, String autor1, String titulo1, String genero1, String pais1, String paginas1, String edicion1, Integer editorial1, String proveedor, String fecha, String precio) {
        try {
            Connection conexion = conectar();
            at = conexion.createStatement();
            String sql = "insert into libros(isbn,autor,titulo_libro,genero,pais,num_paginas,edicion,id_editorial, proveedor,fecha_entrada,precio_libro) values('" + isbn1 + "','" + autor1 + "','" + titulo1 + "','" + genero1 + "','" + pais1 + "','" + paginas1 + "','" + edicion1 + "','" + editorial1 + "','" + proveedor + "','" + fecha + "','" + precio + "');";
            at.execute(sql);
            at.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void busqueda(String idlibro) {
        try {
            Connection conexion = conectar();
            at = conexion.createStatement();
            String sql = "select * from libros where id_libro='" + idlibro + "';";
            rs = at.executeQuery(sql);
            if (rs.next()) {
                VariablesLibros.setIdlibro(rs.getInt("id_libro"));
                VariablesLibros.setIsbn1(rs.getString("isbn"));
                VariablesLibros.setAutor1(rs.getString("autor"));
                VariablesLibros.setTitulo1(rs.getString("titulo_libro"));
                VariablesLibros.setGenero1(rs.getString("genero"));
                VariablesLibros.setPais1(rs.getString("pais"));
                VariablesLibros.setPaginas1(rs.getString("num_paginas"));
                VariablesLibros.setEdicion1(rs.getString("edicion"));
                VariablesLibros.setEditorial1(rs.getInt("id_editorial"));
                VariablesLibros.setProveedor(rs.getString("proveedor"));
                VariablesLibros.setFecha(rs.getString("fecha_entrada"));
                VariablesLibros.setPrecio(rs.getString("precio_libro"));
            } else {
                VariablesLibros.setIdlibro(null);
                VariablesLibros.setIsbn1("");
                VariablesLibros.setAutor1("");
                VariablesLibros.setTitulo1("");
                VariablesLibros.setGenero1("");
                VariablesLibros.setPais1("");
                VariablesLibros.setPaginas1("");
                VariablesLibros.setEdicion1("");
                VariablesLibros.setEditorial1(null);
                VariablesLibros.setProveedor("");
                VariablesLibros.setFecha("");
                VariablesLibros.setPrecio("");
                JOptionPane.showMessageDialog(null, "no se encontro registro", "sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            at.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en el programa " + e, "Erro de sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar(Integer idlibro, String isbn1, String autor1, String titulo1, String genero1, String pais1, String paginas1, String edicion1, Integer editorial1, String proveedor, String fecha, String precio) {
        try {
            Connection conexion = conectar();
            at = conexion.createStatement();
            String sql = "update libros set isbn='" + isbn1 + "',autor='" + autor1 + "',titulo_libro='" + titulo1 + "',genero='" + genero1 + "',pais='" + pais1 + "',num_paginas='" + paginas1 + "',edicion='" + edicion1 + "',id_editorial='" + editorial1 + "',proveedor='" + proveedor + "',fecha_entrada='" + fecha + "',precio_libro='" + precio + "' where id_libro='" + idlibro + "'; ";
            at.executeUpdate(sql);
            at.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(Integer idlibro) {

        try {
            Connection conexion = conectar();
            at = conexion.createStatement();
            String sql = "delete from libros where id_libro='" + idlibro + "'; ";
            at.executeUpdate(sql);
            at.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
