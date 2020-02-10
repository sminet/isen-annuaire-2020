package fr.yncrea.cir3.annuaire.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyForm {
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String ceo;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate created;
}
