/**
 * 
 */
package cl.confiables.rest;

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

import cl.confiables.repository.DatosLaboralesRepository;
import cl.confiables.repository.ExperienciaRepository;
import cl.confiables.repository.domain.Experiencia;

/**
 * @author claudioantonio
 *
 */
@RestController
//@RequestMapping("/datos-laborales")
public class DatosLaboralesRestController {

	private DatosLaboralesRepository dlRepository;

	private ExperienciaRepository experienciaRepository;

//	@RequestMapping(value = "/{id}/add-expreciencia", method = RequestMethod.POST)
	public ResponseEntity<?> addExperienci(@PathVariable Long id,
			@RequestBody Experiencia expeiencia) {

		return dlRepository
				.findById(id)
				.map(dl -> {
					Experiencia result = experienciaRepository.save(expeiencia);

					HttpHeaders httpHeaders = new HttpHeaders();
					httpHeaders.setLocation(ServletUriComponentsBuilder
							.fromCurrentRequest().path("/{id}")
							.buildAndExpand(result.getId()).toUri());
					return new ResponseEntity<>(null, httpHeaders,
							HttpStatus.CREATED);
				}).get();
	}

	@Autowired
	public DatosLaboralesRestController(DatosLaboralesRepository dlRepository,
			ExperienciaRepository experienciaRepository) {
		this.dlRepository = dlRepository;
		this.experienciaRepository = experienciaRepository;
	}
}
