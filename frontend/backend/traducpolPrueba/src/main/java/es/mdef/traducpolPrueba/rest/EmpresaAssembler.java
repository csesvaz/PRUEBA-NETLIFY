package es.mdef.traducpolPrueba.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;

import org.springframework.stereotype.Component;

import es.mdef.traducpolPrueba.entidades.Empresa;





@Component
public class EmpresaAssembler implements RepresentationModelAssembler<Empresa, EmpresaModel> {

	public Empresa toEntity(EmpresaModel model) {
		Empresa empresa = new Empresa();
		empresa.setNombre(model.getNombre());
		empresa.setDireccion(model.getDireccion());
		empresa.setTelefono(model.getTelefono());
		empresa.setEmail(model.getEmail());
		empresa.setCif(model.getCif());
		empresa.setServicio(model.getServicio());
		
		return empresa;
	}

	@Override
	public EmpresaModel toModel(Empresa entity) {
		EmpresaModel model = new EmpresaModel();
		model.setNombre(entity.getNombre());
		model.setDireccion(entity.getDireccion());
		model.setTelefono(entity.getTelefono());
		model.setEmail(entity.getEmail());
		model.setCif(entity.getCif());
		model.setServicio(entity.getServicio());
		model.add(
				linkTo(methodOn(EmpresaController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(EmpresaController.class).getServiciosEmpresa(entity.getId())).withRel("servicios")
				
				);
		return model;
	}



}
