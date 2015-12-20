/**
 * 
 */
package cl.confiables.rest;

import java.util.Collection;

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
 * @author cadiazc
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/users")
public class UserRestController {

	private UsuarioRepository userRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addUser(@RequestBody Usuario user) {
		System.out.println("user -- > " + user.toString());
		userRepository.save(user);
		
		return new ResponseEntity<>(null, null, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/pendientes/{proveedor}/{pendiente}")
	public Collection<Usuario> userPendientes(@PathVariable Long proveedor,@PathVariable Long pendiente){
		return userRepository.findByContratosProveedorAndContratosPendiente(proveedor, pendiente);
	}
	
	@RequestMapping(value = "/id/{userId}")
	public Usuario getUserById(@PathVariable Long userId) {
		return userRepository.findById(userId).get();
	}

	@RequestMapping(value = "/all")
	public Collection<Usuario> getAllUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/category/{category}")
	public Collection<Usuario> findByCateory(@PathVariable Long category){
		return userRepository.findByDatosLaboralesCategoria(category);
	}
	
	@Autowired
	public UserRestController(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}
}