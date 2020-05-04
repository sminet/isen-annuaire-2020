package fr.yncrea.cir3.annuaire.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Company {
	@Id	@Column
	@GeneratedValue(generator = "seqCompany")
	@SequenceGenerator(name = "seqCompany", sequenceName = "seq_company")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String ceo;
	
	@Column
	private LocalDate created;

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

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}
}
