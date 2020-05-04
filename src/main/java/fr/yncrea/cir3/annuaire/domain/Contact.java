package fr.yncrea.cir3.annuaire.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	@Id @Column
	@GeneratedValue(generator = "seqUser")
	@SequenceGenerator(name = "seqUser", sequenceName = "seq_user")
	private Long id;

	@Column(length = 40, nullable = false)
	private String firstname;

	@Column(length = 40, nullable = false)
	private String name;

	@Column(name = "mail", length = 80, nullable = false, unique = true)
	private String email;
	
	@ManyToOne
	private Country country;
	
	@ManyToMany
	private Set<Company> companies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
}
