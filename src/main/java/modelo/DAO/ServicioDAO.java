
/**
 *
 * @author inmac
 */

package modelo.DAO;

import modelo.VO.ServicioVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar un servicio
    public void insertarServicio(ServicioVO servicio) {
        String sql = "INSERT INTO servicio (codLider) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, servicio.getCodLider());
            stmt.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                servicio.setCodServicio(rs.getInt(1));
            }

            System.out.println("Servicio insertado correctamente con ID: " + servicio.getCodServicio());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los servicios
    public List<ServicioVO> obtenerServicios() {
        List<ServicioVO> servicios = new ArrayList<>();
        String sql = "SELECT * FROM servicio";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ServicioVO servicio = new ServicioVO(
                        rs.getInt("codServicio"),
                        rs.getString("codLider")
                );
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicios;
    }

    // Método para actualizar un servicio
    public void actualizarServicio(ServicioVO servicio) {
        String sql = "UPDATE servicio SET codLider = ? WHERE codServicio = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, servicio.getCodLider());
            stmt.setInt(2, servicio.getCodServicio());

            stmt.executeUpdate();
            System.out.println("Servicio actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un servicio
    public void eliminarServicio(int codServicio) {
        String sql = "DELETE FROM servicio WHERE codServicio = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codServicio);
            stmt.executeUpdate();
            System.out.println("Servicio eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
