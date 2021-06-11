/**
 * Klasa Task - zadanie
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.models;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Adnotacja Entity - klasa Task jest jednocześnie encją, czyli klasą,
 * której obiekty są zapisywane poprzez EntityManager do bazy danych.
 * Adnotacja Table - pozwala zarządzać nazwami tabel w bazie danych.
 */
@Entity
@Table(name = "task")
public class Task {

	/**
	 * Zmienna Id - numer zadania.
	 * Adnotacja Id - encja posiada unikalny identyfikator ID,
	 * czyli klucz główny tabeli "task". Numeracja automatyczna.
	 * Przykład: 1.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	/**
	 * Zmienna name - nazwa zadania.
	 * Przykład: "kupić suknię".
	 */
	private String name;

	/**
	 * Zmienna status - status zadania.
	 * Przykład: "w trakcie".
	 */
	private String status = "Nowy";

	/**
	 * Enum ze statusami zadań.
	 */
	public static enum Status{
		NEW("Nowy"),
		TO_DO("Do zrobienia"),
		IN_PROGRESS("W trakcie"),
		DONE("Zrobione");

		/**
		 * Zmienna status2 służy do wyświetlania czytelnej formy statusów.
		 */
		public final String status2;

		/**
		 * Konstruktor dla enumu Status.
		 */
		Status(String status2){
			this.status2 = status2;
		}
	}

	/**
	 * Komentarz do zadania.
	 */
	private String comment;

	/**
	 * Zmienna updatedOn - data ostatniej aktualizacji zadania.
	 * Adnotacja DateTimeFormat - deklaruje, że parametr pola lub metody powinien być
	 * sformatowany jako data lub godzina. W poniższym przypadku zastosowano niestandardowe formatowanie rok-miesiąc-dzień.
	 * Przykład: "2020-06-05".
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String updatedOn;

	/**
	 * Konstruktor domyślny bezparametrowy dla Hibernate.
	 */
	public Task() {
	}

	/**
	 * Konstruktor zawierający:
	 * @param id - numer zadania
	 * @param name - nazwę zadania
	 * @param status - status zadania
	 * @param comment - komentarz do zadania
	 * @param updatedOn - ostatnią datę aktualizacji zadania
	 */
	public Task(Integer id, String name, String comment, String updatedOn, String status) {
		super();
		Id = id;
		this.name = name;
		this.status = status;
		this.comment = comment;
		this.updatedOn = updatedOn;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * Nadpisana metoda toString służy do zwracania tekstowej reprezentacji obiektu.
	 */
	@Override
	public String toString() {
		return "Task [Id=" + Id + ", name=" + name + ", comment=" + comment
				+ ", updatedOn=" + updatedOn + ", status=" + status + "]";
	}
}
