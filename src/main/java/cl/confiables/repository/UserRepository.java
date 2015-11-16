/**
 * 
 */
package cl.confiables.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cadiazc
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);
}
