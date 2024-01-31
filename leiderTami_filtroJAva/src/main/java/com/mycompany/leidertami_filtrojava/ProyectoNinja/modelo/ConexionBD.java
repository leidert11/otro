package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja.MisionNinja;

public class ConexionBD {

  private static final String URL = "jdbc:mysql://localhost:3306/ninja";
  private static final String USER = "root";
  private static final String PASSWORD = "";
  private static Connection conexion = null;

  public static Connection getConexion() {
    try {
      if (conexion == null) {
        conexion = DriverManager.getConnection(URL, USER, PASSWORD);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conexion;
  }

  public static void cerrarConexion(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  public static boolean marcarMisionComoCompletada(MisionNinja misionNinja) {
    try {
      Thread.sleep(5000); // tiempo de ejecucion
      Connection con = getConexion();
      String sql = "UPDATE misionninja SET fechaFin = ? WHERE idMision = ? AND idNinja = ?";
      try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setTimestamp(1, misionNinja.getFechaFin());
        ps.setInt(2, misionNinja.getIdMision());
        ps.setInt(3, misionNinja.getIdNinja());
        int filas = ps.executeUpdate();
        return filas > 0;
      } catch (SQLException e) {
        System.out.println("Error al actualizar la misión: " + e.getMessage());
        return false;
      }
    } catch (InterruptedException e) {
      System.out.println("Error en el tiempo de espera: " + e.getMessage());
      return false;
    }
  }

  public static boolean asignarMision(MisionNinja misionNinja) {
    try {
      Thread.sleep(5000); // tiempo de ejecucion
      Connection con = getConexion();
      String sql = "INSERT INTO misionninja (idNinja, idMision, fechaInicio) VALUES (?, ?, ?)";

      try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, misionNinja.getIdNinja());
        ps.setInt(2, misionNinja.getIdMision());
        ps.setTimestamp(3, misionNinja.getFechaInicio());

        int filasAfectadas = ps.executeUpdate();

        return filasAfectadas > 0;
      } catch (SQLException e) {
        System.out.println("Error al asignar la misión: " + e.getMessage());
        return false;
      }
    } catch (InterruptedException e) {
      System.out.println("Error en el tiempo de espera: " + e.getMessage());
      return false;
    }
  }

}
