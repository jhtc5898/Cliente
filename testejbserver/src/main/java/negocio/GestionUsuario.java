package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;

@Stateless
public class GestionUsuario implements GestionUsuarioRemote, GestionUsuarioLocal {
	
	public GestionUsuario() {
	}
	
	public void insertarUsuario(String cedula, String nombre, String telefono, String direccion) {
		ConexionBD connect = new ConexionBD();
		Connection con = null;
		String query = "INSERT INTO usuario (cedula, nombre, telefono, direccion, estado_lector) VALUES (?, ?, ?, ?, 'H')";
		try {
			con = connect.conectar();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, cedula);
			pst.setString(2, nombre);
			pst.setString(3, telefono);
			pst.setString(4, direccion);
			pst.execute();
			System.out.println("Usuario Registrado");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
