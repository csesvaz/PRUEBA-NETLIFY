package es.mdef.traducpolPrueba.rest;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.traducpolPrueba.entidades.Servicio.Tipo;

@Relation(collectionRelation = "servicios")
public class ServicioListaModel extends RepresentationModel<ServicioListaModel> {
	private String idioma;
	private Tipo tipo;
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
}
