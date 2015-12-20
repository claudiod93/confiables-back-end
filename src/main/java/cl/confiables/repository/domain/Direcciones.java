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
	private String comuna;
	private String cuidad;
	private Integer numeroDireccion;
	
	public Direcciones(){
		// Only JPA
	}
	
	public Direcciones(String direccion, String complemento, String codPostal, String comuna, String cuidad, Integer numeroDireccion) {
		this.direccion = direccion;
		this.complemento = complemento;
		this.codPostal = codPostal;
		this.comuna = comuna;
		this.cuidad = cuidad;
		this.numeroDireccion = numeroDireccion;
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

	public String getComuna() {
		return comuna;
	}

	public String getCuidad() {
		return cuidad;
	}

	public Integer getNumeroDireccion() {
		return numeroDireccion;
	}
}