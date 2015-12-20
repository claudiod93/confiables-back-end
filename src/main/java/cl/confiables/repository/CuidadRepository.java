package cl.confiables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.confiables.repository.domain.Ciudad;

public interface CuidadRepository extends JpaRepository<Ciudad, Long>{

}
