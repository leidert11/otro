package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja;

import java.util.List;

public class MisionNinjaDao {
    private List<MisionNinja> misionesNinja;

    public List<MisionNinja> obtenerMisionesDisponiblesParaNinja(int idNinja) {
        return misionesNinja.stream()
                .filter(mn -> mn.getIdNinja() == idNinja)
                .toList();
    }
    
}
