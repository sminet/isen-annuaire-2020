package fr.yncrea.cir3.annuaire.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.yncrea.cir3.annuaire.domain.Company;
import fr.yncrea.cir3.annuaire.form.CompanyForm;
import fr.yncrea.cir3.annuaire.repository.CompanyRepository;

@Controller
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyRepository companies;

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		model.addAttribute("companies", companies.findAll());

		return "company-list";
	}

	@GetMapping({"/add", "edit/{id}"})
	public String add(@PathVariable(required=false) Long id, Model model) {
		CompanyForm form = new CompanyForm();
		model.addAttribute("company", form);
		
		if (id != null) {
			Company c = companies.findById(id).get();
			
			form.setId(c.getId());
			form.setName(c.getName());
			form.setCeo(c.getCeo());
			form.setCreated(c.getCreated());
		}

		return "company-add";
	}

	@PostMapping("/add")
	public String addForm(@Valid @ModelAttribute("company") CompanyForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("country", form);
			return "company-add";
		}
		
		Company c = new Company();
		
		if (form.getId() != null) {
			c = companies.findById(form.getId()).get();
		}
		
		c.setName(form.getName());
		c.setCreated(form.getCreated());
		c.setCeo(form.getCeo());
		
		companies.save(c);

		return "redirect:/company/list";
	}
	
	@GetMapping("/delete/{id}")
	public String remove(@PathVariable Long id) {
		companies.deleteById(id);
		
		return "redirect:/company/list";
	}
}
