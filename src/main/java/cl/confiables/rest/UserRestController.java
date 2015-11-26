/**
 * 
 */
package cl.confiables.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.confiables.repository.ContratoRepository;
import cl.confiables.repository.UsuarioRepository;
import cl.confiables.repository.domain.Contrato;
import cl.confiables.repository.domain.Usuario;

/**
 * @author cadiazc
 *
 */
@RestController
@RequestMapping("/users")
public class UserRestController {

	private UsuarioRepository userRepository;

	private ContratoRepository contractsRepository;

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addUser(@RequestBody Usuario user) {
		userRepository.save(user);
		return new ResponseEntity<>(null, null, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/name/{username}")
	public Usuario getUser(@PathVariable String username) {
		return userRepository.findByNombreUsuario(username).get();
	}

	@RequestMapping(value = "/id/{userId}")
	public Usuario getUserById(@PathVariable Long userId) {
		return userRepository.findById(userId).get();
	}

	@RequestMapping(value = "/{userId}/contracts", method = RequestMethod.POST)
	public ResponseEntity<?> addContracts(@PathVariable Long userId,
			@RequestBody Contrato contracts) {
		return this.userRepository
				.findById(userId)
				.map(user -> {
					Contrato result = contractsRepository.save(new Contrato(
							user, contracts.getProveedor(), contracts
									.getNombre()));

					HttpHeaders httpHeaders = new HttpHeaders();
					httpHeaders.setLocation(ServletUriComponentsBuilder
							.fromCurrentRequest().path("/{id}")
							.buildAndExpand(result.getId()).toUri());
					return new ResponseEntity<>(null, httpHeaders,
							HttpStatus.CREATED);
				}).get();
	}
	
	

	@RequestMapping(value = "get/{userId}/contracts")
	public Collection<Contrato> contractsByUser(@PathVariable Long userId) {
		return this.contractsRepository.findByUsuarioId(userId);
	}

	@RequestMapping(value = "login/{usuario}")
	public Usuario login(@PathVariable Usuario usuario) {
		Usuario user = this.userRepository
				.findByNombreUsuarioOrMailAndContrasena(
						usuario.getNombreUsuario(), usuario.getMail(),
						usuario.getContrasena()).get();
		return user;
	}

	@Autowired
	public UserRestController(UsuarioRepository userRepository,
			ContratoRepository contractsRepository) {
		this.userRepository = userRepository;
		this.contractsRepository = contractsRepository;
	}
}