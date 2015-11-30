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
public class Direcciones {

	@Id
	@GeneratedValue
	private Long id;
	private String direccion;
	private String complemento;
	private String codPostal;
	
	public Direcciones(){
		// Only JPA
	}
	
	public Direcciones(String direccion, String complemento, String codPostal) {
		super();
		this.direccion = direccion;
		this.complemento = complemento;
		this.codPostal = codPostal;
	}

	public Long getId() {
		return id;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCodPostal() {
		return codPostal;
	}
}