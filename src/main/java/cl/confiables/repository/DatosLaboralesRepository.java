/**
 * 
 */
package cl.confiables.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.confiables.repository.domain.DatosLaborales;

/**
 * @author claudioantonio
 *
 */
@Repository
public interface DatosLaboralesRepository extends JpaRepository<DatosLaborales, Long>{

	Optional<DatosLaborales> findById(Long id);
	
	Optional<DatosLaborales> findByCorreo(String correo);
}
