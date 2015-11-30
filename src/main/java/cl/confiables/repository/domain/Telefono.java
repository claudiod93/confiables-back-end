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
public class Telefono {

	@Id
	@GeneratedValue
	private Long id;
	private Integer codPais;
	private Integer codCuidad;
	private Integer numero;
	
	public Telefono(){
		//Only JPA
	}
	
	public Long getId() {
		return id;
	}
	public Integer getCodPais() {
		return codPais;
	}
	public Integer getCodCuidad() {
		return codCuidad;
	}
	public Integer getNumero() {
		return numero;
	}
	
	
}
