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

import cl.confiables.repository.ExperienciaRepository;
import cl.confiables.repository.UsuarioRepository;
import cl.confiables.repository.domain.Experiencia;

/**
 * @author claudioantonio
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/experiencia")
public class ExperienciaRestController {

	private UsuarioRepository userRepository;
	
	private ExperienciaRepository experienciaRepository;
	
	@RequestMapping(value = "/byid/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> addExperienci(@PathVariable Long id,
			@RequestBody Experiencia experiencia) {
		return this.userRepository
				.findById(id)
				.map(dl -> {
					Experiencia result = experienciaRepository.save(experiencia);

					HttpHeaders httpHeaders = new HttpHeaders();
					httpHeaders.setLocation(ServletUriComponentsBuilder
							.fromCurrentRequest().path("/{id}")
							.buildAndExpand(result.getId()).toUri());
					return new ResponseEntity<>(null, httpHeaders,
							HttpStatus.CREATED);
				}).get();
	}
	
	@Autowired
	public ExperienciaRestController(UsuarioRepository userRepository, ExperienciaRepository experienciaRepository){
		this.userRepository = userRepository;
		this.experienciaRepository = experienciaRepository;
	}
}
