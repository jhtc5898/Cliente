package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Autor;

@Remote
public interface GestionAutorRemote {
	public void agregarAutor(int codigo,String nombre, String nacionalidad);
	public List<Autor> getAutor();
	public void insertarAutor(String nombre, String nacionalidad);
}
