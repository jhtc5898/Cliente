package vistaBean;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import negocio.GestionUsuarioLocal;

@ManagedBean
public class GestionUsuarioBean {

	@Inject
	private GestionUsuarioLocal gul;
	
	/*Bean Properties*/
	private String nombre;
	private String telefono;
	private String direccion;
	private String cedula;
	
	/*Action Controller*/
	public void insertarUsuario () {
		gul.insertarUsuario(cedula, nombre, telefono, direccion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
