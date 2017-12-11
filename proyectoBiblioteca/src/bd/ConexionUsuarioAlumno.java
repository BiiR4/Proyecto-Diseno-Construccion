package bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import negocios.Alumno;

public class ConexionUsuarioAlumno {
  Connection con = Utilerias.conectar("tester", "", "ProyectoPrueba", "localhost");
  Statement stmt = null;
  static ResultSet res;
  static OperacionesUsuarioBiblioteca operaciones = null;
  PreparedStatement ps = null;

  public static void setUp() {
    // recrear BD de prueba
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

  public Alumno buscarAlumno(String nombre) {
    nombre = null;
    Alumno alumno = null;
    operaciones.buscarUsuarioBiblioteca(nombre);
    try {
      stmt = con.createStatement();
      String query = "SELECT * FROM Alumno" + "WHERE nombre='" + nombre + "'";
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
    alumno = mostrarAlumno();
    return alumno;
  }

  public Alumno mostrarAlumno() {
    Alumno alumno = null;
    String nombre = null;
    String apellidoPaterno = null;
    String apellidoMaterno = null;
    int telefono = 0;
    String email = null;
    String moroso = null;
    String matricula = null;
    String carrera = null;

    try {
      if (res.first()) {
        nombre = res.getString(nombre);
        apellidoPaterno = res.getString(apellidoPaterno);
        apellidoMaterno = res.getString(apellidoMaterno);
        telefono = res.getInt(telefono);
        email = res.getString(email);
        moroso = res.getString(moroso);
        matricula = res.getString(matricula);
        carrera = res.getString(carrera);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return alumno;
  }

  @SuppressWarnings("null")
  public void registrarAlumno() {
    Alumno alumno = null;
    operaciones.registrarUsuarioBiblioteca(alumno);
    try {
      String agregar = "INSERT INTO Alumno VALUES (?,?,?,?,?,?,?,?)";
      ps = con.prepareStatement(agregar);
      ps.setString(1, alumno.getNombre());
      ps.setString(2, alumno.getApellidoPaterno());
      ps.setString(3, alumno.getApellidoMaterno());
      ps.setInt(4, alumno.getTelefono());
      ps.setString(5, alumno.getEmail());
      ps.setBoolean(6, alumno.esMoroso());
      ps.setString(7, alumno.getMatricula());
      ps.setString(8, alumno.getCarrera());

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

  @SuppressWarnings("null")
  public void modificarAlumno() {
    Alumno alumno = null;
    operaciones.actualizarUsuarioBiblioteca(alumno);
    try {
      String modificar =
          "UPDATE Alumno SET nombre=?,apellidoPaterno=?,apellidoMaterno=?,telefono=?,email=?, morsos=?, matricula=?,carrera=? WHERE nombre=?";
      ps = con.prepareStatement(modificar);
      ps.setString(1, alumno.getNombre());
      ps.setString(2, alumno.getApellidoPaterno());
      ps.setString(3, alumno.getApellidoMaterno());
      ps.setInt(4, alumno.getTelefono());
      ps.setString(5, alumno.getEmail());
      ps.setBoolean(6, alumno.esMoroso());
      ps.setString(7, alumno.getMatricula());
      ps.setString(8, alumno.getCarrera());
      ps.setString(9, alumno.getNombre());
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

  @SuppressWarnings("null")
  public void eliminarAlumno() {
    Alumno alumno = null;
    operaciones.eliminarUsuarioBiblioteca(alumno);
    try {
      String eliminar = "DELETE * FROM Alumno WHERE nombre=?";
      ps = con.prepareStatement(eliminar);
      ps.setString(1, alumno.getNombre());
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
