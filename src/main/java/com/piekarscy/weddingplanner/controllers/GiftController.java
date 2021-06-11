/**
 * Klasa GiftController - kontroler prezentu
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.controllers;

import com.piekarscy.weddingplanner.models.Gift;

import com.piekarscy.weddingplanner.models.Guest;
import com.piekarscy.weddingplanner.services.GiftService;
import com.piekarscy.weddingplanner.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Adnotacja Controller - stereotyp dla warstw prezentacji. Klasa obsługuje żądania HTTP.
 * Po otrzymaniu żądania uruchamiana jest metoda,
 * której mapowanie odpowiada ścieżce określonej w wysłanym żądaniu.
 * Adnotacja RequestMapping nad nazwą klasy - wszystkie poniższe mapowania zawierają mapowanie "/gifts" i kolejne własne mapowanie.
 * Przykład: "/gifts/getAll".
 */
@Controller
@RequestMapping("/gifts")
public class GiftController {

    /**
     * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
     * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
     * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
     * Wstrzykiwanie zależności poprzez pole.
     */
        @Autowired
        private GiftService giftService;

        @Autowired
        private GuestService guestService;

        /**
         * Adnotacja RequestMapping - adnotacja używana do mapowania żądań na metody kontrolerów.
         * Mapowanie listy wyświetlającej wszystkie prezenty.
         */
        @RequestMapping("/getAll")
        public String getAll(Model model) {
            List<Gift> gifts = giftService.getAll();
            model.addAttribute("gifts", gifts);
            return "gift/gift";
        }

    /**
     * Adnotacja ModelAttribute - wiąże parametr metody lub wartość zwracaną przez metodę
     * z nazwanego atrybutu modelu, uwidocznionego w widoku internetowym.
     * Wyświetla listę rozwijalną wszystkich gości na etapie edycji prezentu.
     */
        @ModelAttribute("guests")
        public List<Guest> populateOwners(){
            return guestService.getAll();
        }

    /**
     * Adnotacja ResponseBody - wiąże wartość zwracaną przez metodę z treścią odpowiedzi internetowej.
     * Mapowanie wyboru jednego prezentu.
     */
        @RequestMapping("/getOne")
        @ResponseBody
        public Optional<Gift> getOne(Integer Id)
        {
            return giftService.getOne(Id);
        }

    /**
     * Adnotacja PostMapping - to wyspecjalizowana wersja adnotacji @RequestMapping.
     * Działa jako skrót do @RequestMapping(method = RequestMethod.POST).
     * Mapowanie dodawania nowego prezentu.
     * Następnie przekierowuje na wyświetlanie listy wszystkich prezentów.
     */
        @PostMapping(value="/addNew")
        public String addNew(Gift gift) {

            giftService.addNew(gift);
            return "redirect:/gifts/getAll";
        }

    /**
     * Mapowanie edycji prezentu.
     * Następnie przekierowuje na wyświetlanie listy wszystkich prezentów.
     */
        @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
        public String update(Gift gift) {
            giftService.update(gift);
            return "redirect:/gifts/getAll";
        }

    /**
     * Mapowanie usuwania prezentu.
     * Następnie przekierowuje na wyświetlanie listy wszystkich prezentów.
     */
        @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
        public String delete(Integer Id) {
            giftService.delete(Id);
            return "redirect:/gifts/getAll";
        }
}
