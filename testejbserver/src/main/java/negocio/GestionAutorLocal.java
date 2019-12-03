package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Autor;

@Local
public interface GestionAutorLocal {
	public void agregarAutor(int codigo,String nombre, String nacionalidad);
	public List<Autor> getAutor();
	public void insertarAutor(String nombre, String nacionalidad);
}
