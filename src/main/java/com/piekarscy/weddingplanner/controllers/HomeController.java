/**
 * Klasa HomeController - kontroler strony głównej
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.controllers;

import com.piekarscy.weddingplanner.models.Expences;
import com.piekarscy.weddingplanner.models.Gift;
import com.piekarscy.weddingplanner.models.Guest;
import com.piekarscy.weddingplanner.models.Task;
import com.piekarscy.weddingplanner.security.User;
import com.piekarscy.weddingplanner.security.UserService;
import com.piekarscy.weddingplanner.services.ExpencesService;
import com.piekarscy.weddingplanner.services.GiftService;
import com.piekarscy.weddingplanner.services.GuestService;
import com.piekarscy.weddingplanner.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Adnotacja Controller - stereotyp dla warstw prezentacji. Klasa obsługuje żądania HTTP.
 * Po otrzymaniu żądania uruchamiana jest metoda,
 * której mapowanie odpowiada ścieżce określonej w wysłanym żądaniu.
 */

@Controller
public class HomeController {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
	 * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private TaskService taskService;

	@Autowired
	private GiftService giftService;

	@Autowired
	private GuestService guestService;

	@Autowired
	private ExpencesService expencesService;

	@Autowired
	private UserService service;


	/**
	 * Adnotacja GetMapping -  to złożona adnotacja, która działa jako skrót do @RequestMapping(method = RequestMethod.GET).
	 * Mapowanie strony logowania i uwierzytelnienie użytkownika. Po poprawnym zalogowaniu przekierowuje
	 * użytkownika do strony głównej.
	 */
	@GetMapping("/login")
	public String getLogin() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/";
	}

	/**
	 * Adnotacja RequestMapping - adnotacja używana do mapowania żądań na metody kontrolerów.
	 * Mapowanie strony głównej (przed zalogowaniem).
	 */
	@RequestMapping({"", "/home", "index", "/", "home"})
	public String home(Model model) {

		return "index";
	}

	/**
	 * Mapowanie strony z podsumowaniem. Metoda zlicza ilość zadań, wydatków, prezentów i gości na listach.
	 */
	@RequestMapping("/summary")
	public String summary(Model model) {

		List<Task> tasks = taskService.getAll();
		int countTasks = tasks.size();
		model.addAttribute("countTasks", countTasks);

		List<Gift> gifts = giftService.getAll();
		int countGifts = gifts.size();
		model.addAttribute("countGifts", countGifts);

		List<Guest> guests = guestService.getAll();
		int countGuests = guests.size();
		model.addAttribute("countGuests", countGuests);

		List<Expences> expences = expencesService.getAll();
		int countExpences = expences.size();
		model.addAttribute("countExpences", countExpences);

		return "summary";
	}

	/**
	 * Mapowanie strony rejestracji. Tworzenie nowego użytkownika.
	 */
	@RequestMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	/**
	 * Mapowanie strony potwierdzającej pomyślną rejestrację.
	 * Nowy użytkownik jest zapisywany do bazy danych z domyślną rolą User.
	 */
	@RequestMapping("/process_register")
	public String processRegistration(User user) {
		service.saveUserWithDefaultRole(user);
		return "register_success";
	}
}
