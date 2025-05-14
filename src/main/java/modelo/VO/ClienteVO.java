/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.VO;

/**
 *
 * @author inmac
 */
public class ClienteVO {
    private String codCliente;
    private String NIF;
    private String telefono;
    private String razonSocial;
    private String calle;
    private String numero;
    private String localidad;
    private long codigoPostal;

    public ClienteVO(String codCliente, String NIF, String telefono, String razonSocial, String calle, String numero, String localidad, long codigoPostal) {
        this.codCliente = codCliente;
        this.NIF = NIF;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }

    public ClienteVO() {
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public long getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(long codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "ClienteVO{" + "codCliente=" + codCliente + ", NIF=" + NIF + ", telefono=" + telefono + ", razonSocial=" + razonSocial + ", calle=" + calle + ", numero=" + numero + ", localidad=" + localidad + ", codigoPostal=" + codigoPostal + '}';
    }
    
    
}
