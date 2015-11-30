/**
 * 
 */
package cl.confiables.repository.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author cadiazc
 *
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	private String nombreUsuario;
	@JsonIgnore
	private String contrasena;
	private String nombres;
	private String apellidos;
	private String mail;
	private Long genero;
	private Date fechaNacimiento;
	private String facebook;
	private String twitter;
	private String linkedin;
	private String youtube;
	private Long premium;

	@OneToMany(mappedBy = "usuario")
	private Set<Contrato> contratos = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dato_laborales_id", unique = true, nullable = true, insertable = true, updatable = true)
	private DatosLaborales datosLaborales;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "perfil_id", unique = true, nullable = true, insertable = true, updatable = true)
	private Perfil perfil;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "direcciones_id", unique = true, nullable = true, insertable = true, updatable = true)
	private Direcciones direccion;

	public Usuario() {
	} // Only JPA

	// For Login
	public Usuario(String nombreUsuario, String mail, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.mail = mail;
	}

	public Usuario(String nombreUsuario, String contrasena, String nombres,
			String apellidos, String mail, Long genero, Date fechaNacimiento,
			String facebook, String twitter, String linkedin, String youtube,
			Long premium, Set<Contrato> contratos,
			DatosLaborales datosLaborales, Perfil perfil, Direcciones direccion) {

		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.mail = mail;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.facebook = facebook;
		this.twitter = twitter;
		this.linkedin = linkedin;
		this.youtube = youtube;
		this.premium = premium;
		this.contratos = contratos;
		this.datosLaborales = datosLaborales;
		this.perfil = perfil;
		this.direccion = direccion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getMail() {
		return mail;
	}

	public Long getGenero() {
		return genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getFacebook() {
		return facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public String getYoutube() {
		return youtube;
	}

	public Long getPremium() {
		return premium;
	}

	public Set<Contrato> getContratos() {
		return contratos;
	}

	public DatosLaborales getDatosLaborales() {
		return datosLaborales;
	}

	public Long getId() {
		return id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public Direcciones getDireccion() {
		return direccion;
	}

}