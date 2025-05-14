
/**
 *
 * @author inmac
 */
package modelo.DAO;

import modelo.VO.ResultadoVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultadoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/analisis";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar un resultado de análisis
    public void insertarResultado(ResultadoVO resultado) {
        String sql = "INSERT INTO resultado (altura, anguloInclinacion, forma, anguloFrincionInterna, tiposRoturas, efectoAntropogenico, permeabilidad, factorSeguridad, significadoFactorSeguridad, indiceCompresionUnaria, resistenciaCorte, porcentajeSaturacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDouble(1, resultado.getAltura());
            stmt.setDouble(2, resultado.getAnguloInclinacion());
            stmt.setString(3, resultado.getForma());
            stmt.setDouble(4, resultado.getAnguloFrincionInterna());
            stmt.setString(5, resultado.getTiposRoturas());
            stmt.setString(6, resultado.getEfectoAntropogenico());
            stmt.setDouble(7, resultado.getPermeabilidad());
            stmt.setDouble(8, resultado.getFactorSeguridad());
            stmt.setString(9, resultado.getSignificadoFactorSeguridad());
            stmt.setDouble(10, resultado.getIndiceCompresionUnaria());
            stmt.setDouble(11, resultado.getResistenciaCorte());
            stmt.setDouble(12, resultado.getPorcentajeSaturacion());

            stmt.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                resultado.setCodAnalisis(rs.getInt(1));
            }

            System.out.println("Resultado insertado correctamente con ID: " + resultado.getCodAnalisis());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los resultados de análisis
    public List<ResultadoVO> obtenerResultados() {
        List<ResultadoVO> resultados = new ArrayList<>();
        String sql = "SELECT * FROM resultado";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ResultadoVO resultado = new ResultadoVO(
                        rs.getInt("codAnalisis"),
                        rs.getDouble("altura"),
                        rs.getDouble("anguloInclinacion"),
                        rs.getString("forma"),
                        rs.getDouble("anguloFrincionInterna"),
                        rs.getString("tiposRoturas"),
                        rs.getString("efectoAntropogenico"),
                        rs.getDouble("permeabilidad"),
                        rs.getDouble("factorSeguridad"),
                        rs.getString("significadoFactorSeguridad"),
                        rs.getDouble("indiceCompresionUnaria"),
                        rs.getDouble("resistenciaCorte"),
                        rs.getDouble("porcentajeSaturacion")
                );
                resultados.add(resultado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    // Método para actualizar un resultado de análisis
    public void actualizarResultado(ResultadoVO resultado) {
        String sql = "UPDATE resultado SET altura = ?, anguloInclinacion = ?, forma = ?, anguloFrincionInterna = ?, tiposRoturas = ?, efectoAntropogenico = ?, permeabilidad = ?, factorSeguridad = ?, significadoFactorSeguridad = ?, indiceCompresionUnaria = ?, resistenciaCorte = ?, porcentajeSaturacion = ? WHERE codAnalisis = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, resultado.getAltura());
            stmt.setDouble(2, resultado.getAnguloInclinacion());
            stmt.setString(3, resultado.getForma());
            stmt.setDouble(4, resultado.getAnguloFrincionInterna());
            stmt.setString(5, resultado.getTiposRoturas());
            stmt.setString(6, resultado.getEfectoAntropogenico());
            stmt.setDouble(7, resultado.getPermeabilidad());
            stmt.setDouble(8, resultado.getFactorSeguridad());
            stmt.setString(9, resultado.getSignificadoFactorSeguridad());
            stmt.setDouble(10, resultado.getIndiceCompresionUnaria());
            stmt.setDouble(11, resultado.getResistenciaCorte());
            stmt.setDouble(12, resultado.getPorcentajeSaturacion());
            stmt.setInt(13, resultado.getCodAnalisis());

            stmt.executeUpdate();
            System.out.println("Resultado actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un resultado de análisis
    public void eliminarResultado(int codAnalisis) {
        String sql = "DELETE FROM resultado WHERE codAnalisis = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codAnalisis);
            stmt.executeUpdate();
            System.out.println("Resultado eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
