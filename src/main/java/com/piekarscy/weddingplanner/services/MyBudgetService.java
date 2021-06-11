/**
 * Klasa MyBudgetService - serwis mojego budżetu
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.services;

import com.piekarscy.weddingplanner.models.MyBudget;
import com.piekarscy.weddingplanner.repositories.MyBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Adnotacja Service - ziarno utrzymuje logikę biznesową, jest używane w warstwie usług.
 */
@Service
public class MyBudgetService {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private MyBudgetRepository myBudgetRepository;

	/**
	 * Poniżej operacje CRUD: CREATE, READ, UPDATE, DELETE
	 * Dodatkowo repozytorium zawiera metodę list() zwracającą listę wszystkich obiektów.
	 */
	public List<MyBudget> getAll() {
		return (List<MyBudget>) myBudgetRepository.findAll();
	}

	/**
	 * Wybór jednego budżetu.
	 */
	public Optional<MyBudget> getOne(Integer Id) {
		return myBudgetRepository.findById(Id);
	}

	/**
	 * Dodanie nowego budżetu.
	 */
	public void addNew(MyBudget mybudget) {
		myBudgetRepository.save(mybudget);
	}

	/**
	 * Aktualizacja budżetu.
	 */
	public void update(MyBudget mybudget) {
		myBudgetRepository.save(mybudget);
	}

	/**
	 * Usuwanie budżetu.
	 */
	public void delete(Integer Id) {
		myBudgetRepository.deleteById(Id);
	}
 }
