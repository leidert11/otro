package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja;

import java.sql.Timestamp;

public class MisionNinjaBuilderImpl implements MisionNinjaBuilder {

    private MisionNinja misionNinja = new MisionNinja(0, 0, null, null);

    @Override
    public MisionNinjaBuilder idNinja(int idNinja) {
        misionNinja.setIdNinja(idNinja);
        return this;
    }

    @Override
    public MisionNinjaBuilder idMision(int idMision) {
        misionNinja.setIdMision(idMision);
        return this;
    }

    @Override
    public MisionNinjaBuilder fechaInicio(Timestamp fechaInicio) {
        misionNinja.setFechaInicio(fechaInicio);
        return this;
    }

    @Override
    public MisionNinjaBuilder fechaFin(Timestamp fechaFin) {
        misionNinja.setFechaFin(fechaFin);
        return this;
    }

    @Override
    public MisionNinja build() {
        return misionNinja;
    }
}
