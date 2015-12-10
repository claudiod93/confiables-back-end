/**
 * 
 */
package cl.confiables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.confiables.repository.domain.Categoria;

/**
 * @author claudioantonio
 *
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
