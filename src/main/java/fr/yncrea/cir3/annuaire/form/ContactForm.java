package fr.yncrea.cir3.annuaire.form;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
