/**
 * 
 */
package cl.confiables.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author cadiazc
 *
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    public User(Long id, String username) {
        super();
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User() {
    } // Only JPA
}
