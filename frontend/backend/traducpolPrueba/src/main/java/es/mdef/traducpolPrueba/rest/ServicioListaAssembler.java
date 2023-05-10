package es.mdef.traducpolPrueba.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.traducpolPrueba.entidades.Servicio;

@Component
public class ServicioListaAssembler implements RepresentationModelAssembler<Servicio, ServicioListaModel> {

	public ServicioListaModel toModel(Servicio entity) {
		ServicioListaModel model = new ServicioListaModel();
		model.setIdioma(entity.getIdioma());
		model.setTipo(entity.getTipo());
		
		model.add(linkTo(methodOn(ServicioController.class).one(entity.getId())).withSelfRel());
		return model;

	}

	public CollectionModel<ServicioListaModel> toCollection(List<Servicio> lista) {
		CollectionModel<ServicioListaModel> collection = CollectionModel
				.of(lista.stream().map(this::toModel).collect(Collectors.toList()));
		collection.add(linkTo(methodOn(ServicioController.class).all()).withRel("servicios"));
		return collection;
	}
}
