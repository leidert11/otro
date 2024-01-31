package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision;

public interface MisionBuilder {
  MisionBuilder id(int id);
  MisionBuilder descripcion(String descripcion);
  MisionBuilder rango(RangoMision rango);
  Mision build();
}
