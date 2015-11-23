/**
 * 
 */
package cl.confiables.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.confiables.repository.domain.Usuario;

/**
 * @author cadiazc
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByNombreUsuario(String username);

	Optional<Usuario> findById(Long id);

	Optional<Usuario> findByNombreUsuarioOrMailAndContrasena(String nombreUsuario, String mail, String contrasena);
}