/**
 * Interfejs GuestRepository - repozytorium gościa
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.repositories;

import com.piekarscy.weddingplanner.models.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfejs dla ogólnych operacji CRUD w repozytorium dla Guest.
 * CRUD to akronim słów:
 * - CREATE - dodanie gościa,
 * - READ - odczytanie szczegółów gościa,
 * - UPDATE - zmiana, modyfikacja informacji o gościu,
 * - DELETE - usunięcie gościa.
 *
 * Dodatkowo repozytorium zawiera metodę list() zwracającą listę wszystkich obiektów.
 */
@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {

}