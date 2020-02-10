package fr.yncrea.cir3.annuaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.yncrea.cir3.annuaire.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
