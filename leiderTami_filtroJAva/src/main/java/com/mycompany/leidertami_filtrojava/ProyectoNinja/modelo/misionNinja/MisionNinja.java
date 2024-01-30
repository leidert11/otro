
package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja;


public class MisionNinja {
    private int idNinja;
    private int idMision;
    private String fechaInicio;
    private String fechaFin;

    public MisionNinja(int idNinja, int idMision, String fechaInicio, String fechaFin) {
        this.idNinja = idNinja;
        this.idMision = idMision;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdNinja() {
        return idNinja;
    }

    public void setIdNinja(int idNinja) {
        this.idNinja = idNinja;
    }

    public int getIdMision() {
        return idMision;
    }

    public void setIdMision(int idMision) {
        this.idMision = idMision;
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
        return "MisionNinja{" + "idNinja=" + idNinja + ", idMision=" + idMision + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
    
}
