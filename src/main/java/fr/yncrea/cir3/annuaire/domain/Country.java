package fr.yncrea.cir3.annuaire.domain;

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
public class Country {
	@Id @Column
	@GeneratedValue(generator = "seqCountry")
	@SequenceGenerator(name = "seqCountry", sequenceName = "seq_country")
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String name;
}
