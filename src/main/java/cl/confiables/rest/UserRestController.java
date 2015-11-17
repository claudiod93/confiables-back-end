/**
 * 
 */
package cl.confiables.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> addUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(null, null, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{username}")
    List<User> getUser(@PathVariable String username){
        return userRepository.findByUsername(username);
    }
    
    @Autowired
    public UserRestController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
