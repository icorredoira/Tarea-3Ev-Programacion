/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

/**
 *
 * @author inmac
 */
public class ResultadoVO {
    private int codAnalisis;
    private double altura;
    private double anguloInclinacion;
    private String forma;
    private double anguloFrincionInterna;
    private String tiposRoturas;
    private String efectoAntropogenico;
    private double permeabilidad;
    private double factorSeguridad;
    private String significadoFactorSeguridad;
    private double indiceCompresionUnaria;
    private double resistenciaCorte;
    private double porcentajeSaturacion;

    public ResultadoVO(int codAnalisis, double altura, double anguloInclinacion, String forma, double anguloFrincionInterna, String tiposRoturas, String efectoAntropogenico, double permeabilidad, double factorSeguridad, String significadoFactorSeguridad, double indiceCompresionUnaria, double resistenciaCorte, double porcentajeSaturacion) {
        this.codAnalisis = codAnalisis;
        this.altura = altura;
        this.anguloInclinacion = anguloInclinacion;
        this.forma = forma;
        this.anguloFrincionInterna = anguloFrincionInterna;
        this.tiposRoturas = tiposRoturas;
        this.efectoAntropogenico = efectoAntropogenico;
        this.permeabilidad = permeabilidad;
        this.factorSeguridad = factorSeguridad;
        this.significadoFactorSeguridad = significadoFactorSeguridad;
        this.indiceCompresionUnaria = indiceCompresionUnaria;
        this.resistenciaCorte = resistenciaCorte;
        this.porcentajeSaturacion = porcentajeSaturacion;
    }

    public ResultadoVO() {
    }

    public int getCodAnalisis() {
        return codAnalisis;
    }

    public void setCodAnalisis(int codAnalisis) {
        this.codAnalisis = codAnalisis;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAnguloInclinacion() {
        return anguloInclinacion;
    }

    public void setAnguloInclinacion(double anguloInclinacion) {
        this.anguloInclinacion = anguloInclinacion;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public double getAnguloFrincionInterna() {
        return anguloFrincionInterna;
    }

    public void setAnguloFrincionInterna(double anguloFrincionInterna) {
        this.anguloFrincionInterna = anguloFrincionInterna;
    }

    public String getTiposRoturas() {
        return tiposRoturas;
    }

    public void setTiposRoturas(String tiposRoturas) {
        this.tiposRoturas = tiposRoturas;
    }

    public String getEfectoAntropogenico() {
        return efectoAntropogenico;
    }

    public void setEfectoAntropogenico(String efectoAntropogenico) {
        this.efectoAntropogenico = efectoAntropogenico;
    }

    public double getPermeabilidad() {
        return permeabilidad;
    }

    public void setPermeabilidad(double permeabilidad) {
        this.permeabilidad = permeabilidad;
    }

    public double getFactorSeguridad() {
        return factorSeguridad;
    }

    public void setFactorSeguridad(double factorSeguridad) {
        this.factorSeguridad = factorSeguridad;
    }

    public String getSignificadoFactorSeguridad() {
        return significadoFactorSeguridad;
    }

    public void setSignificadoFactorSeguridad(String significadoFactorSeguridad) {
        this.significadoFactorSeguridad = significadoFactorSeguridad;
    }

    public double getIndiceCompresionUnaria() {
        return indiceCompresionUnaria;
    }

    public void setIndiceCompresionUnaria(double indiceCompresionUnaria) {
        this.indiceCompresionUnaria = indiceCompresionUnaria;
    }

    public double getResistenciaCorte() {
        return resistenciaCorte;
    }

    public void setResistenciaCorte(double resistenciaCorte) {
        this.resistenciaCorte = resistenciaCorte;
    }

    public double getPorcentajeSaturacion() {
        return porcentajeSaturacion;
    }

    public void setPorcentajeSaturacion(double porcentajeSaturacion) {
        this.porcentajeSaturacion = porcentajeSaturacion;
    }

    @Override
    public String toString() {
        return "ResultadoVO{" + "codAnalisis=" + codAnalisis + ", altura=" + altura + ", anguloInclinacion=" + anguloInclinacion + ", forma=" + forma + ", anguloFrincionInterna=" + anguloFrincionInterna + ", tiposRoturas=" + tiposRoturas + ", efectoAntropogenico=" + efectoAntropogenico + ", permeabilidad=" + permeabilidad + ", factorSeguridad=" + factorSeguridad + ", significadoFactorSeguridad=" + significadoFactorSeguridad + ", indiceCompresionUnaria=" + indiceCompresionUnaria + ", resistenciaCorte=" + resistenciaCorte + ", porcentajeSaturacion=" + porcentajeSaturacion + '}';
    }
    
    
}
