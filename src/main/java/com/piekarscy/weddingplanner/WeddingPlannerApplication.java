/**
 * Klasa WeddingPlannerApplication - klasa uruchomieniowa
 * @author Edwin Piekarski
 */

package com.piekarscy.weddingplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  Adnotacja SpringBootApplication - aplikacja korzysta z automatycznej konfiguracji, skanowania komponentów
 *  i dopuszcza do definiowania dodatkowych konfiguracji w klasie aplikacji.
 *  Adnotacja włącza trzy funkcje:
 * - @EnableAutoConfiguration - włącza mechanizm automatycznej konfiguracji Spring Boot
 * - @ComponentScan - włącza skanowanie pakietu, w którym znajduje się aplikacja
 * - @Configuration - pozwala na rejestrację dodatkowych ziaren w kontekście lub importowanie dodatkowych klas konfiguracyjnych
 */
@SpringBootApplication
public class WeddingPlannerApplication {

	/**
	 * Główna metoda main - metoda uruchomieniowa aplikacji Spring Boot
	 */
	public static void main(String[] args) {
		SpringApplication.run(WeddingPlannerApplication.class, args);
	}

}
