/**
 * Interfejs UserRepository - repozytorium użytkownika
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Repozytorium do odczytu i zapisu informacji o użytkownikach z wykorzystaniem Spring Data.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Adnotacja Query - Spring Data dzięki adnotacji udostępnia możliwość definiowania zapytania.
     * Dodatkowa metoda findByEmail - wyszukuje rekord w bazie danych na podstawie adresu email.
     */
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

}
