package bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import negocios.Prestamo;

public class ConexionPrestamo {
  Connection con = Utilerias.conectar("tester", "", "ProyectoPrueba", "localhost");
  Statement stmt = null;
  static ResultSet res;
  OperacionesPrestamo operaciones = null;
  PreparedStatement ps = null;

  public static void setUp() {
    Process p;
    try {
      p = Runtime.getRuntime().exec("sh restaurarBD");
      p.waitFor();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void registrarPrestamo() {
    Prestamo prestamoResultante = null;
    operaciones.registrarPrestamo(prestamoResultante);
    try {
      String agregar = "INSERT INTO Prestamo VALUES (?,?,?,?,?,?,?)";
      ps = con.prepareStatement(agregar);
      ps.setInt(1, prestamoResultante.getIdPrestamo());
      ps.setDate(2, prestamoResultante.getFecha());
      ps.setDate(3, prestamoResultante.getFechaPrestamo());
      ps.setDate(4, prestamoResultante.getFechaDevolucion());
      ps.setFloat(5, prestamoResultante.getDeuda());
      ps.setString(6, prestamoResultante.getMaterialBibliografico());
      ps.setString(7, prestamoResultante.getUsuariosSistema());
      ps.setString(8, prestamoResultante.getUsuariosBiblioteca());
      ps.se
      ps.executeUpdate();
    } catch (SQLException e) {
      if (con != null) {
        try {
          con.rollback();
        } catch (SQLException e1) {

          e1.printStackTrace();
        }
      }
      e.printStackTrace();
    }
  }



}
