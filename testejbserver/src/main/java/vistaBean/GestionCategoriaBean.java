package vistaBean;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import negocio.GestionCategoriaLocal;

@ManagedBean
public class GestionCategoriaBean {
	
	@Inject
	private GestionCategoriaLocal gcl;
	
	/*Bean Properties*/
	private int codigo;
	private String nombre;
	private String descripcion;
	
	/*Action Controller*/
	public void insertarCategoria() {
		gcl.insertarCategoria(nombre, descripcion);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
