/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

import java.time.LocalDate;
import modelo.enumeraciones.Discontinuidades;

/**
 *
 * @author inmac
 */
public class PropuestaInicialVO {
    private int codPropuestaInicial;
    private double coste;
    private String coordenadas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double margenContingencia;
    private String certificacionesLicencias;
    private boolean hayInvestigacion;
    private double porcentajeSaturacion;
    private int tiempoGarantia;
    private String tipoRoca;
    private String zonaTectonica;
    private String zonasSingulares;
    private Discontinuidades discontinuidades;

    public PropuestaInicialVO(int codPropuestaInicial, double coste, String coordenadas, LocalDate fechaInicio, LocalDate fechaFin, double margenContingencia, String certificacionesLicencias, boolean hayInvestigacion, double porcentajeSaturacion, int tiempoGarantia, String tipoRoca, String zonaTectonica, String zonasSingulares, Discontinuidades discontinuidades) {
        this.codPropuestaInicial = codPropuestaInicial;
        this.coste = coste;
        this.coordenadas = coordenadas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.margenContingencia = margenContingencia;
        this.certificacionesLicencias = certificacionesLicencias;
        this.hayInvestigacion = hayInvestigacion;
        this.porcentajeSaturacion = porcentajeSaturacion;
        this.tiempoGarantia = tiempoGarantia;
        this.tipoRoca = tipoRoca;
        this.zonaTectonica = zonaTectonica;
        this.zonasSingulares = zonasSingulares;
        this.discontinuidades = discontinuidades;
    }

    public PropuestaInicialVO() {
    }

    public int getCodPropuestaInicial() {
        return codPropuestaInicial;
    }

    public void setCodPropuestaInicial(int codPropuestaInicial) {
        this.codPropuestaInicial = codPropuestaInicial;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMargenContingencia() {
        return margenContingencia;
    }

    public void setMargenContingencia(double margenContingencia) {
        this.margenContingencia = margenContingencia;
    }

    public String getCertificacionesLicencias() {
        return certificacionesLicencias;
    }

    public void setCertificacionesLicencias(String certificacionesLicencias) {
        this.certificacionesLicencias = certificacionesLicencias;
    }

    public boolean isHayInvestigacion() {
        return hayInvestigacion;
    }

    public void setHayInvestigacion(boolean hayInvestigacion) {
        this.hayInvestigacion = hayInvestigacion;
    }

    public double getPorcentajeSaturacion() {
        return porcentajeSaturacion;
    }

    public void setPorcentajeSaturacion(double porcentajeSaturacion) {
        this.porcentajeSaturacion = porcentajeSaturacion;
    }

    public int getTiempoGarantia() {
        return tiempoGarantia;
    }

    public void setTiempoGarantia(int tiempoGarantia) {
        this.tiempoGarantia = tiempoGarantia;
    }

    public String getTipoRoca() {
        return tipoRoca;
    }

    public void setTipoRoca(String tipoRoca) {
        this.tipoRoca = tipoRoca;
    }

    public String getZonaTectonica() {
        return zonaTectonica;
    }

    public void setZonaTectonica(String zonaTectonica) {
        this.zonaTectonica = zonaTectonica;
    }

    public String getZonasSingulares() {
        return zonasSingulares;
    }

    public void setZonasSingulares(String zonasSingulares) {
        this.zonasSingulares = zonasSingulares;
    }

    public Discontinuidades getDiscontinuidades() {
        return discontinuidades;
    }

    public void setDiscontinuidades(Discontinuidades discontinuidades) {
        this.discontinuidades = discontinuidades;
    }

    @Override
    public String toString() {
        return "PropuestaInicialVO{" + "codPropuestaInicial=" + codPropuestaInicial + ", coste=" + coste + ", coordenadas=" + coordenadas + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", margenContingencia=" + margenContingencia + ", certificacionesLicencias=" + certificacionesLicencias + ", hayInvestigacion=" + hayInvestigacion + ", porcentajeSaturacion=" + porcentajeSaturacion + ", tiempoGarantia=" + tiempoGarantia + ", tipoRoca=" + tipoRoca + ", zonaTectonica=" + zonaTectonica + ", zonasSingulares=" + zonasSingulares + ", discontinuidades=" + discontinuidades + '}';
    }
    
    
    
}
