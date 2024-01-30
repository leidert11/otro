
package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja;

public class MisionNinjaBuilberImpl implements MisionNinjaBuilder {

  private MisionNinja misionNinja = new MisionNinja(0, 0, "", "");

  public MisionNinjaBuilder idNinja(int idNinja) {
    misionNinja.setIdNinja(idNinja);
    return this;
  }

  public MisionNinjaBuilder idMision(int idMision) {
    misionNinja.setIdMision(idMision);
    return this;
  }

  public MisionNinjaBuilder fechaInicio(String fechaInicio) {
    misionNinja.setFechaInicio(fechaInicio);
    return this;
  }

  public MisionNinjaBuilder fechaFin(String fechaFin) {
    misionNinja.setFechaFin(fechaFin);
    return this;
  }

  public MisionNinja build() {
    return misionNinja;
  }
}
