package cl.confiables.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.confiables.repository.EspecialidadRepository;
import cl.confiables.repository.domain.Especialidades;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/especialidad")
public class EspecialidadRestController {

	private EspecialidadRepository repository;
	
	@RequestMapping
	public Collection<Especialidades> getEspecialidades(){
		return repository.findAll();
	}
	
	@Autowired
	public EspecialidadRestController(EspecialidadRepository repository){
		this.repository = repository;
	}
}
