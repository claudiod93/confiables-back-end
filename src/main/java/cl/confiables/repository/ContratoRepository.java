package cl.confiables.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>{

	Collection<Contrato> findByUsuarioId(Long usuario);
}
