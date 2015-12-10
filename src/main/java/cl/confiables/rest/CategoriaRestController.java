/**
 * 
 */
package cl.confiables.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.confiables.repository.CategoriaRepository;
import cl.confiables.repository.domain.Categoria;

/**
 * @author claudioantonio
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/categoria")
public class CategoriaRestController {
	
	private CategoriaRepository categoriaRepository;

	@RequestMapping
	public Collection<Categoria> getAll(){
		return categoriaRepository.findAll();
	}
	@Autowired
	public CategoriaRestController(CategoriaRepository categoriaRepository){
		this.categoriaRepository = categoriaRepository;
	}
}
