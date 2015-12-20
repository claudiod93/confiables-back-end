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
public class Especialidades {

	@Id
	@GeneratedValue
	private int id;
	private String nombre;

	public Especialidades(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Especialidades() {

	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}