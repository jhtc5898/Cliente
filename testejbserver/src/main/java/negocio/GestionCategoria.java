package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import modelo.Categoria;

@Stateless
public class GestionCategoria implements GestionCategoriaRemote, GestionCategoriaLocal{
	private List<Categoria> categorias;

	public GestionCategoria() {
		categorias = new ArrayList<Categoria>();
	}

	public void agregarCategoria(String nombre, String descripcion) {
		Categoria c = new Categoria();
		c.setNombre(nombre);
		c.setDescripcion(descripcion);
		categorias.add(c);
	}

	public List<Categoria> getCategorias() {

		return categorias;
	}
	
	public void insertarCategoria(String nombre, String descripcion){		
		ConexionBD connect = new ConexionBD();
		Connection con = null;
		String query= "INSERT INTO CATEGORIA (nombre,descripcion) VALUES(?,?)";
		try {
			con = connect.conectar();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, nombre);
			pst.setString(2, descripcion);
			pst.execute();
			System.out.println("Categoria Ingresada");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}