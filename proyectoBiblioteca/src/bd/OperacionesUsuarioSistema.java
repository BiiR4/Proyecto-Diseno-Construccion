package bd;

import negocios.UsuarioSistema;

public interface OperacionesUsuarioSistema {
  public boolean registarUsusarioSistema(UsuarioSistema usuarioSistema);

  public boolean actualizarUsuarioSistema(UsuarioSistema usuarioSistema);

  public boolean eliminarUsuarioSistema(UsuarioSistema usuarioSistema);

  public boolean buscarUsuarioSistema(String nombre);
}
