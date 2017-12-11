package bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import negocios.UsuarioSistema;

public class ConexionUsuarioSistema {
  Connection con = Utilerias.conectar("tester", "", "ProyectoPrueba", "localhost");
  Statement stmt = null;
  static ResultSet res;
  OperacionesUsuarioSistema operaciones = null;
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

  public UsuarioSistema buscarUsuarioSistema(String nombre) {
    nombre = null;
    UsuarioSistema usuarioSistema = null;
    operaciones.buscarUsuarioSistema(nombre);
    try {
      stmt = con.createStatement();
      String query = "SELECT * FROM UsuarioSistema" + "WHERE nombre='" + nombre + "'";
      res = stmt.executeQuery(query);
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
    usuarioSistema = mostrarUsuarioSistema();
    return usuarioSistema;
  }

  public UsuarioSistema mostrarUsuarioSistema() {
    UsuarioSistema usuarioSistema = null;
    String nombre = null;
    String apellidoPaterno = null;
    String apellidoMaterno = null;
    String tipoPersonal = null;
    String noPersonal = null;
    String contraseña = null;
    String email = null;
    try {
      nombre = res.getString(nombre);
      apellidoPaterno = res.getString(apellidoPaterno);
      apellidoMaterno = res.getString(apellidoMaterno);
      tipoPersonal = res.getString(tipoPersonal);
      noPersonal = res.getString(noPersonal);
      contraseña = res.getString(contraseña);
      email = res.getString(email);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarioSistema;
  }

  @SuppressWarnings("null")
  public void registrarUsuarioSistema() {
    UsuarioSistema nuevoUsuarioSistema = null;
    operaciones.registarUsusarioSistema(nuevoUsuarioSistema);
    try {
      String agregar = "INSERT INTO Alumno VALUES (?,?,?,?,?,?,?)";
      ps = con.prepareStatement(agregar);
      ps.setString(1, nuevoUsuarioSistema.getNombre());
      ps.setString(2, nuevoUsuarioSistema.getApellidoPaterno());
      ps.setString(3, nuevoUsuarioSistema.getApellidoMaterno());
      ps.setString(4, nuevoUsuarioSistema.getTipoPersonal());
      ps.setString(5, nuevoUsuarioSistema.getNoPersonal());
      ps.setString(6, nuevoUsuarioSistema.getContraseña());
      ps.setString(7, nuevoUsuarioSistema.getEmail());
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

  public void modificarUsuarioSistema() {
    UsuarioSistema nuevoUsuarioSistema = null;
    operaciones.actualizarUsuarioSistema(nuevoUsuarioSistema);
    try {
      String modificar = "UPDATE UsuarioSistema SET nombre=?, apellidoPaterno=?, "
          + "apellidoMaterno=?,tipoPersonal=?, noPersonal=?, contraseña=?, email=? WHERE nombre=?";
      ps = con.prepareStatement(modificar);
      ps.setString(1, nuevoUsuarioSistema.getNombre());
      ps.setString(2, nuevoUsuarioSistema.getApellidoPaterno());
      ps.setString(3, nuevoUsuarioSistema.getApellidoMaterno());
      ps.setString(4, nuevoUsuarioSistema.getTipoPersonal());
      ps.setString(5, nuevoUsuarioSistema.getNoPersonal());
      ps.setString(6, nuevoUsuarioSistema.getContraseña());
      ps.setString(7, nuevoUsuarioSistema.getEmail());
      ps.setString(8, nuevoUsuarioSistema.getNombre());
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

  public void eliminarUsuarioSistema() {
    UsuarioSistema nuevoUsuarioSistema = null;
    operaciones.eliminarUsuarioSistema(nuevoUsuarioSistema);
    try {
      String eliminar = "DELETE * FROM UsuarioSistema WHERE nombre=?";
      ps = con.prepareStatement(eliminar);
      ps.setString(1, nuevoUsuarioSistema.getNombre());

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
