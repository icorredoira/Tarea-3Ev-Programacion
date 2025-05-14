/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author inmac
 */

package modelo.DAO;

import modelo.VO.PropuestaInicialVO;
import modelo.enumeraciones.Discontinuidades;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PropuestaInicialDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/proyectos";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar una propuesta inicial
    public void insertarPropuestaInicial(PropuestaInicialVO propuesta) {
        String sql = "INSERT INTO propuesta_inicial (coste, coordenadas, fechaInicio, fechaFin, margenContingencia, certificacionesLicencias, hayInvestigacion, porcentajeSaturacion, tiempoGarantia, tipoRoca, zonaTectonica, zonasSingulares, discontinuidades) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDouble(1, propuesta.getCoste());
            stmt.setString(2, propuesta.getCoordenadas());
            stmt.setDate(3, Date.valueOf(propuesta.getFechaInicio())); // Convertir LocalDate a Date
            stmt.setDate(4, Date.valueOf(propuesta.getFechaFin()));
            stmt.setDouble(5, propuesta.getMargenContingencia());
            stmt.setString(6, propuesta.getCertificacionesLicencias());
            stmt.setBoolean(7, propuesta.isHayInvestigacion());
            stmt.setDouble(8, propuesta.getPorcentajeSaturacion());
            stmt.setInt(9, propuesta.getTiempoGarantia());
            stmt.setString(10, propuesta.getTipoRoca());
            stmt.setString(11, propuesta.getZonaTectonica());
            stmt.setString(12, propuesta.getZonasSingulares());
            stmt.setString(13, propuesta.getDiscontinuidades().name()); // Convertir enum a String

            stmt.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                propuesta.setCodPropuestaInicial(rs.getInt(1));
            }

            System.out.println("Propuesta inicial insertada correctamente con ID: " + propuesta.getCodPropuestaInicial());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las propuestas iniciales
    public List<PropuestaInicialVO> obtenerPropuestasIniciales() {
        List<PropuestaInicialVO> propuestas = new ArrayList<>();
        String sql = "SELECT * FROM propuesta_inicial";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PropuestaInicialVO propuesta = new PropuestaInicialVO(
                        rs.getInt("codPropuestaInicial"),
                        rs.getDouble("coste"),
                        rs.getString("coordenadas"),
                        rs.getDate("fechaInicio").toLocalDate(), // Convertir Date a LocalDate
                        rs.getDate("fechaFin").toLocalDate(),
                        rs.getDouble("margenContingencia"),
                        rs.getString("certificacionesLicencias"),
                        rs.getBoolean("hayInvestigacion"),
                        rs.getDouble("porcentajeSaturacion"),
                        rs.getInt("tiempoGarantia"),
                        rs.getString("tipoRoca"),
                        rs.getString("zonaTectonica"),
                        rs.getString("zonasSingulares"),
                        Discontinuidades.valueOf(rs.getString("discontinuidades")) // Convertir String a Enum
                );
                propuestas.add(propuesta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propuestas;
    }

    // Método para actualizar una propuesta inicial
    public void actualizarPropuestaInicial(PropuestaInicialVO propuesta) {
        String sql = "UPDATE propuesta_inicial SET coste = ?, coordenadas = ?, fechaInicio = ?, fechaFin = ?, margenContingencia = ?, certificacionesLicencias = ?, hayInvestigacion = ?, porcentajeSaturacion = ?, tiempoGarantia = ?, tipoRoca = ?, zonaTectonica = ?, zonasSingulares = ?, discontinuidades = ? WHERE codPropuestaInicial = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, propuesta.getCoste());
            stmt.setString(2, propuesta.getCoordenadas());
            stmt.setDate(3, Date.valueOf(propuesta.getFechaInicio()));
            stmt.setDate(4, Date.valueOf(propuesta.getFechaFin()));
            stmt.setDouble(5, propuesta.getMargenContingencia());
            stmt.setString(6, propuesta.getCertificacionesLicencias());
            stmt.setBoolean(7, propuesta.isHayInvestigacion());
            stmt.setDouble(8, propuesta.getPorcentajeSaturacion());
            stmt.setInt(9, propuesta.getTiempoGarantia());
            stmt.setString(10, propuesta.getTipoRoca());
            stmt.setString(11, propuesta.getZonaTectonica());
            stmt.setString(12, propuesta.getZonasSingulares());
            stmt.setString(13, propuesta.getDiscontinuidades().name());
            stmt.setInt(14, propuesta.getCodPropuestaInicial());

            stmt.executeUpdate();
            System.out.println("Propuesta inicial actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una propuesta inicial
    public void eliminarPropuestaInicial(int codPropuestaInicial) {
        String sql = "DELETE FROM propuesta_inicial WHERE codPropuestaInicial = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codPropuestaInicial);
            stmt.executeUpdate();
            System.out.println("Propuesta inicial eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

   