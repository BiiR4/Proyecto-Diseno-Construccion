package bd.testBd;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bd.OperacionesMaterialBibliografico;
import bd.Utilerias;
import negocios.MaterialBibliografico;

public class OperacionesMaterialBibliograficoTest<MaterialBbliografico> {
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
    materialBibliograficoEncontrado = asignar();
    return materialBibliograficoEncontrado;
  }

  public static MaterialBibliografico asignar() {
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

  public void registrarMaterialBibliograficoCorecto() {
    MaterialBibliografico libro1 = new MaterialBibliografico("968-27-0070-1", "Confabulario",
        "Juan Jose Arreola", "Entretenimiento", "Comprado", "Libros del Rincon", "5A");
    MaterialBibliografico libro2 = new MaterialBibliografico("968-16-2924-8",
        "Armas y Explosiones Nucleares: La humanoidad en peligro", "Antonio Alonso",
        "Divulgacion Cientifica", "Donado", "Departamento Fisica", "10F");
    MaterialBibliografico libro3 =
        new MaterialBibliografico("968-15-1340-1", "Don Quijoste de la Mancha",
            "Miguel de Cervantes de Savedra", "Entrenimiento", "Comaprado", "Lectura", "1A");
    MaterialBibliografico libro4 =
        new MaterialBibliografico("968-15-1542-0", "El Viaje al centro de la tierra", "Julio Verne",
            "Entrenimiento", "Comprado", "Lectura", "1A");
    List<MaterialBibliografico> MaterialesBibliograficos = new ArrayList<MaterialBibliografico>();
    MaterialesBibliograficos.add(libro1);
    MaterialesBibliograficos.add(libro2);
    MaterialesBibliograficos.add(libro3);
    MaterialesBibliograficos.add(libro4);

    operaciones.registrarMaterialBibliografico(libro1);
    operaciones.registrarMaterialBibliografico(libro2);
    operaciones.registrarMaterialBibliografico(libro3);
    operaciones.registrarMaterialBibliografico(libro4);

    try {
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from MaterialBibliografico");
      int contadorRegistros = 0;
      while (rs.next()) {
        contadorRegistros++;
      }
      assertEquals(contadorRegistros, 1);
      String agregar = "INSERT INTO MaterilBibliografico VALUES (?,?,?,?,?,?,?)";
      prepararSentencias = con.prepareStatement(agregar);

      prepararSentencias.setString(1, libro1.getIdentificador());
      prepararSentencias.setString(2, libro1.getTitulo());
      prepararSentencias.setString(3, libro1.getAutor());
      prepararSentencias.setString(4, libro1.getTematicaArea());
      prepararSentencias.setString(5, libro1.getTipoAdquisicion());
      prepararSentencias.setString(6, libro1.getReferencia());
      prepararSentencias.setString(7, libro1.getUbicacion());
      prepararSentencias.executeUpdate();

      while (rs.next()) { // debe ser un solo registro
        assertEquals(1, rs.getInt("MaterialBibliografico"));
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

  public void modificarMaterialBibliografico() {
    MaterialBibliografico libro1 = new MaterialBibliografico("968-27-0070-1", "Confabulario",
        "Juan Jose Arreola", "Entretenimiento", "Comprado", "Libros del Rincon", "5A");
    MaterialBibliografico libro2 = new MaterialBibliografico("968-16-2924-8",
        "Armas y Explosiones Nucleares: La humanoidad en peligro", "Antonio Alonso",
        "Divulgacion Cientifica", "Donado", "Departamento Fisica", "10F");
    MaterialBibliografico libro3 =
        new MaterialBibliografico("968-15-1340-1", "Don Quijoste de la Mancha",
            "Miguel de Cervantes de Savedra", "Entrenimiento", "Comaprado", "Lectura", "1A");
    MaterialBibliografico libro4 =
        new MaterialBibliografico("968-15-1542-0", "El Viaje al centro de la tierra", "Julio Verne",
            "Entrenimiento", "Comprado", "Lectura", "1A");
    List<MaterialBibliografico> MaterialesBibliograficos = new ArrayList<MaterialBibliografico>();
    MaterialesBibliograficos.add(libro1);
    MaterialesBibliograficos.add(libro2);
    MaterialesBibliograficos.add(libro3);
    MaterialesBibliograficos.add(libro4);

    operaciones.registrarMaterialBibliografico(libro1);
    operaciones.registrarMaterialBibliografico(libro2);
    operaciones.registrarMaterialBibliografico(libro3);
    operaciones.registrarMaterialBibliografico(libro4);

    try {
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from MaterialBibliografico");
      int contadorRegistros = 0;
      while (rs.next()) {
        contadorRegistros++;
      }
      assertEquals(contadorRegistros, 1);
      String modificar =
          "UPDATE MaterialBibliografico SET idetificador=?,titulo=?, autor=?, tematicaArea=?, "
              + "tipoAdquiscion=?, referencia=?, ubicacion=? WHERE idendificador=?";
      prepararSentencias = con.prepareStatement(modificar);

      prepararSentencias.setString(1, libro1.getIdentificador());
      prepararSentencias.setString(2, libro1.getTitulo());
      prepararSentencias.setString(3, libro1.getAutor());
      prepararSentencias.setString(4, libro1.getTematicaArea());
      prepararSentencias.setString(5, libro1.getTipoAdquisicion());
      prepararSentencias.setString(6, libro1.getReferencia());
      prepararSentencias.setString(7, libro1.getUbicacion());
      prepararSentencias.setString(8, libro1.getIdentificador());
      prepararSentencias.executeUpdate();

      while (rs.next()) { // debe ser un solo registro
        assertEquals(1, rs.getInt("MaterialBibliografico"));
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
    MaterialBibliografico libro1 = new MaterialBibliografico("968-27-0070-1", "Confabulario",
        "Juan Jose Arreola", "Entretenimiento", "Comprado", "Libros del Rincon", "5A");
    MaterialBibliografico libro2 = new MaterialBibliografico("968-16-2924-8",
        "Armas y Explosiones Nucleares: La humanoidad en peligro", "Antonio Alonso",
        "Divulgacion Cientifica", "Donado", "Departamento Fisica", "10F");
    MaterialBibliografico libro3 =
        new MaterialBibliografico("968-15-1340-1", "Don Quijoste de la Mancha",
            "Miguel de Cervantes de Savedra", "Entrenimiento", "Comaprado", "Lectura", "1A");
    MaterialBibliografico libro4 =
        new MaterialBibliografico("968-15-1542-0", "El Viaje al centro de la tierra", "Julio Verne",
            "Entrenimiento", "Comprado", "Lectura", "1A");
    List<MaterialBibliografico> MaterialesBibliograficos = new ArrayList<MaterialBibliografico>();
    MaterialesBibliograficos.add(libro1);
    MaterialesBibliograficos.add(libro2);
    MaterialesBibliograficos.add(libro3);
    MaterialesBibliograficos.add(libro4);

    operaciones.registrarMaterialBibliografico(libro1);
    operaciones.registrarMaterialBibliografico(libro2);
    operaciones.registrarMaterialBibliografico(libro3);
    operaciones.registrarMaterialBibliografico(libro4);

    try {
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from MaterialBibliografico");
      int contadorRegistros = 0;
      while (rs.next()) {
        contadorRegistros++;
      }
      assertEquals(contadorRegistros, 1);
      String eliminar = "DELETE *FROM MaterialBibliografico WHERE identificador=?";
      prepararSentencias = con.prepareStatement(eliminar);

      prepararSentencias.setString(1, libro1.getIdentificador());


      while (rs.next()) { // debe ser un solo registro
        assertEquals(1, rs.getInt("MaterialBibliografico"));
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

