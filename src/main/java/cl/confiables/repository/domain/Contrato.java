/**
 * 
 */
package cl.confiables.repository.domain;

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
public class Contrato {

	@Id
	@GeneratedValue
	private Long id;
	private Long proveedor;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private String clausulaTermino;
	private Long evaluacion;
	private Long valorServicio;
	private Long comision;
	private Long pendiente;
	private Long aceptado;
	private Long terminado;
	
	@ManyToOne
	@JsonIgnore
	private Usuario usuario;

	public Contrato() {
	} // Only JPA

	public Contrato(Long proveedor, String nombre, String descripcion,
			Date fechaInicio, Date fechaFin, String clausulaTermino,
			Long evaluacion, Long valorServicio, Long comision, Long pendiente,
			Long aceptado, Long terminado, Usuario usuario) {
		this.proveedor = proveedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.clausulaTermino = clausulaTermino;
		this.evaluacion = evaluacion;
		this.valorServicio = valorServicio;
		this.comision = comision;
		this.pendiente = pendiente;
		this.aceptado = aceptado;
		this.terminado = terminado;
		this.usuario = usuario;
	}
	
	public Contrato(Usuario usuario, Long proveedor, String nombre){
		this.usuario = usuario;
		this.proveedor = proveedor;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public Long getProveedor() {
		return proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public String getClausulaTermino() {
		return clausulaTermino;
	}

	public Long getEvaluacion() {
		return evaluacion;
	}

	public Long getValorServicio() {
		return valorServicio;
	}

	public Long getComision() {
		return comision;
	}

	public Long getPendiente() {
		return pendiente;
	}

	public Long getAceptado() {
		return aceptado;
	}

	public Long getTerminado() {
		return terminado;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}