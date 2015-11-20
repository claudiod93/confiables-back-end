/**
 * 
 */
package cl.confiables.repository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private Set<Contrato> contratos = new HashSet<Contrato>();

	public Usuario() {
	} // Only JPA
	
	// For Login
	public Usuario(String nombreUsuario, String mail, String contrasena){
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.mail = mail;
	}
	
	public Usuario(String nombreUsuario, String contrasena, String nombres,
			String apellidos, String mail, Long genero, Date fechaNacimiento,
			String facebook, String twitter, String linkedin, String youtube,
			Long premium, Set<Contrato> contratos) {
		
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

	
}