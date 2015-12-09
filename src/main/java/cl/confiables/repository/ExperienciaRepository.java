/**
 * 
 */
package cl.confiables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.confiables.repository.domain.Experiencia;

/**
 * @author claudioantonio
 *
 */
@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>{

}
