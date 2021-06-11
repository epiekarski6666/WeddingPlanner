/**
 * Interfejs TaskRepository - repozytorium zadania
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.piekarscy.weddingplanner.models.Task;

/**
 * Interfejs dla ogólnych operacji CRUD w repozytorium dla Task.
 * CRUD to akronim słów:
 * - CREATE - dodanie zadania,
 * - READ - odczytanie szczegółów zadania,
 * - UPDATE - zmiana, modyfikacja informacji o zadaniu,
 * - DELETE - usunięcie zadania.
 *
 * Dodatkowo repozytorium zawiera metodę list() zwracającą listę wszystkich obiektów.
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
