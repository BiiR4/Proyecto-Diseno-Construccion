package negocios;

import bd.OperacionesMaterialBibliografico;

public class MaterialBibliografico {
  private String identificador;
  private String titulo;
  private String autor;
  private String tematicaArea;
  private String tipoAdquisicion;
  private String referencia;
  private String ubicacion;

  public static OperacionesMaterialBibliografico operacionesBD;

  public MaterialBibliografico(String identificador, String titulo, String autor,
      String tematicaArea, String tipoAdquisicion, String referencia, String ubicacion) {
    super();
    this.identificador = identificador;
    this.titulo = titulo;
    this.autor = autor;
    this.tematicaArea = tematicaArea;
    this.tipoAdquisicion = tipoAdquisicion;
    this.referencia = referencia;
    this.ubicacion = ubicacion;
  }

  public String getIdentificador() {
    return identificador;
  }

  public void setIdentificador(String identificador) {
    this.identificador = identificador;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getTematicaArea() {
    return tematicaArea;
  }

  public void setTematicaArea(String tematicaArea) {
    this.tematicaArea = tematicaArea;
  }

  public String getTipoAdquisicion() {
    return tipoAdquisicion;
  }

  public void setTipoAdquisicion(String tipoAdquisicion) {
    this.tipoAdquisicion = tipoAdquisicion;
  }

  public String getReferencia() {
    return referencia;
  }

  public void setReferencia(String referencia) {
    this.referencia = referencia;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public MaterialBibliografico registrarMaterialBibliografico(
      MaterialBibliografico materialBibliografico) {
    MaterialBibliografico nuevoMaterialBibliografico = new MaterialBibliografico(identificador,
        titulo, autor, tematicaArea, tipoAdquisicion, referencia, ubicacion);
    MaterialBibliografico.operacionesBD.registrarMaterialBibliografico(nuevoMaterialBibliografico);
    return nuevoMaterialBibliografico;
  }

  public MaterialBibliografico editarMateriaBibliografico(
      MaterialBibliografico materialBibliografico) {
    MaterialBibliografico materialBibliograficoActualizado = new MaterialBibliografico(
        identificador, titulo, autor, tematicaArea, tipoAdquisicion, referencia, ubicacion);
    MaterialBibliografico.operacionesBD
        .actualizarMaterialBibliografico(materialBibliograficoActualizado);
    return materialBibliograficoActualizado;
  }
}
