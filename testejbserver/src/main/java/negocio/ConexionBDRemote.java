package negocio;

import java.sql.Connection;

import javax.ejb.Remote;

@Remote
public interface ConexionBDRemote {
	public Connection conectar();
}
