/**
 * 
 */
package cl.confiables.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.confiables.repository.UsuarioRepository;
import cl.confiables.repository.domain.Usuario;

/**
 * @author claudioantonio
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/datoslaborales")
public class DatosLaboralesRestController {

	private UsuarioRepository userRepository;
	
	@RequestMapping(value = "/byuserid/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> addLaborales(@PathVariable Long id, @RequestBody Usuario user){
		Usuario usuario = userRepository.findById(id).get();
		usuario.setDatosLaborales(user.getDatosLaborales());
		userRepository.saveAndFlush(usuario);
		
		return new ResponseEntity<>(null, null, HttpStatus.CREATED);
	}
	
	@Autowired
	public DatosLaboralesRestController(UsuarioRepository userRepository){
		this.userRepository = userRepository;
	}
}
