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

    public User(String username) {
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

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }
}
