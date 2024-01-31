package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision;

public class MisionBuilderImpl implements MisionBuilder {
    private Mision mision = new Mision(0, "", RangoMision.A);

    public MisionBuilder id(int id) {
        mision.setId(id);
        return this;
    }

    public MisionBuilder descripcion(String descripcion) {
        mision.setDescripcion(descripcion);
        return this;
    }

    public MisionBuilder rango(RangoMision rango) {
        mision.setRango(rango);
        return this;
    }


    public Mision build() {
        return mision;
    }
}
