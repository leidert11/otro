
package com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

  private static final String URL = "jdbc:mysql://localhost:3306/ninja";
  private static final String USER = "root";
  private static final String PASSWORD = "campus2024";
  private static Connection conexion = null;

  public static Connection getConexion () {
    try {
      if (conexion == null) {
        conexion = DriverManager.getConnection (URL, USER, PASSWORD);
      }
    } catch (SQLException e) {
      e.printStackTrace ();
    }
    return conexion;
  }

  public static void cerrarConexion () {
    try {
      if (conexion != null) {
        conexion.close ();
      }
    } catch (SQLException e) {
      e.printStackTrace ();
    }
  }
}
