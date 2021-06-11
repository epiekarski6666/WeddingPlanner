/**
 * Interfejs ExpencesRepository - repozytorium wydatków
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.repositories;

import com.piekarscy.weddingplanner.models.Expences;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfejs dla ogólnych operacji CRUD (create, read, update, delete) w repozytorium dla Expences.
 */
@Repository
public interface ExpencesRepository extends CrudRepository<Expences, Integer> {

}