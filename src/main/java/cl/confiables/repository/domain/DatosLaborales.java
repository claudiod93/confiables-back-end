/**
 * 
 */
package cl.confiables.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author claudioantonio
 *
 */
@Entity
public class DatosLaborales {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String correo;

	public DatosLaborales() { // Only JPA
	}

	public DatosLaborales(String correo) {
		this.correo = correo;
	}

	public Long getId() {
		return id;
	}

	public String getCorreo() {
		return correo;
	}
}