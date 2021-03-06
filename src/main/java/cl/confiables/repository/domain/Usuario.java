/**
 * 
 */
package cl.confiables.repository.domain;

import java.io.Serializable;
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
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String imagen;

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
			DatosLaborales datosLaborales, Perfil perfil, Direcciones direccion, 
			String imagen) {

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
		this.imagen = imagen;
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
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setGenero(Long genero) {
		this.genero = genero;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public void setPremium(Long premium) {
		this.premium = premium;
	}

	public void setContratos(Set<Contrato> contratos) {
		this.contratos = contratos;
	}

	public void setDatosLaborales(DatosLaborales datosLaborales) {
		this.datosLaborales = datosLaborales;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public void setDireccion(Direcciones direccion) {
		this.direccion = direccion;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario
				+ ", contrasena=" + contrasena + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", mail=" + mail + ", genero="
				+ genero + ", fechaNacimiento=" + fechaNacimiento
				+ ", facebook=" + facebook + ", twitter=" + twitter
				+ ", linkedin=" + linkedin + ", youtube=" + youtube
				+ ", premium=" + premium + ", contratos=" + contratos
				+ ", datosLaborales=" + datosLaborales + ", perfil=" + perfil
				+ ", direccion=" + direccion + "]";
	}
}