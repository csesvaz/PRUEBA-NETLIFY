package es.mdef.traducpolPrueba.rest;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.mdef.traducpolPrueba.TraducpolPruebaApplication;
import es.mdef.traducpolPrueba.entidades.Servicio;
import es.mdef.traducpolPrueba.entidades.ServicioTraduccion;
import es.mdef.traducpolPrueba.repositorios.ServicioRepositorio;
import es.mdef.traducpolPrueba.entidades.ServicioInterpretacion;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
	private final ServicioRepositorio repositorio;
	private final ServicioAssembler assembler;
	private final ServicioListaAssembler listaAssembler;
	private final Logger log;

	ServicioController(ServicioRepositorio repositorio, ServicioAssembler assembler,
			ServicioListaAssembler listaAssembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		this.log = TraducpolPruebaApplication.log;
	}

	@GetMapping("{id}")
	public ServicioModel one(@PathVariable Long id) {
		Servicio servicio = repositorio.findById(id).orElseThrow();
		log.info("Recuperado " + servicio);
		return assembler.toModel(servicio);
	}

	@GetMapping
	public CollectionModel<ServicioListaModel> all() {
		return listaAssembler.toCollection(repositorio.findAll());
	}

	@PostMapping
	public ServicioModel add(@RequestBody ServicioModel model) {
		Servicio servicio = repositorio.save(assembler.toEntity(model));
		log.info("Añadido " + servicio);
		return assembler.toModel(servicio);
	}

	@PutMapping("{id}")
	public ServicioModel edit(@PathVariable Long id, @RequestBody ServicioModel model) {
		Servicio servicio = repositorio.findById(id).map(ped -> {
			ped.setIdioma(model.getIdioma());
			switch (ped.getTipo()) {
			case traducción: {
				ServicioTraduccion traductor = (ServicioTraduccion) ped;
				traductor.setPlazoEntrega(model.getPlazoEntrega());
				traductor.setTipoDocumento(model.getTipoDocumento());
				traductor.setTraductorJurado(model.isTraductorJurado());
				ped = traductor;
				break;
			}
			case interpretación: {
				ServicioInterpretacion interprete = (ServicioInterpretacion) ped;
				interprete.setProvincia(model.getProvincia());
				interprete.setHorarioInicioServicio(model.getHorarioInicioServicio());
				interprete.setHorarioFinServicio(model.getHorarioFinServicio());
				interprete.setServicioOnline(model.isServicioOnline());
				ped = interprete;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ped.getTipo());
			}

			return repositorio.save(ped);
		}).orElseThrow();
		log.info("Actualizado " + servicio);
		return assembler.toModel(servicio);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrado Servicio " + id);
		repositorio.deleteById(id);
	}

}
