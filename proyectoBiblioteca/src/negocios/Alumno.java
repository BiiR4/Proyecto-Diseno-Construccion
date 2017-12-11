package negocios;

public class Alumno extends UsuarioBiblioteca {
  private String matricula;
  private String carrera;

  private Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, int telefono,
      String email, boolean moroso, String matricula, String carrera) {
    super(nombre, apellidoPaterno, apellidoMaterno, telefono, email, moroso);
    this.matricula = matricula;
    this.carrera = carrera;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  public UsuarioBiblioteca registrarUsuarioBiblioteca(Alumno alumno) {
    Alumno nuevoUsuarioBiblioteca = new Alumno(nombre, apellidoPaterno, apellidoMaterno, telefono,
        email, moroso, matricula, carrera);
    UsuarioBiblioteca.operacionUsuarioBibloteca.registrarUsuarioBiblioteca(nuevoUsuarioBiblioteca);
    return nuevoUsuarioBiblioteca;
  }

}
