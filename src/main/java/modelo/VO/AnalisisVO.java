/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

/**
 *
 * @author inmac
 */
public class AnalisisVO {
    private int codAnalisis;
    private int codServicio;

    public AnalisisVO(int codAnalisis, int codServicio) {
        this.codAnalisis = codAnalisis;
        this.codServicio = codServicio;
    }

    public AnalisisVO() {
    }

    public int getCodAnalisis() {
        return codAnalisis;
    }

    public void setCodAnalisis(int codAnalisis) {
        this.codAnalisis = codAnalisis;
    }

    public int getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }

    @Override
    public String toString() {
        return "AnalisisVO{" + "codAnalisis=" + codAnalisis + ", codServicio=" + codServicio + '}';
    }
    
    
}
