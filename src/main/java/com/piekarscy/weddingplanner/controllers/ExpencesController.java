/**
 * Klasa ExpencesController - kontroler wydatków
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.controllers;

import com.piekarscy.weddingplanner.models.Expences;
import com.piekarscy.weddingplanner.models.MyBudget;
import com.piekarscy.weddingplanner.services.ExpencesService;
import com.piekarscy.weddingplanner.services.MyBudgetService;
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
 * Adnotacja RequestMapping nad nazwą klasy - wszystkie poniższe mapowania zawierają mapowanie "/expences" i kolejne własne mapowanie.
 * Przykład: "/expences/getAll".
 */
@Controller
@RequestMapping("/expences")
public class ExpencesController {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
	 * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private ExpencesService expencesService;

	@Autowired
	private MyBudgetService myBudgetService;

	/**
	 * Adnotacja RequestMapping - adnotacja używana do mapowania żądań na metody kontrolerów.
	 * Mapowanie listy wyświetlającej wszystkie wydatki.
	 * W metodzie zawarte są strumienie liczące wartości: założony budżet(sumMyBudget), suma wszystkich
	 * wydatków(sumExpences) i obliczenie pozostałej kwoty(delta).
	 */
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Expences> expences = expencesService.getAll();
		model.addAttribute("expences", expences);

		int sumExpences = expences.stream().mapToInt(Expences -> Expences.getValue()).sum();
		model.addAttribute("sumExpences", sumExpences);

		List<MyBudget> mybudgets = myBudgetService.getAll();
		int sumMyBudget = mybudgets.stream().mapToInt(MyBudget -> MyBudget.getValue()).sum();
		int delta = sumMyBudget - sumExpences;

		model.addAttribute("sumMyBudget", sumMyBudget);
		model.addAttribute("delta", delta);

		return "expences/expences";
	}

	/**
	 * Adnotacja ModelAttribute - wiąże parametr metody lub wartość zwracaną przez metodę z nazwanego atrybutu modelu,
	 * a następnie udostępnia go w widoku internetowym.
	 * Lista obiektu budżet.
	 */
	@ModelAttribute("myBudget")
	public List<MyBudget> populateB(){
		return myBudgetService.getAll();
	}

	/**
	 * Adnotacja ResponseBody - wiąże wartość zwracaną przez metodę z treścią odpowiedzi internetowej.
	 * Mapowanie wyboru jednego wydatku.
	 */
	@RequestMapping("/getOne") 
	@ResponseBody
	public Optional<Expences> getOne(Integer Id)
	{
		return expencesService.getOne(Id);
	}

	/**
	 * Adnotacja PostMapping - to wyspecjalizowana wersja adnotacji @RequestMapping.
	 * Działa jako skrót do @RequestMapping(method = RequestMethod.POST).
	 * Mapowanie dodawania nowego wydatku.
	 * Następnie przekierowuje na wyświetlanie listy budżetu, wyliczeń i wszystkich wydatków.
	 */
	@PostMapping(value="/addNew")
	public String addNew(Expences expences) {

		expencesService.addNew(expences);
		return "redirect:/expences/getAll";
	}

	/**
	 * Mapowanie edycji wydatku.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich wydatków.
	 */
	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Expences expences) {
		expencesService.update(expences);
		return "redirect:/expences/getAll";
	}

	/**
	 * Mapowanie usuwania wydatku.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich wydatków.
	 */
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer Id) {
		expencesService.delete(Id);
		return "redirect:/expences/getAll";
	}
}
