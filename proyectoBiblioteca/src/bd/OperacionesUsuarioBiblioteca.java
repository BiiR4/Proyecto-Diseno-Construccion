package bd;

import negocios.UsuarioBiblioteca;

public interface OperacionesUsuarioBiblioteca {
  public boolean registrarUsuarioBiblioteca(UsuarioBiblioteca usuarioBiblioteca);

  public boolean actualizarUsuarioBiblioteca(UsuarioBiblioteca usuarioBiblioteca);

  public boolean eliminarUsuarioBiblioteca(UsuarioBiblioteca usuarioBiblioteca);

  public boolean buscarUsuarioBiblioteca(String nombre);

}
