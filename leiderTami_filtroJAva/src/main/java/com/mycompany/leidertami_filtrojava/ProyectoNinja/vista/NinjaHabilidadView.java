package com.mycompany.leidertami_filtrojava.ProyectoNinja.vista;

import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.habilidad.Habilidad;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision.Mision;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision.MisionDAO;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.Ninja;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.NinjaDAO;

import java.util.List;

public class NinjaHabilidadView {
    private MisionDAO misionDAO;
    private NinjaDAO ninjaDAO;

    public NinjaHabilidadView(MisionDAO misionDAO, NinjaDAO ninjaDAO) {
        this.misionDAO = misionDAO;
        this.ninjaDAO = ninjaDAO;
    }

    public void listarNinjasConHabilidades(List<Ninja> ninjas, List<Habilidad> habilidades) {
        ninjas.forEach(ninja -> {
            System.out.println("Ninja: " + ninja.getNombre());
            System.out.println("Habilidades:");
            habilidades.stream()
                    .filter(habilidad -> habilidad.getIdNinja() == ninja.getId())
                    .forEach(habilidad -> System.out.println("  - " + habilidad.getNombre()));
        });
    }

    public void mostrarMisionesDisponiblesParaNinja(int idNinja) {
        List<Mision> misionesDisponibles = misionDAO.obtenerMisionesDisponiblesParaNinja(idNinja);

        if (!misionesDisponibles.isEmpty()) {
            System.out.println("Misiones disponibles para el ninja:");
            for (Mision mision : misionesDisponibles) {
                System.out.println("- ID Mision: " + mision.getId() +
                        ", Descripción: " + mision.getDescripcion() +
                        ", Fecha Inicio: " + mision.getFechaInicio() +
                        ", Fecha Fin: " + mision.getFechaFin() +
                        ", Rango: " + mision.getRango());
            }
        } else {
            System.out.println("El ninja no tiene misiones disponibles en este momento.");
        }
    }
}
