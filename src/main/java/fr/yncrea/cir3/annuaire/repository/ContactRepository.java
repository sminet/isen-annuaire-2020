package fr.yncrea.cir3.annuaire.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.yncrea.cir3.annuaire.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	@Query("select c from Contact c left join fetch c.country left join fetch c.companies")
	public Set<Contact> findAllAndFetch();
	
	@Query(value="select c from Contact c left join fetch c.country left join fetch c.companies",
			countQuery = "select count(contact) from Contact contact")
	public Page<Contact> findAllAndFetch(Pageable pageable);
}

