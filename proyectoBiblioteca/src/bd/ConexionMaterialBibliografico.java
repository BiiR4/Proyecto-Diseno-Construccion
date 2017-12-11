package bd;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import negocios.MaterialBibliografico;

public class ConexionMaterialBibliografico {
  Connection con = Utilerias.conectar("tester", "", "ProyectoPrueba", "localhost");
  Statement stmt = null;
  static ResultSet res;
  static OperacionesMaterialBibliografico operaciones = null;
  java.sql.PreparedStatement prepararSentencias = null;

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

  public MaterialBibliografico buscarMaterialBibliografico(String titulo) {

    MaterialBibliografico materialBibliograficoEncontrado = null;
    try {
      stmt = con.createStatement();
      String query = "select * from MaterialBibliograrfico" + "where titulo='" + titulo + "'";
      ResultSet res = stmt.executeQuery(query);
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
    materialBibliograficoEncontrado = mostrarMaterialBibliografico();
    return materialBibliograficoEncontrado;
  }

  public static MaterialBibliografico mostrarMaterialBibliografico() {
    MaterialBibliografico materialBibliograficoEncontrado = null;
    String identificador = null;
    String titulo = null;
    String autor = null;
    String tematicaArea = null;
    String tipoAdquisicion = null;
    String referencia = null;
    String ubicacion = null;
    try {
      if (res.first()) {
        identificador = res.getString(identificador);
        titulo = res.getString(titulo);
        autor = res.getString(autor);
        tematicaArea = res.getString(tematicaArea);
        tipoAdquisicion = res.getString(tipoAdquisicion);
        referencia = res.getString(referencia);
        ubicacion = res.getString(ubicacion);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return materialBibliograficoEncontrado;
  }

  @SuppressWarnings("null")
  public void registrarMaterialBibliograficoCorecto() {
    MaterialBibliografico materialBibliografico = null;
    operaciones.registrarMaterialBibliografico(materialBibliografico);


    try {
      String agregar = "INSERT INTO MaterilBibliografico VALUES (?,?,?,?,?,?,?)";
      prepararSentencias = con.prepareStatement(agregar);

      prepararSentencias.setString(1, materialBibliografico.getIdentificador());
      prepararSentencias.setString(2, materialBibliografico.getTitulo());
      prepararSentencias.setString(3, materialBibliografico.getAutor());
      prepararSentencias.setString(4, materialBibliografico.getTematicaArea());
      prepararSentencias.setString(5, materialBibliografico.getTipoAdquisicion());
      prepararSentencias.setString(6, materialBibliografico.getReferencia());
      prepararSentencias.setString(7, materialBibliografico.getUbicacion());
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

  public void modificarMaterialBibliografico() {
    MaterialBibliografico materialBibliografico = null;
    operaciones.actualizarMaterialBibliografico(materialBibliografico);


    try {
      String modificar =
          "UPDATE MaterialBibliografico SET idetificador=?,titulo=?, autor=?, tematicaArea=?, "
              + "tipoAdquiscion=?, referencia=?, ubicacion=? WHERE idendificador=?";
      prepararSentencias = con.prepareStatement(modificar);

      prepararSentencias.setString(1, materialBibliografico.getIdentificador());
      prepararSentencias.setString(2, materialBibliografico.getTitulo());
      prepararSentencias.setString(3, materialBibliografico.getAutor());
      prepararSentencias.setString(4, materialBibliografico.getTematicaArea());
      prepararSentencias.setString(5, materialBibliografico.getTipoAdquisicion());
      prepararSentencias.setString(6, materialBibliografico.getReferencia());
      prepararSentencias.setString(7, materialBibliografico.getUbicacion());
      prepararSentencias.setString(8, materialBibliografico.getIdentificador());
      prepararSentencias.executeUpdate();

      while (res.next()) { // debe ser un solo registro
        assertEquals(1, res.getInt("MaterialBibliografico"));
      }

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

  public void eliminarMaterialBibliografico() {
    MaterialBibliografico materialBibliografico = null;
    operaciones.eliminarMaterialBibliografico(materialBibliografico);

    try {
      String eliminar = "DELETE *FROM MaterialBibliografico WHERE identificador=?";
      prepararSentencias = con.prepareStatement(eliminar);

      prepararSentencias.setString(1, materialBibliografico.getIdentificador());

      prepararSentencias.executeUpdate();

      while (res.next()) { // debe ser un solo registro
        assertEquals(1, res.getInt("MaterialBibliografico"));
      }

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

