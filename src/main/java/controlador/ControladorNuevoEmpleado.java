/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.DAO.EmpleadoDAO;
import modelo.VO.EmpleadoVO;
import modelo.enumeraciones.Especialidad;
import vista.NuevoEmpleado;
import java.sql.*;
import java.util.*;

/**
 *
 * @author inmac
 */
public class ControladorNuevoEmpleado {
    private NuevoEmpleado nuevoEmpleado;
    private EmpleadoDAO empleadoDAO;
    private ControladorPrincipal controladorPrincipal;
    private EmpleadoVO empleadoVO;

    public ControladorNuevoEmpleado(NuevoEmpleado nuevoEmpleado, ControladorPrincipal controladorPrincipal) {
        this.nuevoEmpleado = nuevoEmpleado;
        this.controladorPrincipal = controladorPrincipal;
        this.empleadoDAO= new EmpleadoDAO();
        this.empleadoVO=new EmpleadoVO();
        configurarEventosNuevoTrabajador();
    }
    
    public void configurarEventosNuevoTrabajador(){
    nuevoEmpleado.getjButtonCancelar().addActionListener(l-> {
        nuevoEmpleado.setVisible(false);
        controladorPrincipal.getPrincipal().setVisible(true);
    });
    nuevoEmpleado.getjButtonGuardar().addActionListener(l->guardarEmpleado());
    
    }
    
    private void guardarEmpleado() {
        EmpleadoVO empleado = new EmpleadoVO();

        String nif = nuevoEmpleado.getjTextFieldNIF().getText();
        nif = nif.trim();
        nif = nif.toUpperCase();
        empleado.setNif(nif);

        String nombre = nuevoEmpleado.getjTextFieldNombre().getText();
        empleado.setNombre(nombre);

        String apellidos = nuevoEmpleado.getjTextFieldApellidos().getText();
        empleado.setApellidos(apellidos);

        String telefono = nuevoEmpleado.getjTextFieldTelefono().getText();
        empleado.setTelefono(telefono);

        String calle = nuevoEmpleado.getjTextFieldCalle().getText();
        empleado.setCalle(calle);

        String numeroString = nuevoEmpleado.getjTextFieldNumero().getText();
        empleado.setNumero(numeroString);

        String localidad = nuevoEmpleado.getjTextFieldLocalidad().getText();
        empleado.setLocalidad(localidad);

        String titulacion = nuevoEmpleado.getjTextFieldTitulacion().getText();
        empleado.setTitulacion(titulacion);

        String codigoPostal = nuevoEmpleado.getjTextFieldCP().getText();
        empleado.setCodigoPostal(codigoPostal);

        String anosExperienciaString = nuevoEmpleado.getjTextFieldAnosExperiencia().getText();
        try {
            int anosExperiencia = Integer.parseInt(anosExperienciaString.trim());
            empleado.setAnosExperiencia(anosExperiencia);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir Años de Experiencia");
            e.printStackTrace();
            return;
        }

        Especialidad especialidadSeleccionada = (Especialidad) nuevoEmpleado.getjComboBoxEspecialidad().getSelectedItem();
        empleado.setEspecialidad(especialidadSeleccionada);

        try {
            empleadoDAO.insertarEmpleado(empleado);
            JOptionPane.showMessageDialog(null, "Empleado/a guardado correctamente");
        } catch (SQLException e) {
            System.err.println("Error al guardar el empleado/a");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el empleado/a");
        }
    }


}
    
  
    
    
    

