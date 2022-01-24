/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datosbiblioteca;

import sql.Conexion;

/**
 *
 * @author Caroline
 */
public class DatosBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Menu abrir=new Menu();
      abrir.setVisible(true);
      abrir.setLocationRelativeTo(null);
      Conexion objetoConexion=new Conexion();
      objetoConexion.conectar();
    }
    
}
