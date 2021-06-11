/**
 * Klasa MyBudget - mój budżet
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Adnotacja Entity - klasa MyBudget jest jednocześnie encją, czyli klasą,
 * której obiekty są zapisywane poprzez EntityManager do bazy danych.
 * Adnotacja Table - pozwala zarządzać nazwami tabel w bazie danych.
 */
@Entity
@Table(name = "mybudget")
public class MyBudget {

    /**
     * Zmienna Id - numer budżetu.
     * Przykład: 1.
     */
    @Id
    private Integer Id;

    /**
     * Zmienna value - wartość budżetu.
     * Przykład: 40000.
     */
    private Integer value;


    /**
     * Konstruktor domyślny bezparametrowy dla Hibernate.
     */
    public MyBudget() {
    }

    /**
     * Konstruktor zawierający:
     * @param id - numer budżetu
     * @param value - wartość budżetu
     */
    public MyBudget(Integer id, Integer value) {
        //super();
        Id = id;
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
        return "MyBudget [Id=" + Id + ", value=" + value +
                ']';
    }
}