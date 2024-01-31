
package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ConexionBD;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision.Mision;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision.MisionDAO;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision.RangoMision;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja.MisionNinja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NinjaDAO {
  private List<Ninja> ninjas;
  private List<MisionNinja> misionesNinja; 
    private List<Mision> misiones; 

    public NinjaDAO() {
      ninjas = new ArrayList<>();
      misiones = new ArrayList<>();
  }
  public void crearNinja(Ninja ninja) {
    Connection conexion = ConexionBD.getConexion();
    PreparedStatement ps = null;
    String sql = "INSERT INTO ninja (id, nombre, rango, aldea) VALUES (?, ?, ?, ?)";
    
    try {
      ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, ninja.getId());
      ps.setString(2, ninja.getNombre());
      ps.setString(3, String.valueOf(ninja.getRango()));
      ps.setString(4, ninja.getAldea());
      ps.executeUpdate();
      
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idGenerado = rs.getInt(1);
            ninja.setId(idGenerado);
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
  
  
  
  
  public List<Ninja> listarNinjas() {
    Connection conexion = ConexionBD.getConexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Ninja> ninjas = new ArrayList<>();
    String sql = "SELECT id, nombre, rango, aldea FROM ninja";
    try {
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            NinjaBuilder builder = new NinjaBuilderImpl()
                    .id(rs.getInt("id"))
                    .nombre(rs.getString("nombre"))
                    .rango(RangoNinja.valueOf(rs.getString("rango")))
                    .aldea(rs.getString("aldea"));
            Ninja ninja = builder.build();
            ninjas.add(ninja);
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
    return ninjas;
}

  
    public void actualizarNinja (Ninja ninja) {
      Connection conexion = ConexionBD.getConexion ();
      PreparedStatement ps = null;
      String sql = "UPDATE ninja SET nombre = ?, rango = ?, aldea = ? WHERE id = ?";
      try {
        ps = conexion.prepareStatement (sql);
        ps.setInt (1, ninja.getId ());
        ps.setString (2, ninja.getNombre ());
        ps.setObject (3, ninja.getRango ());
        ps.setString (4, ninja.getAldea ());
        ps.executeUpdate ();
      } catch (SQLException e) {
        e.printStackTrace ();
      } finally {
        try {
          if (ps != null) {
            ps.close ();
          }
        } catch (SQLException e) {
          e.printStackTrace ();
        }
      }
    }
  
    public void borrarNinja (int id) {
      Connection conexion = ConexionBD.getConexion ();
      PreparedStatement ps = null;
      String sql = "DELETE FROM ninja WHERE id = ?";
      try {
        ps = conexion.prepareStatement (sql);
        ps.setInt (1, id);
        ps.executeUpdate ();
      } catch (SQLException e) {
        e.printStackTrace ();
      } finally {
        try {
          if (ps != null) {
            ps.close ();
          }
        } catch (SQLException e) {
          e.printStackTrace ();
        }
      }
    }

    public Ninja obtenerNinjaPorId(int id) {
      Ninja ninja = null;
      Connection conexion = ConexionBD.getConexion();
      PreparedStatement ps = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM ninja WHERE id = ?";
  
      try {
          ps = conexion.prepareStatement(sql);
          ps.setInt(1, id);
          rs = ps.executeQuery();
  
          if (rs.next()) {
              String nombre = rs.getString("nombre");
              RangoNinja rango = RangoNinja.valueOf(rs.getString("rango").toUpperCase());
              String aldea = rs.getString("aldea");
              ninja = new Ninja(id, nombre, rango, aldea);
          }
      } catch (SQLException | IllegalArgumentException e) {
          e.printStackTrace();
      } finally {
          ConexionBD.cerrarConexion(conexion, ps, rs);
      }
  
      return ninja;
  }
  
  }
  
