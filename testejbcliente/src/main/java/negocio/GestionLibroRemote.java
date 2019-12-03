package negocio;

import java.sql.SQLException;

public interface GestionLibroRemote {
	public void insertarLibro(String isbn, String titulo, String anio, String descripcion, int numeroPaginas, String idioma, String categoria, String autor) throws SQLException;
}
