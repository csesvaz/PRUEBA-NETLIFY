package es.mdef.traducpolPrueba.rest;
import org.slf4j.Logger;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import es.mdef.traducpolPrueba.TraducpolPruebaApplication;
import es.mdef.traducpolPrueba.entidades.Empresa;
import es.mdef.traducpolPrueba.repositorios.EmpresaRepositorio;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	private final EmpresaRepositorio repositorio;
	private final EmpresaAssembler assembler;
	private final EmpresaListaAssembler listaAssembler;
	private final ServicioListaAssembler servicioListaAssembler;
	private final Logger log;
	
	EmpresaController(EmpresaRepositorio repositorio, EmpresaAssembler assembler,
			EmpresaListaAssembler listaAssembler, ServicioListaAssembler servicioListaAssembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		this.servicioListaAssembler = servicioListaAssembler;
		this.log = TraducpolPruebaApplication.log;
	}

	@GetMapping("{id}")
	public EmpresaModel one(@PathVariable Long id) {
		Empresa empresa = repositorio.findById(id).orElseThrow();
		log.info("Recuperada " + empresa);
		return assembler.toModel(empresa);
	}

	@GetMapping
	public CollectionModel<EmpresaListaModel> all() {
		return listaAssembler.toCollection(repositorio.findAll());
	}

	@GetMapping("{id}/servicios")
	public CollectionModel<ServicioListaModel> getServiciosEmpresa(@PathVariable Long id) {
		return CollectionModel.of(repositorio.findById(id).orElseThrow()
						.getServicio().stream().map(servicio -> servicioListaAssembler.toModel(servicio))
				.collect(Collectors.toList()),
				linkTo(methodOn(EmpresaController.class).one(id)).slash("servicios").withSelfRel());
	}

	@PostMapping
	public EmpresaModel add(@RequestBody EmpresaModel model) {
		Empresa Empresa = repositorio.save(assembler.toEntity(model));
		log.info("Añadida " + Empresa);
		return assembler.toModel(Empresa);
	}

	@PutMapping("{id}")
	public EmpresaModel edit(@PathVariable Long id, @RequestBody EmpresaModel model) {
		Empresa empresa = repositorio.findById(id).map(ped -> {
			ped.setNombre(model.getNombre());
			ped.setDireccion(model.getDireccion());
			ped.setTelefono(model.getTelefono());
			ped.setEmail(model.getEmail());
			ped.setCif(model.getCif());

			return repositorio.save(ped);
		}).orElseThrow();
		log.info("Actualizado " + empresa);
		return assembler.toModel(empresa);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrada empresa " + id);
		repositorio.deleteById(id);
	}

}
