package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.ejb.Stateless;

@Stateless
public class ConexionBD implements ConexionBDRemote{
	
	public static final String URL="jdbc:mysql://localhost:3306/plataformas_web?serverTimezone=UTC";
	public static final String user="root";
	public static final String password="";
	public static final String Controlador= "com.mysql.cj.jdbc.Driver";
	
	static {
		try {
			Class.forName(Controlador);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Failed");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL,user,password);
			System.out.println("Connected");
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		return conexion;
	}
}
