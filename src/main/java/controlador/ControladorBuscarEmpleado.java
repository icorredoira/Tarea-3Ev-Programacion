/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.DAO.EmpleadoDAO;
import modelo.VO.EmpleadoVO;
import vista.*;

/**
 *
 * @author inmac
 */
public class ControladorBuscarEmpleado {
    private BuscarEmpleado vistaBuscarEmpleado;
    private EmpleadoDAO empleadoDAO;
    private Principal principal;
    private ControladorPrincipal controladorPrincipal;
    private EmpleadoVO empleadoVO;

    public ControladorBuscarEmpleado(BuscarEmpleado vistaBuscarEmpleado, ControladorPrincipal controladorPrincipal, EmpleadoDAO empleadoDAO) {
        this.vistaBuscarEmpleado = vistaBuscarEmpleado;
        this.empleadoDAO =  new EmpleadoDAO();
        this.controladorPrincipal=controladorPrincipal;
        
        
        vistaBuscarEmpleado.getjButtonBuscar().addActionListener(e -> {
            try {
                buscarEmpleado();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorBuscarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vistaBuscarEmpleado.getjButtonMostrarTodos().addActionListener(e -> mostrarTodos());
        //vistaBuscarEmpleado.getjButtonModificar().addActionListener(e -> modificarEmpleado());
    configurarEventosBuscarTrabajador();

        
    }
    
    public void configurarEventosBuscarTrabajador(){
    vistaBuscarEmpleado.getjButtonSalir().addActionListener(l->{
       controladorPrincipal.getPrincipal().setVisible(true);
        vistaBuscarEmpleado.setVisible(false);
    });
    }
    public void buscarEmpleado() throws SQLException{
    String nif = vistaBuscarEmpleado.getjTextFieldNIF().getText().trim();
    String telefono = vistaBuscarEmpleado.getjTextFieldTelefono().getText().trim();
    EmpleadoVO empleado = empleadoDAO.buscar(nif, telefono);
    
    if (empleado!=null){
        List<EmpleadoVO> lista = new ArrayList<>();
        lista.add(empleado);
    vistaBuscarEmpleado.mostrarEmpleadosTabla(lista);
    } else{
    JOptionPane.showMessageDialog(vistaBuscarEmpleado, "Empleado/a no encontrado/a");
    }
    }
    
    private void mostrarTodos(){
    java.util.List<EmpleadoVO> empleados = empleadoDAO.obtenerEmpleados();
    vistaBuscarEmpleado.mostrarEmpleadosTabla(empleados);
    }
    
    
    
}
