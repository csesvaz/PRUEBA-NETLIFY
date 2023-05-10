package es.mdef.traducpolPrueba.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;

import org.springframework.stereotype.Component;

import es.mdef.traducpolPrueba.entidades.Servicio;
import es.mdef.traducpolPrueba.entidades.Servicio.Tipo;
import es.mdef.traducpolPrueba.entidades.ServicioInterpretacion;
import es.mdef.traducpolPrueba.entidades.ServicioTraduccion;

@Component
public class ServicioAssembler implements RepresentationModelAssembler<Servicio, ServicioModel> {

	public Servicio toEntity(ServicioModel model) {
		Servicio servicio;

		switch (model.getTipo()) {
		case traducción: {
			servicio = new ServicioTraduccion();
			((ServicioTraduccion) servicio).setTipoDocumento(model.getTipoDocumento());
			((ServicioTraduccion) servicio).setPlazoEntrega(model.getPlazoEntrega());
			((ServicioTraduccion) servicio).setTraductorJurado(model.isTraductorJurado());
			((ServicioTraduccion) servicio).setTipo(Tipo.traducción);
			break;
		}
		case interpretación: {
			servicio = new ServicioInterpretacion();
			((ServicioInterpretacion) servicio).setProvincia(model.getProvincia());
			((ServicioInterpretacion) servicio).setHorarioInicioServicio(model.getHorarioInicioServicio());
			((ServicioInterpretacion) servicio).setHorarioFinServicio(model.getHorarioFinServicio());
			((ServicioInterpretacion) servicio).setServicioOnline(model.isServicioOnline());
			((ServicioInterpretacion) servicio).setTipo(Tipo.interpretación);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + model.getTipo());
		}
		servicio.setIdioma(model.getIdioma());
		servicio.setEmpresa(model.getEmpresa());
		return servicio;
	}

	@Override
	public ServicioModel toModel(Servicio entity) {
		ServicioModel model = new ServicioModel();
		model.setIdioma(entity.getIdioma());
		model.setEmpresa(entity.getEmpresa());
		switch (entity.getTipo()) {
		case traducción: {
			ServicioTraduccion traductor = (ServicioTraduccion) entity;
			model.setTipoDocumento(traductor.getTipoDocumento());
			model.setPlazoEntrega(traductor.getPlazoEntrega());
			model.setTraductorJurado(traductor.isTraductorJurado());
			model.setTipo(Tipo.traducción);
			entity = traductor;
			break;
		}
		case interpretación: {
			ServicioInterpretacion interprete = (ServicioInterpretacion) entity;
			model.setProvincia(interprete.getProvincia());
			model.setHorarioInicioServicio(interprete.getHorarioInicioServicio());
			model.setHorarioFinServicio(interprete.getHorarioFinServicio());
			model.setServicioOnline(interprete.isServicioOnline());
			model.setTipo(Tipo.interpretación);
			entity = interprete;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + entity.getTipo());
		}

		model.add(
				linkTo(methodOn(ServicioController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(EmpresaController.class).one(entity.getEmpresa().getId())).withRel("empresa"));

		return model;
	}

}
