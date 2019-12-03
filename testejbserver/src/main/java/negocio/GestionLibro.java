package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.Statement;

import modelo.Autor;
import modelo.Categoria;

@Stateless
public class GestionLibro implements GestionLibroRemote, GestionLibroLocal{
	
	private List<Categoria> categorias;
	private List<Autor> autores;
	
	public GestionLibro() {
		categorias = new ArrayList<Categoria>();
		autores = new ArrayList<Autor>();
	}

	public void insertarLibro(String isbn, String titulo, String anio, String descripcion, int numeroPaginas, String idioma, String categoria, String autor) throws SQLException {
		
		ConexionBD connect = new ConexionBD();
		Connection con = null;
		
		String sql = "SELECT a.codigo, c.codigo FROM autor a, categoria c WHERE a.nombre='"+autor+"' and c.nombre='"+categoria+"'";
		String sql1 = "INSERT INTO libro (isbn,titulo,anio,descripcion,numeroPaginas,idioma,autor_codigo,categoria_codigo) VALUES (?,?,?,?,?,?,?,?)";
		try {
			con = connect.conectar();
			int autor_codigo = 0;
			int categoria_codigo = 0;
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
			    autor_codigo = Integer.parseInt(rs.getString("a.codigo"));
			    categoria_codigo = Integer.parseInt(rs.getString("c.codigo"));   
			}
			
			PreparedStatement st1 = con.prepareStatement(sql1);
			st1.setString(1, isbn);
			st1.setString(2, titulo);
			st1.setString(3, anio);
			st1.setString(4, descripcion);
			st1.setInt(5, numeroPaginas);
			st1.setString(6, idioma);
			st1.setInt(7, autor_codigo);
			st1.setInt(8, categoria_codigo);
			st1.execute();
			System.out.println("Libro Registrado");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Autor> getAutores() {
		return autores;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	
}
