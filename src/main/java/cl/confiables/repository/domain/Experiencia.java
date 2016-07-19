/**
 * 
 */
package cl.confiables.repository.domain;

import java.io.Serializable;
import java.util.Date;

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
public class Experiencia implements Serializable{

	@GeneratedValue
	@Id
	private Long id;
	private String empresa;
	private Date fechaInicio;
	private Date fechaFin;
	private String cargo;
	private String descripcion;
	@JsonIgnore
	@ManyToOne
	private DatosLaborales datosLaborales;

	public Experiencia() {
	}

	public Experiencia(Long id, String empresa, Date fechaInicio,
			Date fechaFin, String cargo, String descripcion,
			DatosLaborales datosLaborales) {
		this.id = id;
		this.empresa = empresa;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
		this.descripcion = descripcion;
		this.datosLaborales = datosLaborales;
	}

	public Long getId() {
		return id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public DatosLaborales getDatosLaborales() {
		return datosLaborales;
	}
}