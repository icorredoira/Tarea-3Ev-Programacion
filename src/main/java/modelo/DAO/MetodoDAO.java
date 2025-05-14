/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;

/**
 *
 * @author inmac
 */


import modelo.VO.MetodoVO;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MetodoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/servicios";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar un método
    public void insertarMetodo(MetodoVO metodo) {
        String sql = "INSERT INTO metodo (nombreMetodo, vidaUtil, fechaRevision, proveedor, coste, materialUtilizado, codServicioMetodo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, metodo.getNombreMetodo());
            stmt.setInt(2, metodo.getVidaUtil());
            stmt.setDate(3, Date.valueOf(metodo.getFechaRevision())); // Convertir LocalDate a Date
            stmt.setString(4, metodo.getProveedor());
            stmt.setDouble(5, metodo.getCoste());
            stmt.setString(6, metodo.getMaterialUtilizado());
            stmt.setInt(7, metodo.getCodServicioMetodo());

            stmt.executeUpdate();
            System.out.println("Método insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los métodos
    public List<MetodoVO> obtenerMetodos() {
        List<MetodoVO> metodos = new ArrayList<>();
        String sql = "SELECT * FROM metodo";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                MetodoVO metodo = new MetodoVO(
                        rs.getString("nombreMetodo"),
                        rs.getInt("vidaUtil"),
                        rs.getDate("fechaRevision").toLocalDate(), // Convertir Date a LocalDate
                        rs.getString("proveedor"),
                        rs.getDouble("coste"),
                        rs.getString("materialUtilizado"),
                        rs.getInt("codServicioMetodo")
                );
                metodos.add(metodo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metodos;
    }

    // Método para actualizar un método
    public void actualizarMetodo(MetodoVO metodo) {
        String sql = "UPDATE metodo SET vidaUtil = ?, fechaRevision = ?, proveedor = ?, coste = ?, materialUtilizado = ?, codServicioMetodo = ? WHERE nombreMetodo = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, metodo.getVidaUtil());
            stmt.setDate(2, Date.valueOf(metodo.getFechaRevision())); // Convertir LocalDate a Date
            stmt.setString(3, metodo.getProveedor());
            stmt.setDouble(4, metodo.getCoste());
            stmt.setString(5, metodo.getMaterialUtilizado());
            stmt.setInt(6, metodo.getCodServicioMetodo());
            stmt.setString(7, metodo.getNombreMetodo());

            stmt.executeUpdate();
            System.out.println("Método actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un método
    public void eliminarMetodo(String nombreMetodo) {
        String sql = "DELETE FROM metodo WHERE nombreMetodo = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreMetodo);
            stmt.executeUpdate();
            System.out.println("Método eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
