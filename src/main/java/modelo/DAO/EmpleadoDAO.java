/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;
import java.sql.*;
import java.util.*;
import modelo.VO.EmpleadoVO;
import modelo.*;
import modelo.enumeraciones.Especialidad;
/**
 *
 * @author inmac
 */
public class EmpleadoDAO {
    
    private Connection conexion=null;

    public EmpleadoDAO() {
        conexion= Conexion.getConexion();
    }
    
    private Connection getConnection() throws SQLException {
    return Conexion.getConexion();
    }

    
    
    
    //Método para insertar una fila en la tabla
    
    public void insertarEmpleado(EmpleadoVO empleado)throws SQLException {
        String sql="INSERT INTO empleado (nif, telefono, nombre, apellidos, calle, numero, localidad, codigoPostal, especialidad, anosExperiencia, titulacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
        stmt.setString(1, empleado.getNif());
        stmt.setString(2, empleado.getTelefono());
        stmt.setString(3, empleado.getNombre());
        stmt.setString(4, empleado.getApellidos());
        stmt.setString(5, empleado.getCalle());
        stmt.setString(6, empleado.getNumero());
        stmt.setString(7, empleado.getLocalidad());
        stmt.setString(8, empleado.getCodigoPostal());
        stmt.setString(9, empleado.getEspecialidad().name()); //Se convierte la enum a String
        stmt.setInt(10, empleado.getAnosExperiencia());
        stmt.setString(11, empleado.getTitulacion());
        
        stmt.executeUpdate();
        System.out.println("El empleado se ha insertado correctamente");
    }catch(SQLException e){
            e.printStackTrace();}
    }
    
    
    
    //Método para obtener los empleados en una lista
    
    public List<EmpleadoVO>obtenerEmpleados(){
    
    List <EmpleadoVO>empleados=new ArrayList<>();
    String sql="SELECT * FROM empleado";
    
    try (Connection conn = getConnection();Statement stmt= conn.createStatement(); ResultSet rs=stmt.executeQuery(sql)){
            while (rs.next()){
            EmpleadoVO empleado= new EmpleadoVO(
            rs.getString("NIF"),
            rs.getString("telefono"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("calle"),
                    rs.getString("numero"),
                    rs.getString("localidad"),
                    rs.getString("codigoPostal"),
                    Especialidad.valueOf(rs.getString("especialidad")),
                    rs.getInt("anosExperiencia"),
                    rs.getString("titulacion")
            );
            empleados.add(empleado);
            }
    
    }catch(SQLException e){
            e.printStackTrace();}
    
    
    return empleados;
    }
    
    // Método para actualizar un empleado
    public void actualizarEmpleado(EmpleadoVO empleado) {
        String sql = "UPDATE empleados SET nif= ?, telefono = ?, nombre = ?, apellidos = ?, calle = ?, numero = ?, localidad = ?, codigoPostal = ?, especialidad = ?, anosExperiencia = ?, titulacion = ? WHERE nif = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getTelefono());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellidos());
            stmt.setString(4, empleado.getCalle());
            stmt.setString(5, empleado.getNumero());
            stmt.setString(6, empleado.getLocalidad());
            stmt.setString(7, empleado.getCodigoPostal());
            stmt.setString(8, empleado.getEspecialidad().name()); // Convertir enum a String
            stmt.setInt(9, empleado.getAnosExperiencia());
            stmt.setString(10, empleado.getTitulacion());
            stmt.setString(11, empleado.getNif());

            stmt.executeUpdate();
            System.out.println("Empleado actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un empleado
    public void eliminarEmpleado(String nif) {
        String sql = "DELETE FROM empleados WHERE nif = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nif);
            stmt.executeUpdate();
            System.out.println("Empleado eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
      public void insertarEmpleadoPrueba() {
    String sql = "INSERT INTO empleado (nif, telefono, nombre, apellidos, calle, numero, localidad, codigoPostal, especialidad, anosExperiencia, titulacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "12345678A");
        stmt.setString(2, "987654321");
        stmt.setString(3, "Prueba");
        stmt.setString(4, "Test");
        stmt.setString(5, "Calle Prueba");
        stmt.setString(6, "123");
        stmt.setString(7, "Ciudad Prueba");
        stmt.setString(8, "12345");
        stmt.setString(9, "ANALISTA"); //  Asegúrate de que esto coincida con un valor válido de tu enum
        stmt.setInt(10, 5);
        stmt.setString(11, "Grado Prueba");

        stmt.executeUpdate();
        System.out.println("Inserción de prueba exitosa");
    } catch (SQLException e) {
        System.err.println("Error en la inserción de prueba");
        e.printStackTrace();
    }
}
}


