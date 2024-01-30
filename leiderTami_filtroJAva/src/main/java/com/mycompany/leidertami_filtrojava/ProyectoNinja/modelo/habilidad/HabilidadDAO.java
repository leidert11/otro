package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.habilidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ConexionBD;
public class HabilidadDAO {
     public void crearHabilidad(Habilidad habilidad) {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        String sql = "INSERT INTO habilidad (idNinja, nombre, descripcion) VALUES (?, ?, ?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, habilidad.getIdNinja());
            ps.setString(2, habilidad.getNombre());
            ps.setString(3, habilidad.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Habilidad> listarHabilidades() {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Habilidad> habilidades = new ArrayList<>();
        String sql = "SELECT idNinja, nombre, descripcion FROM habilidad";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idNinja = rs.getInt("idNinja");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Habilidad habilidad = new Habilidad(idNinja, nombre, descripcion);
                habilidades.add(habilidad);
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
        return habilidades;
    }
}
