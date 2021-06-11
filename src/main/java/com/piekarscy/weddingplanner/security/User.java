/**
 * Klasa User - użytkownik
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Adnotacja Entity - klasa User jest jednocześnie encją, czyli klasą,
 * której obiekty są zapisywane poprzez EntityManager do bazy danych.
 * Adnotacja Table - pozwala zarządzać nazwami tabel w bazie danych.
 *
 * Klasa User to model danych, który jest wykorzystywany w aplikacji i Spring Security.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Zmienna Id - numer gościa.
     * Adnotacja Id - encja posiada unikalny identyfikator ID,
     * czyli klucz główny tabeli "guest".
     * Adnotacja GeneratedValue - wartość klucza podstawowego jest generowana automatycznie.
     * Parametr strategy - wartości są automatycznie zwiększane.
     * Przykład: 1.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Zmienna email - adres e-mail użytkownika. Wartość unikatowa. Wartość nie może być pusta.
     * E-mail jest jednocześnie loginem użytkownika.
     * Przykład: "test@test.pl".
     */
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    /**
     * Zmienna password - hasło. Wartość nie może być pusta.
     * Przykład: "password".
     */
    @Column(nullable = false, length = 64)
    private String password;

    /**
     * Zmienna firstName - imię. Wartość nie może być pusta.
     * Przykład: "Martyna".
     */
    @Column(nullable = false, length = 20)
    private String firstName;

    /**
     * Zmienna lastName - nazwisko. Wartość nie może być pusta.
     * Przykład: "Piekarska".
     */
    @Column(nullable = false, length = 20)
    private String lastName;


    /**
     * Adnotacja ManyToMany - wiele użytkowników do wielu ról
     * Lączenie kolumn users i roles w kolejną tabelę zawierającą id użytkownika i id roli.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    /**
     * Zestaw ról dla użytkownika.
     */
    private Set<Role> roles = new HashSet<>();


    /**
     * Gettery i settery do powyższych zmiennych.
     * Metody pozwalające na pobranie lub zmianę wartości prywatnego
     * pola klasy z zewnątrz.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

}