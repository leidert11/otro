package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.habilidad;

import java.sql.Statement;
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
        // Quitar el campo idNinja de la sentencia SQL
        String sql = "INSERT INTO habilidad (nombre, descripcion) VALUES (?, ?)";
        try {
            // Usar la clase Statement y su constante RETURN_GENERATED_KEYS
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Quitar el parámetro idNinja del PreparedStatement
            ps.setString(1, habilidad.getNombre());
            ps.setString(2, habilidad.getDescripcion());
            ps.executeUpdate();
            // Obtener el id autogenerado del ResultSet
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                // Cambiar el nombre del método a setIdNinja
                habilidad.setIdNinja(idGenerado);
            }
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
