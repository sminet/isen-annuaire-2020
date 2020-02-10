package fr.yncrea.cir3.annuaire.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
