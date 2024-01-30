package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja;

public interface MisionNinjaBuilder {
  MisionNinjaBuilder idNinja(int idNinja);
  MisionNinjaBuilder idMision(int idMision);
  MisionNinjaBuilder fechaInicio(String fechaInicio);
  MisionNinjaBuilder fechaFin(String fechaFin);
  MisionNinja build();
}