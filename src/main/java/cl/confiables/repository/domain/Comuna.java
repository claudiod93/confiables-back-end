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
public class Comuna {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	public Comuna(){}

	public Comuna(Long id, String nombre) {
		super();
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