/**
 * Klasa MyBudgetController - kontroler budżetu
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.controllers;

import com.piekarscy.weddingplanner.models.MyBudget;
import com.piekarscy.weddingplanner.services.MyBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * Adnotacja Controller - stereotyp dla warstw prezentacji. Klasa obsługuje żądania HTTP.
 * Po otrzymaniu żądania uruchamiana jest metoda,
 * której mapowanie odpowiada ścieżce określonej w wysłanym żądaniu.
 * Adnotacja RequestMapping nad nazwą klasy - wszystkie poniższe mapowania zawierają mapowanie "/mybudgets" i kolejne własne mapowanie.
 * Przykład: "/mybudgets/getAll".
 */
@Controller
@RequestMapping("/mybudgets")
public class MyBudgetController {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
	 * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private MyBudgetService myBudgetService;

	/**
	 * Adnotacja ResponseBody - wiąże wartość zwracaną przez metodę z treścią odpowiedzi internetowej.
	 * Mapowanie wyboru budżetu (do wyświetlania podczas edycji).
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<MyBudget> getOne(Integer Id) {
		return myBudgetService.getOne(Id);
	}

	/**
	 * Mapowanie edycji budżetu.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich wydatków, podsumowania budżetu i obliczeń.
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(MyBudget mybudget) {
		myBudgetService.update(mybudget);
		return "redirect:/expences/getAll";
	}

}
