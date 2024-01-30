package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.habilidad;

public class HabilidadBuilderImpl implements HabilidadBuilder {

  private Habilidad habilidad = new Habilidad(0, "", "");

  public HabilidadBuilder idNinja(int idNinja) {
    habilidad.setIdNinja(idNinja);
    return this;
  }

  public HabilidadBuilder nombre(String nombre) {
    habilidad.setNombre(nombre);
    return this;
  }

  public HabilidadBuilder descripcion(String descripcion) {
    habilidad.setDescripcion(descripcion);
    return this;
  }

  public Habilidad build() {
    return habilidad;
  }
}