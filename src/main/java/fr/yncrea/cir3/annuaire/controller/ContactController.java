package fr.yncrea.cir3.annuaire.controller;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.yncrea.cir3.annuaire.domain.Contact;
import fr.yncrea.cir3.annuaire.domain.Country;
import fr.yncrea.cir3.annuaire.form.ContactForm;
import fr.yncrea.cir3.annuaire.repository.CompanyRepository;
import fr.yncrea.cir3.annuaire.repository.ContactRepository;
import fr.yncrea.cir3.annuaire.repository.CountryRepository;

@Controller
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ContactRepository contacts;
	
	@Autowired
	private CountryRepository countries;
	
	@Autowired
	private CompanyRepository companies;

	@GetMapping({ "", "/list" })
	public String list(Model model, @PageableDefault(page=0, size=5) Pageable pageable) {
		model.addAttribute("contacts", contacts.findAllAndFetch());

		return "contact-list";
	}

	@GetMapping({ "/add", "edit/{id}" })
	public String add(@PathVariable(required = false) Long id, Model model) {
		ContactForm form = new ContactForm();
		model.addAttribute("contact", form);
		model.addAttribute("countries", countries.findAll());
		model.addAttribute("companies", companies.findAll());

		if (id != null) {
			Contact c = contacts.findById(id).get();

			form.setId(c.getId());
			form.setName(c.getName());
			form.setFirstname(c.getFirstname());
			form.setEmail(c.getEmail());
			
			if (c.getCountry() != null) {
				form.setCountry(c.getCountry().getId());
			}
			
			form.setCompanies(c.getCompanies().stream().map(e -> e.getId()).collect(Collectors.toSet()));
		}

		return "contact-add";
	}

	@PostMapping("/add")
	public String addForm(@Valid @ModelAttribute("contact") ContactForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("contact", form);
			return "contact-add";
		}

		Contact c = new Contact();

		if (form.getId() != null) {
			c = contacts.findById(form.getId()).get();
		}

		c.setName(form.getName());
		c.setFirstname(form.getFirstname());
		c.setEmail(form.getEmail());
		
		if (form.getCountry() != null) {
			Optional<Country> country = countries.findById(form.getCountry());
			if (!country.isPresent()) {
				throw new RuntimeException("Country not found");
			}
			
			c.setCountry(country.get());
		}
		
		c.setCompanies(form.getCompanies().stream().map(e -> companies.findById(e).get()).collect(Collectors.toSet()));

		contacts.save(c);

		return "redirect:/contact/list";
	}

	@GetMapping("/delete/{id}")
	public String remove(@PathVariable Long id) {
		contacts.deleteById(id);

		return "redirect:/contact/list";
	}
	
	@GetMapping("/search")
	public String search() {
		return "contact-search";
	}
}
