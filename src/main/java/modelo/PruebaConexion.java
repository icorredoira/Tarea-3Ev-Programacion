/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author inmac
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class PruebaConexion {


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/geonorte?serverTimezone=UTC";
        String usuario = "root"; // Reemplaza con tu usuario de MySQL
        String contraseña = "Tortilla3000"; // Reemplaza con tu contraseña de MySQL

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("¡Conexión exitosa!");
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar:");
            e.printStackTrace();
        }
    }
}

