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
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	@JsonIgnore
	private String password;
	private String firstName;
	private String lastName;
	private String name;
	private String mail;
	private String gender;
	private Date birthDate;
	private String facebook;
	private String twitter;
	private String linkedin;
	private String youtube;
	
	@OneToMany(mappedBy = "user")
	private Set<Contracts> contracts = new HashSet<Contracts>();

	public User() {
	} // Only JPA

	public User(String username, String password, String firstName,
			String lastName, String name, String mail, String gender,
			Date birthDate, String facebook, String twitter, String linkedin,
			String youtube) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
		this.mail = mail;
		this.gender = gender;
		this.birthDate = birthDate;
		this.facebook = facebook;
		this.twitter = twitter;
		this.linkedin = linkedin;
		this.youtube = youtube;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	public String getGender() {
		return gender;
	}

	public Date getBirthDate() {
		return birthDate;
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

	public Set<Contracts> getContracts() {
		return contracts;
	}
}