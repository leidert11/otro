
package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.habilidad;

public class Habilidad {
    private int idNinja;
    private String nombre;
    private String descripcion;

    public Habilidad(int idNinja, String nombre, String descripcion) {
        this.idNinja = idNinja;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Habilidad() {
    }
    
    public Habilidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public int getIdNinja() {
        return idNinja; 

    }

    public void setIdNinja(int idNinja) {
        this.idNinja = idNinja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habilidad{" + "idNinja=" + idNinja + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
}
