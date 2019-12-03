package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import modelo.Autor;

@Stateless
public class GestionAutor implements GestionAutorRemote, GestionAutorLocal{

	private List<Autor> autor = new ArrayList<Autor>();
	
	public GestionAutor() {
		
	}
	
	public void agregarAutor(int codigo,String nombre, String nacionalidad) {
		Autor a = new Autor();
		a.setCodigo(codigo);
		a.setNombre(nombre);
		a.setNacionalidad(nacionalidad);
		autor.add(a);
	}

	public List<Autor> getAutor() {
		ConexionBD connect = new ConexionBD();
		Connection con = null;
		String query= "SELECT * FROM autor";
		try {
			con = connect.conectar();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			List<Autor> autorList = new ArrayList<Autor>();
			while(rs.next())
			{
				Autor a= new Autor();
				a.setCodigo(rs.getInt(0));
				a.setNombre(rs.getString(1));
				a.setNacionalidad(rs.getString(2));
			    autorList.add(a);
			    System.out.println(a);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return autor;
	}
	
	public void insertarAutor(String nombre, String nacionalidad){
		ConexionBD connect = new ConexionBD();
		Connection con = null;
		String query= "INSERT INTO autor (nombre,nacionalidad) VALUES(?,?)";
		try {
			con = connect.conectar();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, nombre);
			pst.setString(2, nacionalidad);
			pst.execute();
			System.out.println("Autor Ingresado");
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}