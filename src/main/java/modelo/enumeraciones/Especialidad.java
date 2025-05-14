/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo.enumeraciones;

/**
 *
 * @author inmac
 */
public enum Especialidad {
    AnalistaCampo("Analista de campo"),
    TecnicoLaboratorio("Técnico de laboratorio"),
    EspecialistaEstructuras("Especialista en estructuras"),
    Otro("Otro");

    private final String descripcion;

    Especialidad(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}

