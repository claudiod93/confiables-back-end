/**
 * 
 */
package cl.confiables.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.confiables.exception.UserNotFoundException;
import cl.confiables.repository.UsuarioRepository;
import cl.confiables.repository.domain.Usuario;

/**
 * @author claudioantonio
 *
 */
@RestController
//@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/login")
public class LoginRest {

	private UsuarioRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Usuario login(@RequestBody Usuario usuario) {
		this.validateUser(usuario);
		Usuario user = this.userRepository
				.findByNombreUsuarioOrMailAndContrasena(
						usuario.getNombreUsuario(), usuario.getMail(),
						usuario.getContrasena()).get();
		if (user == null || user.getNombreUsuario().isEmpty()) {
			throw new UserNotFoundException();
		}
		return user;
	}

	private void validateUser(Usuario usuario) {
		this.userRepository.findByNombreUsuarioOrMailAndContrasena(
				usuario.getNombreUsuario(), usuario.getMail(),
				usuario.getContrasena()).orElseThrow(
				() -> new UserNotFoundException());
	}

	@Autowired
	public LoginRest(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}
}