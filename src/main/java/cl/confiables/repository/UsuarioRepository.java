/**
 * 
 */
package cl.confiables.repository;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.confiables.repository.domain.Usuario;
import java.util.Set;
import java.util.List;

/**
 * @author cadiazc
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByNombreUsuario(String username);

	Optional<Usuario> findById(Long id);

	//Login application
	Optional<Usuario> findByNombreUsuarioOrMailAndContrasena(String nombreUsuario, String mail, String contrasena);
	
	// User by category's, for search 
	Collection<Usuario> findByDatosLaboralesCategoria(Long categoria);
	
	Collection<Usuario> findByDireccionIdAndDatosLaboralesCategoria(Long idDireccion, Long idCategoria);
	
	Collection<Usuario> findByContratosProveedorAndContratosPendiente(Long proveedor, Long pendiente);
	
	@Modifying
	@Transactional
	@Query("update Usuario u set u.mail = ?1 where u.id = ?2")
	int updareCorreo(String mail, Long id);
}