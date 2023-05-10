package es.mdef.traducpolPrueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mdef.traducpolPrueba.entidades.Servicio;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {
}
