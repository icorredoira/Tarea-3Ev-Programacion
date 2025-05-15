/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import com.formdev.flatlaf.FlatIntelliJLaf;
import controlador.ControladorBuscarEmpleado;
import controlador.ControladorNuevoEmpleado;
import controlador.ControladorPrincipal;
import javax.swing.UIManager;
import modelo.DAO.EmpleadoDAO;
import vista.*;

/**
 *
 * @author inmac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try{
       UIManager.setLookAndFeel(new FlatIntelliJLaf());
       
       
       
        /* Create and display the form */
         javax.swing.SwingUtilities.invokeLater(() -> {
        
        Principal ventanaPrincipal = new Principal();
        NuevoCliente nuevoCliente= new NuevoCliente();
        NuevaPropuesta nuevaPropuesta = new NuevaPropuesta();
        NuevoServicio nuevoServicio = new NuevoServicio();
        nuevoServicio.getjPanelMetodo().setVisible(false);
        Buscar buscar= new Buscar();
        NuevoEmpleado nuevoEmpleado = new NuevoEmpleado();
        NuevoContrato nuevoContrato= new NuevoContrato();
        BuscarEmpleado buscarEmpleado = new BuscarEmpleado();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        
        
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal (nuevoServicio, nuevaPropuesta, nuevoCliente, buscar, nuevoEmpleado, ventanaPrincipal, nuevoContrato, buscarEmpleado);
        ControladorNuevoEmpleado controladorNuevoEmpleado = new ControladorNuevoEmpleado(nuevoEmpleado, controladorPrincipal);
        ControladorBuscarEmpleado controladorBuscarEmpleado = new ControladorBuscarEmpleado (buscarEmpleado, controladorPrincipal, empleadoDAO);

        
        
        
        
        ventanaPrincipal.setVisible(true);
        
         });
        
    }catch(Exception e){
       e.printStackTrace();}; 
    
}}
