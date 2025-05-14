/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;

import java.sql.*;
import java.util.*;
import modelo.VO.ClienteVO;

/**
 *
 * @author inmac
 */
public class ClienteDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/Geonorte?zeroDataTimeBehavior=CONVERT_TO_NULL&serverTimezone=Europe/Madrid [root on Default schema]";
    private static final String usuario = "root";
    private static final String contrasena = "Tortilla3000";

    //Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, usuario, contrasena);
    }

    //Método para insertar una fila
    private void insertarCliente(ClienteVO cliente) {
        String sql = "INSERT INTO cliente (CodCliente, NIF, Telefono, Razon_Social, Calle, Numero, Localidad, CodigoPostal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCodCliente());
            stmt.setString(2, cliente.getNIF());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getRazonSocial());
            stmt.setString(5, cliente.getCalle());
            stmt.setString(6, cliente.getNumero());
            stmt.setString(7, cliente.getLocalidad());
            stmt.setLong(8, cliente.getCodigoPostal());
            stmt.executeUpdate();
            System.out.println("Cliente insertado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para obtener la tabla Cliente
    public List<ClienteVO> obtenerClientes() {
        List<ClienteVO> obtenerClientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ClienteVO cliente = new ClienteVO(
                        rs.getString("CodCliente"),
                        rs.getString("NIF"),
                        rs.getString("Telefono"),
                        rs.getString("Razon_Social"),
                        rs.getString("Calle"),
                        rs.getString("Numero"),
                        rs.getString("Localidad"),
                        rs.getLong("CodigoPostal")
                );
                obtenerClientes.add(cliente);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obtenerClientes;
    }

    //Método para actualizar una fila
    public void actualizarCliente(ClienteVO cliente) {
        String sql = "UPDATE cliente SET CodCliente=?, NIF=?, Telefono=?, Razon_Social=?, Calle=?, Numero=?, Localidad=?, CodigoPostal=?, ";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCodCliente());
            stmt.setString(2, cliente.getNIF());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getRazonSocial());
            stmt.setString(5, cliente.getCalle());
            stmt.setString(6, cliente.getNumero());
            stmt.setString(7, cliente.getLocalidad());
            stmt.setLong(8, cliente.getCodigoPostal());
            stmt.executeUpdate();
            System.out.println("Cliente actualizado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para eliminar una fila
    public void eliminarCliente (String codCliente){
    String sql = "DELETE FROM cliente WHERE CodCliente=?";
    
    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
    stmt.setString(1, codCliente);
    stmt.executeUpdate();
    System.out.println("Cliente eliminado correctamente");
    
    } catch (SQLException e){
    e.printStackTrace();}
    
    }
}
