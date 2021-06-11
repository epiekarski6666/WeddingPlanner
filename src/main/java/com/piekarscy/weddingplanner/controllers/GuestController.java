/**
 * Klasa GuestController - kontroler gościa
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.controllers;

import com.piekarscy.weddingplanner.models.Guest;

import com.piekarscy.weddingplanner.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 * Adnotacja Controller - stereotyp dla warstw prezentacji. Klasa obsługuje żądania HTTP.
 * Po otrzymaniu żądania uruchamiana jest metoda,
 * której mapowanie odpowiada ścieżce określonej w wysłanym żądaniu.
 * Adnotacja RequestMapping nad nazwą klasy - wszystkie poniższe mapowania zawierają mapowanie "/guests" i kolejne własne mapowanie.
 * Przykład: "/guests/getAll".
 */
@Controller
@RequestMapping("/guests")
public class GuestController {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
	 * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private GuestService guestService;

	/**
	 * Adnotacja RequestMapping - adnotacja używana do mapowania żądań na metody kontrolerów.
	 * Mapowanie listy wyświetlającej wszystkich gości.
	 */
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Guest> guests = guestService.getAll();
		model.addAttribute("guests", guests);

		return "guest/guest";
	}

	/**
	 * Adnotacja ResponseBody - wiąże wartość zwracaną przez metodę z treścią odpowiedzi internetowej.
	 * Mapowanie wyboru jednego gościa.
	 */
	@RequestMapping("/getOne") 
	@ResponseBody
	public Optional<Guest> getOne(Integer Id)
	{
		return guestService.getOne(Id);
	}

	/**
	 * Adnotacja PostMapping - to wyspecjalizowana wersja adnotacji @RequestMapping.
	 * Działa jako skrót do @RequestMapping(method = RequestMethod.POST).
	 * Mapowanie dodawania nowego gościa.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich gości.
	 */
	@PostMapping(value="/addNew")
	public String addNew(Guest guest) {
		
		guestService.addNew(guest);
		return "redirect:/guests/getAll";
	}

	/**
	 * Mapowanie edycji gościa.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich gości.
	 */
	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Guest guest) {
		guestService.update(guest);
		return "redirect:/guests/getAll";
	}

	/**
	 * Mapowanie usuwania gościa.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich gości.
	 */
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer Id) {
		guestService.delete(Id);
		return "redirect:/guests/getAll";
	}
	
}
