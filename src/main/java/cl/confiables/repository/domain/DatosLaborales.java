/**
 * 
 */
package cl.confiables.repository.domain;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.HashSet;

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
	
	@OneToMany(mappedBy = "datosLaborles")
	private Set<Categoria> categorias = new HashSet<Categoria>();

	public DatosLaborales() { // Only JPA
	}

	public DatosLaborales(String correo, Set<Categoria> categorias) {
		this.correo = correo;
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public String getCorreo() {
		return correo;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}
}