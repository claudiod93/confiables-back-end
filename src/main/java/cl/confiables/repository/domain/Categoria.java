/**
 * 
 */
package cl.confiables.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author claudioantonio
 *
 */
@Entity
public class Categoria {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;

	
	public Categoria() {
		// Only JPA
	}

	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}