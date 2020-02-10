package fr.yncrea.cir3.annuaire.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = -6244318455911809051L;

	@Id @Column
	@GeneratedValue(generator = "seqAuthority")
	@SequenceGenerator(name = "seqAuthority", sequenceName = "seq_authority")
	private Long id;
	
	private String authority;
}
