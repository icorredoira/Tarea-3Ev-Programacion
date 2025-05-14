/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

/**
 *
 * @author inmac
 */
public class ServicioVO {
    private int codServicio;
    private String codLider;

    public ServicioVO(int codServicio, String codLider) {
        this.codServicio = codServicio;
        this.codLider = codLider;
    }

    public ServicioVO() {
    }

    public int getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }

    public String getCodLider() {
        return codLider;
    }

    public void setCodLider(String codLider) {
        this.codLider = codLider;
    }

    @Override
    public String toString() {
        return "ServicioVO{" + "codServicio=" + codServicio + ", codLider=" + codLider + '}';
    }
    
    
}
