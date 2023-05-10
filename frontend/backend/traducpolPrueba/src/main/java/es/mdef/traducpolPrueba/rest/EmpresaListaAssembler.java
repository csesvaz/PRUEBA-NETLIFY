package es.mdef.traducpolPrueba.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.traducpolPrueba.entidades.Empresa;

@Component
public class EmpresaListaAssembler implements RepresentationModelAssembler<Empresa, EmpresaListaModel> {

	public EmpresaListaModel toModel(Empresa entity) {
		EmpresaListaModel model = new EmpresaListaModel();
		model.setNombre(entity.getNombre());
		model.setDirección(entity.getDireccion());
		model.setTelefono(entity.getTelefono());
		model.setEmail(entity.getEmail());
		model.add(linkTo(methodOn(EmpresaController.class).one(entity.getId())).withSelfRel());
		return model;

	}

	public CollectionModel<EmpresaListaModel> toCollection(List<Empresa> lista) {
		CollectionModel<EmpresaListaModel> collection = CollectionModel
				.of(lista.stream().map(this::toModel).collect(Collectors.toList()));
		collection.add(linkTo(methodOn(EmpresaController.class).all()).withRel("empresas"));
		return collection;
	}
}
