/**
 * Interfejs RoleRepository - repozytorium roli
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repozytorium do odczytu i zapisu informacji o rolach z wykorzystaniem Spring Data.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    /**
     * Adnotacja Query - Spring Data dzięki adnotacji udostępnia możliwość definiowania zapytania.
     * Dodatkowa metoda findByName - wyszukuje rekord w bazie danych na podstawie nazwy roli.
     */
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    public Role findByName(String name);
}
