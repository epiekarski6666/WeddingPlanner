/**
 * Klasa Gift - prezent
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.models;

import javax.persistence.*;

/**
 * Adnotacja Entity - klasa Gift jest jednocześnie encją, czyli klasą,
 * której obiekty są zapisywane poprzez EntityManager do bazy danych.
 * Adnotacja Table - pozwala zarządzać nazwami tabel w bazie danych.
 */
@Entity
@Table(name = "gift")
public class Gift {

    /**
     * Zmienna Id - numer prezentu.
     * Adnotacja Id - encja posiada unikalny identyfikator ID,
     * czyli klucz główny tabeli "gift". Numeracja automatyczna.
     * Przykład: 1.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    /**
     * Zmienna name - nazwa prezentu.
     * Przykład: "wino".
     */
    private String name;

    /**
     * Zmienna display - odpowiedzialna za wyświetlanie imienia gościa,
     * któremu zostało przydzielone kupno prezentu.
     * Zmienna domyślnie przybiera wartość null - można nie przydzielić
     * kupna wybranego prezentu do gościa.
     * Przykład: "Ivan Komarenko".
     */
    private String display = "";

    /**
     * Adnotacja ManyToOne - relacja w bazie danych: wiele prezentów do jednego gościa.
     * Adnotacja PrimaryKeyJoinColumn - określa kolumnę klucza podstawowego, która jest używana
     * jako klucz obcy do dołączenia do innej tabeli.
     */
    @ManyToOne(cascade= CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Guest guest;

    /**
     * Konstruktor domyślny bezparametrowy dla Hibernate.
     * W celu utworzenia instancji encji, Hibernate używa metody newInstance(), która działa
     * tylko z domyślnym konstruktorem.
     */
    public Gift() {
    }

    /**
     * Konstruktor zawierający:
     * @param id - numer prezentu
     * @param name - nazwę prezentu
     * @param display - zmienną wyświetlającą imię gościa,
     *                  któremu zostało przydzielone kupno wybranego prezentu
     */
    public Gift(Integer id, String name, String display) {
        Id = id;
        this.name = name;
        this.display = display;
    }

    /**
     * Gettery i settery do powyższych zmiennych.
     * Metody pozwalające na pobranie lub zmianę wartości prywatnego
     * pola klasy z zewnątrz.
     */
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * Nadpisana metoda toString służy do zwracania tekstowej reprezentacji obiektu.
     */
    @Override
    public String toString() {
        return "Gift{" +
                "Id=" + Id +
                ", name='" + name +
                ", display='" + display + '\'' +
                '}';
    }
}