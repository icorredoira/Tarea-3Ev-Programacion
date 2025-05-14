/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

/**
 *
 * @author inmac
 */
public class TrabajaEnVO {
    private int codServicio;
    private String nifTrabajador;

    public TrabajaEnVO(int codServicio, String nifTrabajador) {
        this.codServicio = codServicio;
        this.nifTrabajador = nifTrabajador;
    }

    public TrabajaEnVO() {
    }

    public int getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }

    public String getNifTrabajador() {
        return nifTrabajador;
    }

    public void setNifTrabajador(String nifTrabajador) {
        this.nifTrabajador = nifTrabajador;
    }

    @Override
    public String toString() {
        return "TrabajaEnVO{" + "codServicio=" + codServicio + ", nifTrabajador=" + nifTrabajador + '}';
    }
    
    
}
