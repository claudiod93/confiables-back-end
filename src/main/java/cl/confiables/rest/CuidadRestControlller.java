package cl.confiables.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.confiables.repository.CuidadRepository;
import cl.confiables.repository.domain.Ciudad;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/ciudad")
public class CuidadRestControlller {
	
	private CuidadRepository repository;

	@RequestMapping
	public Collection<Ciudad> getCiudades(){
		return repository.findAll();
	}
	
	@Autowired
	public CuidadRestControlller(CuidadRepository repository){
		this.repository = repository;
	}
}
