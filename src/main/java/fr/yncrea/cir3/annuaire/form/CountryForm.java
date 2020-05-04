package fr.yncrea.cir3.annuaire.form;

import javax.validation.constraints.Size;

public class CountryForm {
	private Long id;
	
	@Size(min = 2, max = 20)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
