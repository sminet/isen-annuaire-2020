package fr.yncrea.cir3.annuaire.form;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class ContactForm {
	private Long id;
	
	@Size(min = 0, max = 20)
	private String firstname;
	
	@Size(min = 0, max = 20)
	private String name;
	
	@Email
	private String email;
	
	private Long country;
	
	private Set<Long> companies;

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

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	public Set<Long> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Long> companies) {
		this.companies = companies;
	}
}
