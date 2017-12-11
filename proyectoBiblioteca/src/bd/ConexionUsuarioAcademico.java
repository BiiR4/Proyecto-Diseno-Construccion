package bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import negocios.Academico;

public class ConexionUsuarioAcademico {
  Connection con = Utilerias.conectar("tester", "", "ProyectoPrueba", "localhost");
  Statement stmt = null;
  static ResultSet res;
  static OperacionesUsuarioBiblioteca operaciones = null;
  PreparedStatement prepararSentencias = null;

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

  public Academico buscarAcademico(String nombre) {
    Academico academicoEncontrado = null;
    nombre = null;
    operaciones.buscarUsuarioBiblioteca(nombre);
    try {
      stmt = con.createStatement();
      String query = "SELECT * FROM Academico" + "WHERE nombre='" + nombre + "'";
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
    academicoEncontrado = mostrarAcademico();
    return academicoEncontrado;
  }

  public Academico mostrarAcademico() {
    Academico nuevoAcademicoEncontrado = null;
    String nombre = null;
    String apellidoPaterno = null;
    String apellidoMaterno = null;
    int telefono = 0;
    String email = null;
    // boolean moroso = false;
    String noPersonal = null;
    String programaAdscripcion = null;
    String tipoAcademico = null;
    try {
      if (res.first()) {
        nombre = res.getString(nombre);
        apellidoPaterno = res.getString(apellidoPaterno);
        apellidoMaterno = res.getString(apellidoMaterno);
        telefono = res.getInt(telefono);
        email = res.getString(email);
        // moroso = res.getBoolean(moroso);
        noPersonal = res.getString(noPersonal);
        programaAdscripcion = res.getString(programaAdscripcion);
        tipoAcademico = res.getString(tipoAcademico);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nuevoAcademicoEncontrado;
  }

  @SuppressWarnings("null")
  public void agregarAcademico() {
    Academico nuevoAcademico = null;
    operaciones.registrarUsuarioBiblioteca(nuevoAcademico);

    try {
      String agregar = "INSERT INTO Academico VALUES (?,?,?,?,?,?,?,?,?)";
      prepararSentencias = con.prepareStatement(agregar);
      prepararSentencias.setString(1, nuevoAcademico.getNombre());
      prepararSentencias.setString(2, nuevoAcademico.getApellidoPaterno());
      prepararSentencias.setString(3, nuevoAcademico.getApellidoMaterno());
      prepararSentencias.setInt(4, nuevoAcademico.getTelefono());
      prepararSentencias.setString(5, nuevoAcademico.getEmail());
      prepararSentencias.setBoolean(6, nuevoAcademico.esMoroso());
      prepararSentencias.setString(7, nuevoAcademico.getNoPersonal());
      prepararSentencias.setString(8, nuevoAcademico.getProgramaAdscripcion());
      prepararSentencias.setString(9, nuevoAcademico.getTipoAcademico());
      prepararSentencias.executeUpdate();
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


  public void modificarAcademico() {
    Academico nuevoAcademico = null;
    operaciones.registrarUsuarioBiblioteca(nuevoAcademico);

    try {
      String modificar =
          "UPDATE Academico SET nombre=?, apellidoPaterno=?, apellidoMaterno=?, telefono=?, email=?, moroso=?,"
              + " noPersonal=?, programaAdscripcion=?, tipoAcademico=? WHERE nombre=?";
      prepararSentencias = con.prepareStatement(modificar);

      prepararSentencias.setString(1, nuevoAcademico.getNombre());
      prepararSentencias.setString(2, nuevoAcademico.getApellidoPaterno());
      prepararSentencias.setString(3, nuevoAcademico.getApellidoMaterno());
      prepararSentencias.setInt(4, nuevoAcademico.getTelefono());
      prepararSentencias.setString(5, nuevoAcademico.getEmail());
      prepararSentencias.setBoolean(6, nuevoAcademico.esMoroso());
      prepararSentencias.setString(7, nuevoAcademico.getNoPersonal());
      prepararSentencias.setString(8, nuevoAcademico.getProgramaAdscripcion());
      prepararSentencias.setString(9, nuevoAcademico.getTipoAcademico());
      prepararSentencias.setString(10, nuevoAcademico.getNombre());
      prepararSentencias.executeUpdate();
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
  public void eliminarAcademico() {
    Academico nuevoAcademico = null;
    operaciones.registrarUsuarioBiblioteca(nuevoAcademico);

    try {
      String eliminar = "DELETE * FROM Academico WHERE nombre=?";
      prepararSentencias = con.prepareStatement(eliminar);

      prepararSentencias.setString(1, nuevoAcademico.getNombre());

      prepararSentencias.executeUpdate();
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
