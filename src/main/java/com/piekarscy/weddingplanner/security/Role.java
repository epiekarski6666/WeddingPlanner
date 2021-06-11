/**
 * Klasa Role - role w aplikacji: Admin, User
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;

import javax.persistence.*;


/**
 * Adnotacja Entity - obiekty są zapisywane poprzez EntityManager do bazy danych.
 * Adnotacja Table - pozwala zarządzać nazwami tabel w bazie danych.
 */
@Entity
@Table(name = "roles")
public class Role {

    /**
     * Zmienna Id - numer roli.
     * Adnotacja Id - encja posiada unikalny identyfikator ID,
     * czyli klucz główny tabeli "roles". Numeracja automatyczna.
     * Przykład: 1.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Zmienna name - nazwa. Wartość nie może być pusta.
     * Przykład: "Admin".
     */
    @Column(nullable = false, length = 45)
    private String name;

    /**
     * Konstruktor domyślny bezparametrowy dla Hibernate.
     */
    public Role() {
    }

    /**
     * Konstruktor zawierający:
     * @param id - numer roli
     */
    public Role(Long id) {
        this.id = id;
    }

    /**
     * Konstruktor zawierający:
     * @param name - nazwę roli
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Konstruktor zawierający:
     * @param id - numer roli
     * @param name - nazwę roli
     */
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Nadpisana metoda toString służy do zwracania tekstowej reprezentacji obiektu.
     */
    @Override
    public String toString() {
        return this.name;
    }
}
