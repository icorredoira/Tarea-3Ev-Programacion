/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;

/**
 *
 * @author inmac
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/geonorte?serverTimezone=UTC";
    private static final String usuario = "root";
    private static final String contrasena = "Tortilla3000";
    private static Connection conexion = null;

    private Conexion() {
    }

    public static Connection getConexion() throws SQLException {
        try {
            if (conexion == null || conexion.isClosed()) {

                conexion = DriverManager.getConnection(URL, usuario, contrasena);
                System.out.println("Conexión establacida correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar la bd");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                conexion = null;
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
