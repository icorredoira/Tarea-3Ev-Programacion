/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

/**
 *
 * @author inmac
 */
public class EstabilizacionVO {
    private int codEstabilizacion;
    private int codServicioEstabilizacion;

    public EstabilizacionVO(int codEstabilizacion, int codProyectoEstabilizacion) {
        this.codEstabilizacion = codEstabilizacion;
        this.codServicioEstabilizacion = codProyectoEstabilizacion;
    }

    public EstabilizacionVO() {
    }

    public int getCodEstabilizacion() {
        return codEstabilizacion;
    }

    public void setCodEstabilizacion(int codEstabilizacion) {
        this.codEstabilizacion = codEstabilizacion;
    }

    public int getcodServicioEstabilizacion() {
        return codServicioEstabilizacion;
    }

    public void setcodServicioEstabilizacion(int codServicioEstabilizacion) {
        this.codServicioEstabilizacion = codServicioEstabilizacion;
    }

    @Override
    public String toString() {
        return "EstabilizacionVO{" + "codEstabilizacion=" + codEstabilizacion + ", codServicioEstabilizacion=" + codServicioEstabilizacion + '}';
    }
    
    
    
}
