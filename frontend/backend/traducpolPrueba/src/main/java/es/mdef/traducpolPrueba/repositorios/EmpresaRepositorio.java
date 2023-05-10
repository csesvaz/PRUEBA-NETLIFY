package es.mdef.traducpolPrueba.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mdef.traducpolPrueba.entidades.Empresa;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {
}
