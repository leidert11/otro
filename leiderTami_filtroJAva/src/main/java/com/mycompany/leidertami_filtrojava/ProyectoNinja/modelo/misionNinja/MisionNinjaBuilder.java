package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja;

import java.sql.Timestamp;

public interface MisionNinjaBuilder {
    MisionNinjaBuilder idNinja(int idNinja);
    MisionNinjaBuilder idMision(int idMision);
    MisionNinjaBuilder fechaInicio(Timestamp fechaInicio);
    MisionNinjaBuilder fechaFin(Timestamp fechaFin);
    MisionNinja build();
}
