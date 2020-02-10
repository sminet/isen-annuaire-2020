package fr.yncrea.cir3.annuaire.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	private List<Company> companies;
}
