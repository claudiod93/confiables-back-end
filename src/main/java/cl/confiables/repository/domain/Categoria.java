/**
 * 
 */
package cl.confiables.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@ManyToOne
	@JsonIgnore
	private DatosLaborales datosLaborles;

	public Categoria() {
		// Only JPA
	}

	public Categoria(String nombre, 
			DatosLaborales datosLaborales) {
		this.nombre = nombre;
		this.datosLaborles = datosLaborales;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public DatosLaborales getDatosLaborles() {
		return datosLaborles;
	}
}