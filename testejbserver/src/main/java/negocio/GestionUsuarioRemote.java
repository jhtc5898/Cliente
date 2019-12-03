package negocio;

import javax.ejb.Remote;

@Remote
public interface GestionUsuarioRemote {
	public void insertarUsuario(String cedula, String nombre, String telefono, String direccion);
}
