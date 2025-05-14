/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controlador;


import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.DAO.*;
import modelo.VO.*;
import modelo.enumeraciones.Especialidad;
import vista.*;

/**
 *
 * @author inmac
 */
public class ControladorPrincipal {
    private NuevoServicio nuevoServicio;
    private NuevaPropuesta nuevaPropuesta;
    private NuevoCliente nuevoCliente;
    private Buscar buscar;
    private NuevoEmpleado nuevoEmpleado;
    private Principal principal;
    private NuevoContrato nuevoContrato;
    private BuscarEmpleado buscarEmpleado;
    private ControladorNuevoEmpleado controladorNuevoEmpleado;

    
    public ControladorPrincipal(NuevoServicio nuevoServicio, NuevaPropuesta nuevaPropuesta, NuevoCliente nuevoCliente, Buscar buscar, NuevoEmpleado nuevoEmpleado, Principal principal, NuevoContrato nuevoContrato, BuscarEmpleado buscarEmpleado) {
        this.nuevoServicio = nuevoServicio;
        this.nuevaPropuesta = nuevaPropuesta;
        this.nuevoCliente = nuevoCliente;
        this.buscar = buscar;
        this.nuevoEmpleado = nuevoEmpleado;
        this.principal = principal;
        this.nuevoContrato = nuevoContrato;
        this.buscarEmpleado = buscarEmpleado;

        configurarEventosPrincipal();
        configurarEventosNuevoCliente();
        configurarEventosNuevaPropuesta();
        configurarEventosNuevoProyecto();
        configurarEventosNuevoContrato();
        configurarEventosBuscarTrabajador();
        configurarEventosBuscar();
    }
    
    

    
    public void configurarEventosPrincipal(){
        //Método para el botón nuevo cliente
        this.principal.getjButtonNuevoCliente().addActionListener (e -> {
        this.principal.setVisible(false);
        this.nuevoCliente.setVisible(true); });
        
        //Método botón nueva propuesta
        this.principal.getjButtonNuevaPropuesta().addActionListener(l -> {
        this.principal.setVisible(false);
        this.nuevaPropuesta.setVisible(true);
        });
        
        //Método botón nuevo trabajador
        
        this.principal.getjButtonNuevoTrabajador().addActionListener(t -> {
            this.principal.setVisible(false);
            this.nuevoEmpleado.setVisible(true);
        });
        
        //Método botón buscar
        this.principal.getjButtonBuscar().addActionListener(l ->{
        this.principal.setVisible(false);
        this.buscar.setVisible(true);
        });
        
        //Metodo botón nuevo contrato
        this.principal.getjButtonNuevoContrato().addActionListener(l ->{
        this.principal.setVisible(false);
        this.nuevoContrato.resetearCampos();
        this.nuevoContrato.setVisible(true);
        });
        
        //Método botón buscar trabajador
        this.principal.getjButtonBuscarTrabajador().addActionListener(l->{
            this.principal.setVisible(false);
            this.buscarEmpleado.setVisible(true);
        });
        
        //Método botón nuevo proyecto
        this.principal.getjButtonNuevoProyecto().addActionListener(e -> {
            this.nuevoServicio.resetearCampos();
            this.principal.setVisible(false);
            this.nuevoServicio.setVisible(true);
        });

    }
    
    public void configurarEventosNuevoCliente(){
        nuevoCliente.getjButtonSalir().addActionListener(l ->{
            nuevoCliente.setVisible(false);
            principal.setVisible(true);
        });
        
        
    
    }
    
    public void configurarEventosNuevaPropuesta(){
        nuevaPropuesta.getjButtonSalir().addActionListener(l -> {
            nuevaPropuesta.setVisible(false);
            principal.setVisible(true);
        });
    
    }
    
    public void configurarEventosNuevoProyecto(){
        nuevoServicio.getjButtonSalir().addActionListener(l ->{
            nuevoServicio.setVisible(false);
            principal.setVisible(true);
        });
        
        nuevoServicio.getjButtonAnadirMetodo().addActionListener(l-> {
            nuevoServicio.getjPanelMetodo().setVisible(true);
        });
        
        nuevoServicio.getjButtonCancelar().addActionListener(l->{
            nuevoServicio.getjPanelMetodo().setVisible(false);
        });
        
        nuevoServicio.getjComboBoxTipoServicio().addActionListener(l -> {
            String seleccion = (String) nuevoServicio.getjComboBoxTipoServicio().getSelectedItem();

            if (("Análisis de talud").equals(seleccion)) {
                nuevoServicio.getjPanelAnalisis().setVisible(true);
            } else {
                nuevoServicio.getjPanelAnalisis().setVisible(false);
            }
        });
        
        nuevoServicio.getjComboBoxEstabilización().addActionListener(l ->{
            String seleccion = (String)nuevoServicio.getjComboBoxEstabilización().getSelectedItem();
            
            if (("Sí").equals(seleccion)){
            nuevoServicio.getjPanelEstabilizacion().setVisible(true);
            }
            else{
            nuevoServicio.getjPanelEstabilizacion().setVisible(false);}
        });   
    }
    
    public void configurarEventosNuevoContrato() {
        nuevoContrato.getjButtonSalir().addActionListener(l -> {
            nuevoContrato.setVisible(false);
            principal.setVisible(true);
        });

        nuevoContrato.getjComboBoxModalidadPago().addActionListener(l -> {
            String seleccion = (String) nuevoContrato.getjComboBoxModalidadPago().getSelectedItem();
            if (("Pago a plazos").equals(seleccion)) {
                nuevoContrato.getjPanelPlazos().setVisible(true);
            } else {
                nuevoContrato.getjPanelPlazos().setVisible(false);
            }
        });
    }
    
    public void configurarEventosBuscarTrabajador(){
    buscarEmpleado.getjButtonSalir().addActionListener(l->{
        principal.setVisible(true);
        buscarEmpleado.setVisible(false);
    });
    }
    
  
    
    public void configurarEventosBuscar() {
        buscar.getjButtonSalir().addActionListener(l -> {
            buscar.setVisible(false);
            principal.setVisible(true);
            
        });
    }
    
    public Principal getPrincipal() {
        return this.principal;
    }

   
}