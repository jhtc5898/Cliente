package negocio;

import javax.ejb.Remote;

@Remote
public interface GestionCategoriaRemote {
	public void insertarCategoria(String nombre, String descripcion);
}
