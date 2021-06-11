/**
 * Klasa ExpencesService - serwis wydatków
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.services;

import com.piekarscy.weddingplanner.models.Expences;
import com.piekarscy.weddingplanner.repositories.ExpencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Adnotacja Service - ziarno utrzymuje logikę biznesową, jest używane w warstwie usług.
 */
@Service
public class ExpencesService {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private ExpencesRepository expencesRepository;

	/**
	 * Poniżej operacje CRUD: CREATE, READ, UPDATE, DELETE
	 * Dodatkowo repozytorium zawiera metodę list() zwracającą listę wszystkich obiektów.
	 */
	public List<Expences> getAll() {
		return (List<Expences>) expencesRepository.findAll();
	}

	/**
	 * Wybór jednego wydatku.
	 */
	public Optional<Expences> getOne(Integer Id) {
		return expencesRepository.findById(Id);
	}

	/**
	 * Dodanie nowego wydatku.
	 */
	public void addNew(Expences expences) {
		expencesRepository.save(expences);
	}

	/**
	 * Aktualizacja wydatku.
	 */
	public void update(Expences expences) {
		expencesRepository.save(expences);
	}

	/**
	 * Usuwanie wydatku.
	 */
	public void delete(Integer Id) {
		expencesRepository.deleteById(Id);
	}
 }
