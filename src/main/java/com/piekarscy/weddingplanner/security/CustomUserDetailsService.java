/**
 * Klasa CustomUserDetailsService - niestandardowy serwis danych użytkownika
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Implementacja własnego systemu uwierzytelniania przez adres e-mail.
 */
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
     * Wstrzykiwanie zależności poprzez pole.
     */
    @Autowired
    private UserRepository repo;

    /**
     * Nadpisana metoda z interfejsu UserDetailsService. Wyszukiwanie użytkownika przez adres e-mail.
     * Jeśli użytkownik o wskazanym adresie e-mail nie istnieje, aplikacja rzuca wyjątek.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
