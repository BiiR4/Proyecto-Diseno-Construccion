package negocios;

public class Academico extends UsuarioBiblioteca {
  private String noPersonal;
  private String programaAdscripcion;
  private String tipoAcademico;

  private Academico(String nombre, String apellidoPaterno, String apellidoMaterno, int telefono,
      String email, boolean moroso, String noPersonal, String programaAdscripcion,
      String tipoAcademico) {
    super(nombre, apellidoPaterno, apellidoMaterno, telefono, email, moroso);
    this.noPersonal = noPersonal;
    this.programaAdscripcion = programaAdscripcion;
    this.tipoAcademico = tipoAcademico;
  }

  public String getNoPersonal() {
    return noPersonal;
  }

  public void setNoPersonal(String noPersonal) {
    this.noPersonal = noPersonal;
  }

  public String getProgramaAdscripcion() {
    return programaAdscripcion;
  }

  public void setProgramaAdscripcion(String programaAdscripcion) {
    this.programaAdscripcion = programaAdscripcion;
  }

  public String getTipoAcademico() {
    return tipoAcademico;
  }

  public void setTipoAcademico(String tipoAcademico) {
    this.tipoAcademico = tipoAcademico;
  }

  public UsuarioBiblioteca registrarUsuarioBiblioteca(Academico academico) {
    Academico nuevoUsuarioBiblioteca = new Academico(nombre, apellidoPaterno, apellidoMaterno,
        telefono, email, moroso, noPersonal, programaAdscripcion, tipoAcademico);
    UsuarioBiblioteca.operacionUsuarioBibloteca.registrarUsuarioBiblioteca(nuevoUsuarioBiblioteca);
    return nuevoUsuarioBiblioteca;
  }
}
