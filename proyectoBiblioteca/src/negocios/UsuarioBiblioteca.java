package negocios;

import bd.OperacionesUsuarioBiblioteca;

public class UsuarioBiblioteca {
  protected String nombre;
  protected String apellidoPaterno;
  protected String apellidoMaterno;
  protected int telefono;
  protected String email;
  protected boolean moroso;

  protected static OperacionesUsuarioBiblioteca operacionUsuarioBibloteca;


  public UsuarioBiblioteca(String nombre, String apellidoPaterno, String apellidoMaterno,
      int telefono, String email, boolean moroso) {
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.telefono = telefono;
    this.email = email;
    this.moroso = moroso;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public int getTelefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean esMoroso() {
    return moroso;
  }

  public void setMoroso(boolean moroso) {
    this.moroso = moroso;
  }

  public UsuarioBiblioteca registrarUsuarioBiblioteca(UsuarioBiblioteca usuarioBiblioteca) {
    UsuarioBiblioteca nuevoUsuarioBiblioteca =
        new UsuarioBiblioteca(nombre, apellidoPaterno, apellidoMaterno, telefono, email, moroso);
    UsuarioBiblioteca.operacionUsuarioBibloteca.registrarUsuarioBiblioteca(nuevoUsuarioBiblioteca);
    return nuevoUsuarioBiblioteca;
  }

}
