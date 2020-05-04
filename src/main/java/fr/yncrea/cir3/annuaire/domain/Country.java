package fr.yncrea.cir3.annuaire.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Country {
	@Id @Column
	@GeneratedValue(generator = "seqCountry")
	@SequenceGenerator(name = "seqCountry", sequenceName = "seq_country")
	private Long id;
	
	@Column(length = 30, nullable = false)
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
