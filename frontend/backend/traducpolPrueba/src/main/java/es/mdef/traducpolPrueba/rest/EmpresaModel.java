package es.mdef.traducpolPrueba.rest;

import java.util.List;

//import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.traducpolPrueba.entidades.Servicio;

//import es.mdef.traducpolPrueba.entidades.Servicio;

@Relation(itemRelation = "empresa")
public class EmpresaModel extends RepresentationModel<EmpresaModel>{
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private String cif;
	private List <Servicio> servicio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
//	public List<Servicio> getServicio() {
//		return servicio;
//	}
//	public void setServicio(List<Servicio> servicio) {
//		this.servicio = servicio;
//	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public List <Servicio> getServicio() {
		return servicio;
	}
	public void setServicio(List <Servicio> servicio) {
		this.servicio = servicio;
	}
	
}
