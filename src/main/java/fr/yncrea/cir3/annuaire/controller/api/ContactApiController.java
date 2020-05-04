package fr.yncrea.cir3.annuaire.controller.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.yncrea.cir3.annuaire.domain.Contact;
import fr.yncrea.cir3.annuaire.repository.ContactRepository;

@RestController
@RequestMapping("/api/contact")
public class ContactApiController {
	
	@Autowired
	private ContactRepository contacts;
	
	@GetMapping({"", "/"})
	public Set<Contact> search(@RequestParam String q) {
		return contacts.findByEmailLike("%" + q + "%");
	}
}
