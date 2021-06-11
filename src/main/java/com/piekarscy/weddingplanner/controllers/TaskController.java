/**
 * Klasa TaskController - kontroler zadania
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner.controllers;

import java.util.List;
import java.util.Optional;

import com.piekarscy.weddingplanner.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piekarscy.weddingplanner.models.Task;

/**
 * Adnotacja Controller - stereotyp dla warstw prezentacji. Klasa obsługuje żądania HTTP.
 * Po otrzymaniu żądania uruchamiana jest metoda,
 * której mapowanie odpowiada ścieżce określonej w wysłanym żądaniu.
 * Adnotacja RequestMapping nad nazwą klasy - wszystkie poniższe mapowania zawierają mapowanie "/tasks" i kolejne własne mapowanie.
 * Przykład: "/tasks/getAll".
 */
@Controller
@RequestMapping("/tasks")
public class TaskController {

	/**
	 * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
	 * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
	 * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
	 * Wstrzykiwanie zależności poprzez pole.
	 */
	@Autowired
	private TaskService taskService;

	/**
	 * Adnotacja RequestMapping - adnotacja używana do mapowania żądań na metody kontrolerów.
	 * Mapowanie listy wyświetlającej wszystkie zadania.
	 */
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Task> tasks = taskService.getAll();
		model.addAttribute("tasks", tasks);
		return "task/task";
	}

	/**
	 * Adnotacja ResponseBody - wiąże wartość zwracaną przez metodę z treścią odpowiedzi internetowej.
	 * Mapowanie wyboru jednego zadania.
	 */
	@RequestMapping("/getOne") 
	@ResponseBody
	public Optional<Task> getOne(Integer Id)
	{
		return taskService.getOne(Id);
	}

	/**
	 * Adnotacja PostMapping - to wyspecjalizowana wersja adnotacji @RequestMapping.
	 * Działa jako skrót do @RequestMapping(method = RequestMethod.POST).
	 * Mapowanie dodawania nowego zadania.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich zadań.
	 */
	@PostMapping(value="/addNew")
	public String addNew(Task task) {
		
		taskService.addNew(task);
		return "redirect:/tasks/getAll";
	}

	/**
	 * Mapowanie edycji zadania.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich zadań.
	 */
	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Task task) {
		taskService.update(task);
		return "redirect:/tasks/getAll";
	}

	/**
	 * Mapowanie usuwania zadania.
	 * Następnie przekierowuje na wyświetlanie listy wszystkich zadań.
	 */
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer Id) {
		taskService.delete(Id);
		return "redirect:/tasks/getAll";
	}
	
}
