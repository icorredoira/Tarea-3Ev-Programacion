/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.VO.EstabilizacionVO;
/**
 *
 * @author inmac
 */
public class EstabilizacionDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/Geonorte?zeroDataTimeBehavior=CONVERT_TO_NULL&serverTimezone=Europe/Madrid [root on Default schema]";
    private static final String usuario = "root";
    private static final String contrasena = "Tortilla3000";

    //Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, usuario, contrasena);
    }
    
    // Método para insertar una estabilización
    public void insertarEstabilizacion(EstabilizacionVO estabilizacion) {
        String sql = "INSERT INTO estabilizacion (codEstabilizacion, codProyectoEstabilizacion) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, estabilizacion.getCodEstabilizacion());
            stmt.setInt(2, estabilizacion.getcodServicioEstabilizacion());
            stmt.executeUpdate();


            System.out.println("Estabilización insertada correctamente con ID: " + estabilizacion.getCodEstabilizacion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las estabilizaciones
    public List<EstabilizacionVO> obtenerEstabilizaciones() {
        List<EstabilizacionVO> estabilizaciones = new ArrayList<>();
        String sql = "SELECT * FROM estabilizacion";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EstabilizacionVO estabilizacion = new EstabilizacionVO(
                        rs.getInt("codEstabilizacion"),
                        rs.getInt("codServicioEstabilizacion")
                );
                estabilizaciones.add(estabilizacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estabilizaciones;
    }

    // Método para actualizar una estabilización
    public void actualizarEstabilizacion(EstabilizacionVO estabilizacion) {
        String sql = "UPDATE estabilizacion SET codEstabilizacion = ?, codServicioEstabilizacion = ? WHERE codEstabilizacion = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, estabilizacion.getcodServicioEstabilizacion());
            stmt.setInt(2, estabilizacion.getCodEstabilizacion());
            stmt.executeUpdate();
            System.out.println("Estabilización actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una estabilización
    public void eliminarEstabilizacion(int codEstabilizacion) {
        String sql = "DELETE FROM estabilizacion WHERE codEstabilizacion = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codEstabilizacion);
            stmt.executeUpdate();
            System.out.println("Estabilización eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
