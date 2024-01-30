
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
      String sql = "INSERT INTO ninja (nombre, rango, aldea) VALUES (?, ?, ?)";
      
      try {
        ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, ninja.getNombre());
        ps.setString(2, String.valueOf(ninja.getRango()));
        ps.setString(3, ninja.getAldea());
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
      String sql = "SELECT * FROM ninja WHERE id = ?";
  
      try (Connection conexion = ConexionBD.getConexion();
           PreparedStatement statement = conexion.prepareStatement(sql)) {
          statement.setInt(1, id);
  
          try (ResultSet resultSet = statement.executeQuery()) {
              if (resultSet.next()) {
                  int idNinja = resultSet.getInt("id");
                  String nombre = resultSet.getString("nombre");
                  RangoNinja rango = RangoNinja.valueOf(resultSet.getString("rango"));
                  String aldea = resultSet.getString("aldea");
  
                  ninja = new Ninja(idNinja, nombre, rango, aldea);
              }
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
  
      return ninja;
  }
  
  public List<Mision> obtenerMisionesDisponiblesParaNinja(int idNinja) {
    List<Mision> misionesDisponibles = new ArrayList<>();
    Ninja ninja = obtenerNinjaPorId(idNinja);

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

  }
  
