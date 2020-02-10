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

import fr.yncrea.cir3.annuaire.domain.Country;
import fr.yncrea.cir3.annuaire.form.CountryForm;
import fr.yncrea.cir3.annuaire.repository.CountryRepository;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryRepository countries;
	
	/**
	 * Liste les pays en base
	 * 
	 * Répondra à l'url /country et /country/list
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping({"", "/list"})
	public String list(Model model) {
		model.addAttribute("countries", countries.findAll());
		
		return "country-list";
	}
	
	/**
	 * Formulaire d'ajout (affichage uniquement)
	 * @param model
	 * @return
	 */
	@GetMapping({"/add", "/edit/{id}"})
	public String add(@PathVariable(required=false) Long id, Model model) {
		CountryForm form = new CountryForm();
		model.addAttribute("country", form);
		
		if (id != null) {
			Country c = countries.findById(id).get();
			
			form.setId(c.getId());
			form.setName(c.getName());
		}
		
		return "country-add";
	}
	
	/**
	 * Formulaire d'ajout (traitement uniquement)
	 * @param form
	 * @return
	 */
	@PostMapping("/add")
	public String addForm(@Valid @ModelAttribute("country") CountryForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("country", form);
			return "country-add";
		}
		
		Country c = new Country();
		
		if (form.getId() != null) {
			c = countries.findById(form.getId()).get();
		}
		
		c.setName(form.getName());
		countries.save(c);
		
		return "redirect:/country/list";
	}
	
	@GetMapping("/delete/{id}")
	public String remove(@PathVariable Long id) {
		countries.deleteById(id);
		
		return "redirect:/country/list";
	}
}
