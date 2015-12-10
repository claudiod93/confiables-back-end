/**
 * 
 */
package cl.confiables.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author claudioantonio Este SLA no esta relacionado a nada, por el echo que
 *         seran las preguntas con el procentaje y el json de entrada sera el
 *         valor almacenado en los contratos
 *
 */
@Entity
public class Sla {

	@GeneratedValue
	@Id
	private Long id;
	private String nombre;
	private String descripcion;
	private Integer activo;

	public Sla() {
	}

	public Sla(Long id, String nombre, String descripcion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getActivo() {
		return activo;
	}
}