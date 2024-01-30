package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision;

import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.Ninja;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.NinjaDAO;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.RangoNinja;

import java.util.ArrayList;
import java.util.List;

public class MisionDAO {
    private List<Mision> misiones = new ArrayList<>();
    private NinjaDAO ninjaDAO;

    public MisionDAO(NinjaDAO ninjaDAO) {
        this.ninjaDAO = ninjaDAO;
    }

    public void crearMision(Mision mision) {
        misiones.add(mision);
    }

    public List<Mision> obtenerMisionesDisponiblesParaNinja(int idNinja) {
        List<Mision> misionesDisponibles = new ArrayList<>();
        Ninja ninja = ninjaDAO.obtenerNinjaPorId(idNinja);

        if (ninja != null) {
            RangoNinja rangoNinja = ninja.getRango();

            for (Mision mision : misiones) {
                if (esRangoSuficiente(rangoNinja, mision.getRango())) {
                    misionesDisponibles.add(mision);
                }
            }
        }

        return misionesDisponibles;
    }

    private boolean esRangoSuficiente(RangoNinja rangoNinja, RangoMision rangoMision) {
        int nivelRangoNinja = obtenerNivelRango(rangoNinja);
        int nivelRangoMision = obtenerNivelRango(rangoMision);

        return nivelRangoNinja >= nivelRangoMision;
    }

    private int obtenerNivelRango(RangoNinja rango) {
        switch (rango) {
            case A:
                return 3;
            case B:
                return 2;
            case C:
                return 1;
            default:
                return 0;
        }
    }

    private int obtenerNivelRango(RangoMision rango) {
        switch (rango) {
            case A:
                return 3;
            case B:
                return 2;
            case C:
                return 1;
            default:
                return 0;
        }
    }

    public List<Mision> getMisiones() {
        return misiones;
    }
}
