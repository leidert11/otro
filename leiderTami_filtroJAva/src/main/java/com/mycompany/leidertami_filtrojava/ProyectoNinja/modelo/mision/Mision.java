package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision;

public class Mision {
    private int id;
    private String descripcion;
    private RangoMision rango;
    private String fechaInicio;
    private String fechaFin;

    public Mision(int id, String descripcion, RangoMision rango, String fechaInicio, String fechaFin) {
        this.id = id;
        this.descripcion = descripcion;
        this.rango = rango;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Mision{" + "id=" + id + ", descripcion=" + descripcion + ", rango=" + rango + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
}
