/**
 * Interfejs GiftRepository - repozytorium prezentu
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.repositories;

import com.piekarscy.weddingplanner.models.Gift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfejs dla ogólnych operacji CRUD w repozytorium dla Gift.
 * CRUD to akronim słów:
 * - CREATE - dodanie prezentu,
 * - READ - odczytanie szczegółów prezentu,
 * - UPDATE - zmiana, modyfikacja informacji o prezencie,
 * - DELETE - usunięcie prezentu.
 *
 * Dodatkowo repozytorium zawiera metodę list() zwracającą listę wszystkich obiektów.
 */
@Repository
public interface GiftRepository extends CrudRepository<Gift, Integer> {

}