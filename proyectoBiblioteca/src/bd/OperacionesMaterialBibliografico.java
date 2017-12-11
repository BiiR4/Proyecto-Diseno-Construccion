package bd;

import negocios.MaterialBibliografico;

public interface OperacionesMaterialBibliografico {
  public boolean registrarMaterialBibliografico(MaterialBibliografico materialBibliografico);

  public boolean actualizarMaterialBibliografico(MaterialBibliografico materialBibliografico);

  public boolean eliminarMaterialBibliografico(MaterialBibliografico materialBibliografico);

  public boolean buscarMaterialBibliografico(String nombre);

}
