

/**
 *
 * @author inmac
 */
    
package modelo.DAO;

import modelo.VO.TrabajaEnVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajaEnDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar una relación trabajador-servicio
    public void insertarTrabajaEn(TrabajaEnVO trabajaEn) {
        String sql = "INSERT INTO trabaja_en (codServicio, nifTrabajador) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, trabajaEn.getCodServicio());
            stmt.setString(2, trabajaEn.getNifTrabajador());
            stmt.executeUpdate();
            System.out.println("Relación trabajador-servicio insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las relaciones trabajador-servicio
    public List<TrabajaEnVO> obtenerTrabajaEn() {
        List<TrabajaEnVO> trabajaEnLista = new ArrayList<>();
        String sql = "SELECT * FROM trabaja_en";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TrabajaEnVO trabajaEn = new TrabajaEnVO(
                        rs.getInt("codServicio"),
                        rs.getString("nifTrabajador")
                );
                trabajaEnLista.add(trabajaEn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trabajaEnLista;
    }

    // Método para actualizar la relación trabajador-servicio
    public void actualizarTrabajaEn(TrabajaEnVO trabajaEn, int nuevoCodServicio) {
        String sql = "UPDATE trabaja_en SET codServicio = ? WHERE nifTrabajador = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nuevoCodServicio);
            stmt.setString(2, trabajaEn.getNifTrabajador());
            stmt.executeUpdate();
            System.out.println("Relación trabajador-servicio actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una relación trabajador-servicio
    public void eliminarTrabajaEn(int codServicio, String nifTrabajador) {
        String sql = "DELETE FROM trabaja_en WHERE codServicio = ? AND nifTrabajador = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codServicio);
            stmt.setString(2, nifTrabajador);
            stmt.executeUpdate();
            System.out.println("Relación trabajador-servicio eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

