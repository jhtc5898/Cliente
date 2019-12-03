package negocio;

import java.util.List;

import modelo.Autor;

public interface GestionAutorRemote {
	public void insertarAutor(String nacionalidad, String descripcion);
	public List<Autor> getAutor();
}
