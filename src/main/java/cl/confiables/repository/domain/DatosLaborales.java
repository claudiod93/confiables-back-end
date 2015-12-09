/**
 * 
 */
package cl.confiables.repository.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author claudioantonio
 *
 */
@Entity
public class DatosLaborales {

	@Id
	@GeneratedValue
	private Long id;
	private String correo;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "categoria_id", unique = true, nullable = true, insertable = true, updatable = true)
	private Long categoria;
	
	@OneToMany(mappedBy = "datosLaborales")
	private Set<Experiencia> experiencia = new HashSet<>();

	public DatosLaborales() { // Only JPA
	}

	public DatosLaborales(String correo, Long categoria, Set<Experiencia> experiencia) {
		this.correo = correo;
		this.categoria = categoria;
		this.experiencia = experiencia;
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

	public Set<Experiencia> getExperiencia() {
		return experiencia;
	}
}