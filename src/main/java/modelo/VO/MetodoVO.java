/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;
import java.time.LocalDate;
/**
 *
 * @author inmac
 */
public class MetodoVO {
    private String nombreMetodo;
    private int vidaUtil;
    private LocalDate fechaRevision;
    private String proveedor;
    private double coste;
    private String materialUtilizado;
    private int codServicioMetodo;

    public MetodoVO(String nombreMetodo, int vidaUtil, LocalDate fechaRevision, String proveedor, double coste, String materialUtilizado, int codServicioMetodo) {
        this.nombreMetodo = nombreMetodo;
        this.vidaUtil = vidaUtil;
        this.fechaRevision = fechaRevision;
        this.proveedor = proveedor;
        this.coste = coste;
        this.materialUtilizado = materialUtilizado;
        this.codServicioMetodo = codServicioMetodo;
    }

    public MetodoVO() {
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public String getMaterialUtilizado() {
        return materialUtilizado;
    }

    public void setMaterialUtilizado(String materialUtilizado) {
        this.materialUtilizado = materialUtilizado;
    }

    public int getCodServicioMetodo() {
        return codServicioMetodo;
    }

    public void setCodServicioMetodo(int codServicioMetodo) {
        this.codServicioMetodo = codServicioMetodo;
    }

    @Override
    public String toString() {
        return "MetodoVO{" + "nombreMetodo=" + nombreMetodo + ", vidaUtil=" + vidaUtil + ", fechaRevision=" + fechaRevision + ", proveedor=" + proveedor + ", coste=" + coste + ", materialUtilizado=" + materialUtilizado + ", codServicioMetodo=" + codServicioMetodo + '}';
    }
    
    
    
}
