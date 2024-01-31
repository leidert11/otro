package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision;

public class Mision {
    private int id;
    private String descripcion;
    private RangoMision rango;



    public Mision(int id, String descripcion, RangoMision rango) {
        this.id = id;
        this.descripcion = descripcion;
        this.rango = rango;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public RangoMision getRango() {
        return rango;
    }

    public void setRango(RangoMision rango) {
        this.rango = rango;
    }



    @Override
    public String toString() {
        return "Mision{" + "id=" + id + ", descripcion=" + descripcion + ", rango=" + rango + '}';
    }
}
