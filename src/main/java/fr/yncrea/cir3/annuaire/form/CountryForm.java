package fr.yncrea.cir3.annuaire.form;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryForm {
	private Long id;
	
	@Size(min = 2, max = 20)
	private String name;
}
