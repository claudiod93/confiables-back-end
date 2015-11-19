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

import cl.confiables.repository.Contracts;
import cl.confiables.repository.ContractsRepository;
import cl.confiables.repository.User;
import cl.confiables.repository.UserRepository;

/**
 * @author cadiazc
 *
 */
@RestController
@RequestMapping("/users")
public class UserRestController {

	private UserRepository userRepository;

	private ContractsRepository contractsRepository;

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addUser(@RequestBody User user) {
		userRepository.save(user);
		return new ResponseEntity<>(null, null, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/name/{username}")
	public User getUser(@PathVariable String username) {
		return userRepository.findByUsername(username).get();
	}

	@RequestMapping(value = "/id/{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userRepository.findById(userId).get();
	}

	@RequestMapping(value = "/{userId}/contracts", method = RequestMethod.POST)
	public ResponseEntity<?> addContracts(@PathVariable Long userId,
			@RequestBody Contracts contracts) {
		return this.userRepository
				.findById(userId)
				.map(user -> {
					Contracts result = contractsRepository.save(new Contracts(
							user, contracts.getProvider(), contracts.getName()));

					HttpHeaders httpHeaders = new HttpHeaders();
					httpHeaders.setLocation(ServletUriComponentsBuilder
							.fromCurrentRequest().path("/{id}")
							.buildAndExpand(result.getId()).toUri());
					return new ResponseEntity<>(null, httpHeaders,
							HttpStatus.CREATED);
				}).get();
	}

	@RequestMapping(value = "get/{userId}/contracts")
	public Collection<Contracts> contractsByUser(@PathVariable Long userId) {
		return this.contractsRepository.findByUser(userId);
	}

	@Autowired
	public UserRestController(UserRepository userRepository,
			ContractsRepository contractsRepository) {
		this.userRepository = userRepository;
		this.contractsRepository = contractsRepository;
	}
}
