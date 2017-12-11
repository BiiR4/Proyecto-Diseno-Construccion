package negocios;

import bd.OperacionesUsuarioSistema;

public class UsuarioSistema {
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String tipoPersonal;
  private String noPersonal;
  private String contraseña;
  private String email;

  private static OperacionesUsuarioSistema operacionesUsuarioSistema;

  private UsuarioSistema(String nombre, String apellidoPaterno, String apellidoMaterno,
      String tipoPersonal, String noPersonal, String contraseña, String email) {
    super();
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.tipoPersonal = tipoPersonal;
    this.noPersonal = noPersonal;
    this.contraseña = contraseña;
    this.email = email;
  }

  public String getTipoPersonal() {
    return tipoPersonal;
  }

  public void setTipoPersonal(String tipoPersonal) {
    this.tipoPersonal = tipoPersonal;
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

  public void setApellidoMaterno(String appelidoMaterno) {
    this.apellidoMaterno = appelidoMaterno;
  }

  public String getNoPersonal() {
    return noPersonal;
  }

  public void setNoPersonal(String noPersonal) {
    this.noPersonal = noPersonal;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UsuarioSistema registrarUsuarioSistema(UsuarioSistema usuarioSistema) {
    UsuarioSistema nuevoUsuarioSistema = new UsuarioSistema(nombre, apellidoPaterno,
        apellidoMaterno, tipoPersonal, noPersonal, contraseña, email);
    UsuarioSistema.operacionesUsuarioSistema.registarUsusarioSistema(nuevoUsuarioSistema);
    return nuevoUsuarioSistema;
  }
}
