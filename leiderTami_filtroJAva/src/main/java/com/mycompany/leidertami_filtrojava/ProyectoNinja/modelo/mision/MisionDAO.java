package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision;

import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ConexionBD;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.Ninja;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.NinjaDAO;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.RangoNinja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public MisionDAO() {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM mision";

        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                RangoMision rango = RangoMision.valueOf(rs.getString("rango"));
                Mision mision = new Mision(id, descripcion, rango);
                misiones.add(mision);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Mision> obtenerMisionesDisponiblesParaNinja(String rangoNinja) {
        List<Mision> misionesDisponibles = new ArrayList<>();
        for (Mision mision : misiones) {
            System.out.println("El resultado de as misiones es: " + esRangoIgual(rangoNinja, mision.getRango().name())); // mostrar el valor del método
            if (esRangoIgual(rangoNinja, mision.getRango().name())) {
                misionesDisponibles.add(mision);
            }
        }
        return misionesDisponibles;
    }
    
    

    private boolean esRangoIgual(String rangoNinja, String rangoMision) { 
        return rangoNinja.equals(rangoMision); 
    }
    
    public List<Mision> getMisiones() {
        return misiones;
    }
}