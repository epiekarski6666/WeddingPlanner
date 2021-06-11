/**
 * Klasa TaskService - serwis zadania
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piekarscy.weddingplanner.models.Task;
import com.piekarscy.weddingplanner.repositories.TaskRepository;

/**
 * Adnotacja Service - ziarno utrzymuje logikę biznesową, jest używane w warstwie usług.
 */
@Service
public class TaskService {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
	 * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private TaskRepository taskRepository;

	/**
	 * Poniżej operacje CRUD z interfejsu TaskRepository.
	 * CRUD: CREATE, READ, UPDATE, DELETE
	 * Dodatkowo repozytorium zawiera metodę list() zwracającą listę wszystkich obiektów.
	 */
	public List<Task> getAll() {
		return (List<Task>) taskRepository.findAll();
	}

	/**
	 * Wybór jednego zadania.
	 */
	public Optional<Task> getOne(Integer Id) {
		return taskRepository.findById(Id);
	}

	/**
	 * Dodanie nowego zadania.
	 */
	public void addNew(Task task) {
		taskRepository.save(task);
	}

	/**
	 * Aktualizacja zadania.
	 */
	public void update(Task task) {
		taskRepository.save(task);
	}

	/**
	 * Usuwanie zadania.
	 */
	public void delete(Integer Id) {
		taskRepository.deleteById(Id);
	}
 }
