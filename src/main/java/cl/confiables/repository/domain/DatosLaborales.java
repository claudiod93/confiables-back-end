/**
 * 
 */
package cl.confiables.repository.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author claudioantonio
 *
 */
@Entity
public class DatosLaborales implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String correo;
	private String descripcion;
	private String categoria;

	@OneToMany(mappedBy = "datosLaborales")
	private Set<Experiencia> experiencia = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "direcciones_id", unique = true, nullable = true, insertable = true, updatable = true)
	private Direcciones direccion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "telefono_id", unique = true, nullable = true, insertable = true, updatable = true)
	private Telefono telefono;

	public DatosLaborales() { // Only JPA
	}

	public DatosLaborales(String correo, String descripcion, String categoria,
			Set<Experiencia> experiencia, Direcciones direccion,
			Telefono telefono) {
		this.correo = correo;
		this.categoria = categoria;
		this.experiencia = experiencia;
		this.direccion = direccion;
		this.telefono = telefono;

		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public String getCorreo() {
		return correo;
	}

	public String getCategoria() {
		return categoria;
	}

	public Set<Experiencia> getExperiencia() {
		return experiencia;
	}

	public Direcciones getDireccion() {
		return direccion;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}