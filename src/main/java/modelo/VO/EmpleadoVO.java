/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

import modelo.enumeraciones.Especialidad;

/**
 *
 * @author inmac
 */
public class EmpleadoVO {
    private String nif;
    private String telefono;
    private String nombre;
    private String apellidos;
    private String calle;
    private String numero;
    private String localidad;
    private String codigoPostal;
    private Especialidad especialidad;
    private int anosExperiencia;
    private String titulacion;

    public EmpleadoVO() {
    }
    

    public EmpleadoVO(String nif, String telefono, String nombre, String apellidos, String calle, String numero, String localidad, String codigoPostal, Especialidad especialidad, int anosExperiencia, String titulacion) {
        this.nif = nif;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.especialidad = especialidad;
        this.anosExperiencia = anosExperiencia;
        this.titulacion = titulacion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString() {
        return "EmpleadoVO{" + "NIF=" + nif + ", telefono=" + telefono + ", nombre=" + nombre + ", apellidos=" + apellidos + ", calle=" + calle + ", numero=" + numero + ", localidad=" + localidad + ", codigoPostal=" + codigoPostal + ", especialidad=" + especialidad + ", anosExperiencia=" + anosExperiencia + ", titulacion=" + titulacion + '}';
    }
    
    
    
            
}
