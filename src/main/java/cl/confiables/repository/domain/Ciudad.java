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
public class Ciudad {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;

	public Ciudad() {
		// TODO Auto-generated constructor stub
	}

	public Ciudad(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

}
