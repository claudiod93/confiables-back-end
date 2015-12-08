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
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "categoria_id", unique = true, nullable = true, insertable = true, updatable = true)
	private Long categoria;

	public DatosLaborales() { // Only JPA
	}

	public DatosLaborales(String correo, Long categoria) {
		this.correo = correo;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public String getCorreo() {
		return correo;
	}

	public Long getCategoria() {
		return categoria;
	}
}