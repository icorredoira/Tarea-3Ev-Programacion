/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

/**
 *
 * @author inmac
 */
public class PersonaEnlaceVO {
    private String codPersonaEnlace;
    private String tipoEmpresa;
    private String codCliente;

    public PersonaEnlaceVO(String codPersonaEnlace, String tipoEmpresa, String codCliente) {
        this.codPersonaEnlace = codPersonaEnlace;
        this.tipoEmpresa = tipoEmpresa;
        this.codCliente = codCliente;
    }

    public PersonaEnlaceVO() {
    }

    public String getCodPersonaEnlace() {
        return codPersonaEnlace;
    }

    public void setCodPersonaEnlace(String codPersonaEnlace) {
        this.codPersonaEnlace = codPersonaEnlace;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public String toString() {
        return "PersonaEnlaceVO{" + "codPersonaEnlace=" + codPersonaEnlace + ", tipoEmpresa=" + tipoEmpresa + ", codCliente=" + codCliente + '}';
    }
    
    
}
