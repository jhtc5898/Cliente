package negocio;

import java.sql.SQLException;

import javax.ejb.Local;

@Local
public interface GestionLibroLocal {
	public void insertarLibro(String isbn, String titulo, String anio, String descripcion, int numeroPaginas, String idioma, String categoria, String autor) throws SQLException;
}
