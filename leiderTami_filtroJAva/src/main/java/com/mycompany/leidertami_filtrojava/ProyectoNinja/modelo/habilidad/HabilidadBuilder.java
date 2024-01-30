
package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.habilidad;

public interface HabilidadBuilder {
  HabilidadBuilder idNinja(int idNinja);
  HabilidadBuilder nombre(String nombre);
  HabilidadBuilder descripcion(String descripcion);
  Habilidad build();
}