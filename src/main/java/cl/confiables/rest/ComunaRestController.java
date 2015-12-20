/**
 * 
 */
package cl.confiables.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.confiables.repository.ComunaRepository;
import cl.confiables.repository.domain.Comuna;

/**
 * @author claudioantonio
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/comunas")
public class ComunaRestController {

	private ComunaRepository comunaRepository;
	
	@RequestMapping
	public Collection<Comuna> getComunas(){
		return comunaRepository.findAll();
	}
	
	@Autowired
	public ComunaRestController(ComunaRepository comunaRepository){
		this.comunaRepository = comunaRepository;
	}
}
