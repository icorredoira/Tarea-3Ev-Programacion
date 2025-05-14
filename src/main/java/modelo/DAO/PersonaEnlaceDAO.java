/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author inmac
 */
package modelo.DAO;

import modelo.VO.PersonaEnlaceVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaEnlaceDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar una persona enlace
    public void insertarPersonaEnlace(PersonaEnlaceVO personaEnlace) {
        String sql = "INSERT INTO persona_enlace (codPersonaEnlace, tipoEmpresa, codCliente) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, personaEnlace.getCodPersonaEnlace());
            stmt.setString(2, personaEnlace.getTipoEmpresa());
            stmt.setString(3, personaEnlace.getCodCliente());

            stmt.executeUpdate();
            System.out.println("Persona enlace insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
