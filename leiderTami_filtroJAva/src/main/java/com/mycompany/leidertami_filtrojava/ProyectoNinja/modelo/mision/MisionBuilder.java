package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision;

public interface MisionBuilder {
  MisionBuilder id(int id);
  MisionBuilder descripcion(String descripcion);
  MisionBuilder rango(RangoMision rango);
  MisionBuilder fechaInicio(String fechaInicio);
  MisionBuilder fechaFin(String fechaFin);
  Mision build();
}
