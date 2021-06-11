/**
 * Interfejs MyBudgetRepository - repozytorium mojego budżetu
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.repositories;

import com.piekarscy.weddingplanner.models.MyBudget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfejs dla ogólnych operacji CRUD (create, read, update, delete) w repozytorium dla Guest.
 */
@Repository
public interface MyBudgetRepository extends CrudRepository<MyBudget, Integer> {

}