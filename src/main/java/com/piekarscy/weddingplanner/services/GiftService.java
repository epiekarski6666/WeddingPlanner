/**
 * Klasa GiftService - serwis prezentu
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.services;

import com.piekarscy.weddingplanner.models.Gift;
import com.piekarscy.weddingplanner.repositories.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Adnotacja Service - ziarno utrzymuje logikę biznesową, jest używane w warstwie usług.
 */
@Service
public class GiftService {

    /**
     * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
     * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
     * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
     * Wstrzykiwanie zależności poprzez pole.
     */
    @Autowired
    private GiftRepository giftRepository;

    /**
     * Poniżej operacje CRUD z interfejsu GiftRepository.
     * CRUD: CREATE, READ, UPDATE, DELETE
     * Dodatkowo repozytorium zawiera metodę list() zwracającą listę wszystkich obiektów.
     */
    public List<Gift> getAll() {
        return (List<Gift>) giftRepository.findAll();
    }

    /**
     * Wybór jednego prezentu.
     */
    public Optional<Gift> getOne(Integer Id) {
        return giftRepository.findById(Id);
    }

    /**
     * Dodanie nowego prezentu.
     */
    public void addNew(Gift gift) {
        giftRepository.save(gift);
    }

    /**
     * Aktualizacja prezentu.
     */
    public void update(Gift gift) {
        giftRepository.save(gift);
    }

    /**
     * Usuwanie prezentu.
     */
    public void delete(Integer Id) {
        giftRepository.deleteById(Id);
    }
}