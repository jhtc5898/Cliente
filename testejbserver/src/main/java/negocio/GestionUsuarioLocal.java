package negocio;

import javax.ejb.Local;

@Local
public interface GestionUsuarioLocal {
	public void insertarUsuario(String cedula, String nombre, String telefono, String direccion);
}
