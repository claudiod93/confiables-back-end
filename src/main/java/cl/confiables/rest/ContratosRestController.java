/**
 * 
 */
package cl.confiables.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.confiables.repository.ContratoRepository;
import cl.confiables.repository.UsuarioRepository;
import cl.confiables.repository.domain.Contrato;

/**
 * @author claudioantonio
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/contratos")
public class ContratosRestController {
	
	private UsuarioRepository userRepository;

	private ContratoRepository contractsRepository;
	
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


	@Autowired
	public ContratosRestController(UsuarioRepository userRepository,
			ContratoRepository contractsRepository){
		this.userRepository = userRepository;
		this.contractsRepository = contractsRepository;
	}
}
