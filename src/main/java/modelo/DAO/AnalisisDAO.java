/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.VO.AnalisisVO;

/**
 *
 * @author inmac
 */
public class AnalisisDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/Geonorte?zeroDataTimeBehavior=CONVERT_TO_NULL&serverTimezone=Europe/Madrid [root on Default schema]";
    private static final String usuario = "root";
    private static final String contrasena = "Tortilla3000";

    //Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, usuario, contrasena);
    }

    //Método para insertar una fila en la tabla
    public void insertarAnalisis(AnalisisVO analisis) {
        String sql = "INSERT INTO analisis (CodAnalisis, CodServicio) VALUES (?,?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, analisis.getCodAnalisis());
            stmt.setInt(2, analisis.getCodServicio());
            stmt.executeUpdate();
            System.out.println("Análisis insertado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(AnalisisDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    //Método para obtener toda la tabla Analisis
    public List<AnalisisVO> obtenerAnalisis() {
        List<AnalisisVO> listaAnalisis = new ArrayList<>();
        String sql = "SELECT * FROM analisis";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AnalisisVO analisis = new AnalisisVO(
                        rs.getInt("CodAnalisis"),
                        rs.getInt("CodServicio"));
                listaAnalisis.add(analisis);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return listaAnalisis;
    }

    //Método para actualizar una fila
    public void actualizarAnalisis(AnalisisVO analisis) {
        String sql = "UPDATE analisis SET CodAnalisis = ?, CodServicio=? WHERE CodAnalisis = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, analisis.getCodAnalisis());
            stmt.setInt(2, analisis.getCodServicio());
            stmt.executeUpdate();
            System.out.println("Analisis actualizado correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para eliminar una fila
    public void eliminarAnalisis(int codAnalisis) {
        String sql = "DELETE FROM analisis WHERE CodAnalisis=?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codAnalisis);
            stmt.executeUpdate();
            System.out.println("Análisis eliminado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
