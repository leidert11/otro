package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja;

import java.sql.Timestamp;

public class MisionNinja {
    private int idNinja;
    private int idMision;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;

    public MisionNinja(int idNinja, int idMision, Timestamp fechaInicio, Timestamp fechaFin) {
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

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "MisionNinja{" + "idNinja=" + idNinja + ", idMision=" + idMision +
                ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
}
