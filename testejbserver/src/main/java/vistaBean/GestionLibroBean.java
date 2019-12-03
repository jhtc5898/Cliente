package vistaBean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import negocio.GestionLibroLocal;

@ManagedBean
public class GestionLibroBean {

	@Inject
	private GestionLibroLocal gll;
	
	/*Bean Properties*/
	private String isbn;
	private String titulo;
	private String anio;
	private String descripcion;
	private int numPaginas;
	private String idioma;
	private String autor;
	private String categoria;
	
	/*Action Controller*/
	public void insertarLibro() {
		try {
			gll.insertarLibro(isbn, titulo, anio, descripcion, numPaginas, idioma, categoria, autor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
