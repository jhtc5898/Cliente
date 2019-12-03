package negocio;

import javax.ejb.Local;

@Local
public interface GestionCategoriaLocal {
	public void insertarCategoria(String nombre, String descripcion);
}
