/**
 * Klasa GuestService - serwis gościa
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.services;

import com.piekarscy.weddingplanner.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piekarscy.weddingplanner.models.Guest;

import java.util.List;
import java.util.Optional;

/**
 * Adnotacja Service - ziarno utrzymuje logikę biznesową, jest używane w warstwie usług.
 */
@Service
public class GuestService {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
	 * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private GuestRepository guestRepository;

	/**
	 * Poniżej operacje CRUD z interfejsu GuestRepository.
	 * CRUD: CREATE, READ, UPDATE, DELETE
	 * Dodatkowo repozytorium zawiera metodę list() zwracającą listę wszystkich obiektów.
	 */
	public List<Guest> getAll() {
		return (List<Guest>) guestRepository.findAll();
	}

	/**
	 * Wybór jednego gościa.
	 */
	public Optional<Guest> getOne(Integer Id) {
		return guestRepository.findById(Id);
	}

	/**
	 * Dodanie nowego gościa.
	 */
	public void addNew(Guest guest) {
		guestRepository.save(guest);
	}

	/**
	 * Aktualizacja gościa.
	 */
	public void update(Guest guest) {
		guestRepository.save(guest);
	}

	/**
	 * Usuwanie gościa.
	 */
	public void delete(Integer Id) {
		guestRepository.deleteById(Id);
	}
 }
