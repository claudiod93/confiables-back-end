package cl.confiables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.confiables.repository.domain.Especialidades;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidades, Long>{

}
