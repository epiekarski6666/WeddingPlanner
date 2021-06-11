/**
 * Klasa CustomUserDetails - niestandardowe dane użytkownika
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Klasa definiująca niestandardowe dane użytkownika, implementuje interfejs UserDetails.
 */
public class CustomUserDetails implements UserDetails {

    /**
     * Zmienna user - użytkownik.
     */
    private User user;

    /**
     * Konstruktor z parametrem użytkownika.
     */
    public CustomUserDetails(User user) {
        this.user = user;
    }

    /**
     * Nadpisane metody z interfejsu UserDetails.
     * Metoda zwracająca uprawnienia przyznane użytkownikowi.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }

    /**
     * Metoda zwracająca hasło użyte do uwierzytelnienia użytkownika.
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Metoda zwracająca nazwę użytkownika używaną do uwierzytelniania użytkownika.
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Metoda wskazuje, czy konto użytkownika wygasło.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Metoda wskazuje, czy użytkownik jest zablokowany czy odblokowany.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Metoda wskazuje, czy poświadczenia użytkownika (hasło) wygasły.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Metoda wskazuje, czy użytkownik jest włączony czy wyłączony.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Metoda wyświetlająca imię i nazwisko użytkownika.
     */
    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

}
