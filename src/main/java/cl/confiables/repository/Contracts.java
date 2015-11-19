/**
 * 
 */
package cl.confiables.repository;

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
public class Contracts {

	@Id
	@GeneratedValue
	private Long id;
	private String provider;
	private String name;
	private String description;
	private Date startDate;
	private Date finalDate;
	private String termClause;
	private Long evalution;
	private Long serviceValue;
	private Long commission;
	
	@ManyToOne
	@JsonIgnore
	private User user;

	public Contracts() {
	} // Only JPA

	public Contracts(User user, String provider, String name){
		this.user = user;
		this.provider = provider;
		this.name = name;
	}
	
	public Contracts(User user, String provider, String name, String description,
			Date startDate, Date finalDate, String termClause, Long evalution,
			Long serviceValue, Long commission) {
		this.user = user;
		this.provider = provider;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.finalDate = finalDate;
		this.termClause = termClause;
		this.evalution = evalution;
		this.serviceValue = serviceValue;
		this.commission = commission;
	}

	public Long getId() {
		return id;
	}

	public String getProvider() {
		return provider;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public String getTermClause() {
		return termClause;
	}

	public Long getEvalution() {
		return evalution;
	}

	public Long getServiceValue() {
		return serviceValue;
	}

	public Long getCommission() {
		return commission;
	}

	@Override
	public String toString() {
		return "Contracts [id=" + id + ", provider=" + provider + ", name="
				+ name + ", description=" + description + ", startDate="
				+ startDate + ", finalDate=" + finalDate + ", termClause="
				+ termClause + ", evalution=" + evalution + ", serviceValue="
				+ serviceValue + ", commission=" + commission + "]";
	}
}