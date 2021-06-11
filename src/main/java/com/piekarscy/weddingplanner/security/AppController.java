/**
 * Klasa AppController - kontroler aplikacji
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Adnotacja Controller - stereotyp dla warstw prezentacji. Klasa obsługuje żądania HTTP.
 * Po otrzymaniu żądania uruchamiana jest metoda,
 * której mapowanie odpowiada ścieżce określonej w wysłanym żądaniu.
 */
@Controller
public class AppController {

    /**
     * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
     * Wstrzykiwanie zależności poprzez pole.
     */
    @Autowired
    private UserService service;

    /**
     * Adnotacja GetMapping -  to złożona adnotacja, która działa jako skrót do @RequestMapping(method = RequestMethod.GET).
     * Sekretna strona dla roli Admin. Stworzona dla podglądu, czy po prezentacji aplikacji słuchacze zarejestrowali się
     * i sprawdzali działanie programu. Zwraca listę zarejestrowanych użytkowników.
     */
    @GetMapping("/list_users")
    public String viewUsersList(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

}
