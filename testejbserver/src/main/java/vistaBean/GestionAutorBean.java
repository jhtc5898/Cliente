package vistaBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Autor;
import negocio.GestionAutorLocal;

@ManagedBean
public class GestionAutorBean {
	
	@Inject
	private GestionAutorLocal gal;
	
	/*Bean properties*/
	private int codigo;
	private String nombre;
	private String descripcion;
	private String nacionalidad;
	private List<Autor> autorList;
	
	/*Action Controller*/
	public String insertarAutor() {
		gal.insertarAutor(nombre, nacionalidad);
		return "insertar-autor";
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
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public List<Autor> getAutorList() {
		return autorList;
	}
	public void setAutorList(List<Autor> autorList) {
		this.autorList = autorList;
	}
}
