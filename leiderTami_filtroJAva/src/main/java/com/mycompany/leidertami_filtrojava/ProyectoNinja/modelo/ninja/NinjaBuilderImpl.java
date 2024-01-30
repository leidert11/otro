package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja;

public class NinjaBuilderImpl implements NinjaBuilder {
    private int id;
    private String nombre;
    private RangoNinja rango;
    private String aldea;

    public NinjaBuilderImpl() {
    }

    @Override
    public NinjaBuilder id(int id) {
        this.id = id;
        return this;
    }

    @Override
    public NinjaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @Override
    public NinjaBuilder rango(RangoNinja rango) {
        this.rango = rango;
        return this;
    }

    @Override
    public NinjaBuilder aldea(String aldea) {
        this.aldea = aldea;
        return this;
    }

    @Override
    public Ninja build() {
        return new Ninja(id, nombre, rango, aldea);
    }
}
