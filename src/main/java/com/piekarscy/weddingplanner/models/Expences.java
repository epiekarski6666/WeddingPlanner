/**
 * Klasa Expences - wydatki
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.models;

import javax.persistence.*;

/**
 * Adnotacja Entity - klasa Expences jest jednocześnie encją, czyli klasą,
 * której obiekty są zapisywane poprzez EntityManager do bazy danych.
 * Adnotacja Table - pozwala zarządzać nazwami tabel w bazie danych.
 */
@Entity
@Table(name = "expences")
public class Expences {

    /**
     * Zmienna Id - numer wydatku.
     * Adnotacja Id - encja posiada unikalny identyfikator ID,
     * czyli klucz główny tabeli "expences". Numeracja automatyczna.
     * Przykład: 1.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    /**
     * Zmienna name - nazwa wydatku.
     * Przykład: "Obrączki".
     */
    private String name;


    /**
     * Zmienna value - wysokość wydatku.
     * Przykład: "4000".
     */
    private Integer value;

    /**
     * Konstruktor domyślny bezparametrowy dla Hibernate.
     * W celu utworzenia instancji encji, Hibernate używa metody newInstance(), która działa
     * tylko z domyślnym konstruktorem.
     */
    public Expences() {
    }

    /**
     * Konstruktor zawierający:
     * @param id - numer wydatku
     * @param name - nazwę wydatku
     * @param value - kwotę wydatku
     */
    public Expences(Integer id, String name, Integer value) {
        super();
        Id = id;
        this.name = name;
        this.value = value;
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Nadpisana metoda toString służy do zwracania tekstowej reprezentacji obiektu.
     */
    @Override
    public String toString() {
        return "Expences{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}