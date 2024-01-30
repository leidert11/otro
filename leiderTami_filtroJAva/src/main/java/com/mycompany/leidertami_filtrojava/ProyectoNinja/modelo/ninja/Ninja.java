package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja;

public class Ninja {

    private int id;
    private String nombre;
    private RangoNinja rango;
    private String aldea;

    public Ninja(int id, String nombre, RangoNinja rango, String aldea) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
    }

    public Ninja(String nombre, RangoNinja rango, String aldea) {
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RangoNinja getRango() {
        return rango;
    }

    public void setRango(RangoNinja rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rango=" + rango +
                ", aldea='" + aldea + '\'' +
                '}';
    }
}
