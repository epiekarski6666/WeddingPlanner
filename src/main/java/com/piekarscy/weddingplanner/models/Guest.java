/**
 * Klasa Guest - gość
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Adnotacja Entity - klasa Guest jest jednocześnie encją, czyli klasą,
 * której obiekty są zapisywane poprzez EntityManager do bazy danych.
 * Adnotacja Table - pozwala zarządzać nazwami tabel w bazie danych.
 */
@Entity
@Table(name = "guest")
public class Guest {

    /**
     * Zmienna Id - numer gościa.
     * Adnotacja Id - encja posiada unikalny identyfikator ID,
     * czyli klucz główny tabeli "guest". Numeracja automatyczna.
     * Przykład: 1.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    /**
     * Zmienna name - nazwa gościa.
     * Przykład: "Robert Lewandowski".
     */
    private String name;

    /**
     * Zmienna status - status gościa.
     * Przykład: "zaproszony".
     */
    private String status = "Zaprosić";

    /**
     * Enum z możliwymi statusami dla gości.
     */
    public static enum StatusGuest{
        HOST("Organizator"),
        INVITE("Zaprosić"),
        CONFIRMED("Potwierdzone"),
        UNCONFIRMED("Niepotwierdzone");

        /**
         * Zmienna status3 do wyświetlania czytelnej formy enuma.
         */
        public final String status3;

        /**
         * Kontruktor enuma StatusGuest
         * @param status3 - wyświetla czytelną formę statusu.
         */
        StatusGuest(String status3){
            this.status3 = status3;
        }

        /**
         * Getter do pobrania wartości pola.
         */
        public String getStatus3() {
            return status3;
        }
    }
    /**
     * Adnotacja OneToMany - relacja w bazie danych: jeden gość dla wielu prezentów.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guest")
    private Set<Gift> gifts = new HashSet<>();


    /**
     * Konstruktor domyślny bezparametrowy dla Hibernate.
     * W celu utworzenia instancji encji, Hibernate używa metody newInstance(), która działa
     * tylko z domyślnym konstruktorem.
     */
    public Guest() {
    }

    /**
     * Konstruktor zawierający:
     * @param id - numer gościa
     * @param name - nazwę gościa
     * @param status - status gościa
     * @param gifts - prezenty przypisane do gościa
     */
    public Guest(Integer id, String name, String status, Set<Gift> gifts) {
        super();
        Id = id;
        this.name = name;
        this.status = status;
        if(gifts != null) {
            this.gifts = gifts;
        }
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Nadpisana metoda toString służy do zwracania tekstowej reprezentacji obiektu.
     */
    @Override
    public String toString() {
        return "Guest{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}