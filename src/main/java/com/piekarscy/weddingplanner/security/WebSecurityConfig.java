/**
 * Klasa WebSecurityConfig - konfiguracja zabezpieczeń internetowych
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Adnotacja Configuration - klasy konfiguracyjne mogą zawierać metody definicji ziaren z adnotacją @Bean.
 * Adnotacja EnableWebSecurity - włącza obsługę zabezpieczeń internetowych Spring Security i zapewnia integrację Spring MVC.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
     * Wzorzec projektowy polegający na tym, że obiekt nie inicjalizuje zależności samodzielnie,
     * tylko przyjmuje je z zewnątrz poprzez wstrzykiwanie.
     * Wstrzykiwanie zależności poprzez pole.
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Adnotacja Bean - metoda generuje ziarno, które ma być zarządzane przez kontener Spring.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    /**
     * BCryptPasswordEncoder - algorytm szyfrujący hasła.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Ziarno uwierzytelniania użytkownika.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    /**
     * Ziarno konfiguracji dostawcy.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Metoda configure():
     * - csrf - Fałszerstwo żądań między witrynami (Cross-Site Request Forgery) wbudowany mechanizm zabezpieczające przed niektórymi typami ataków,
     * - chroni adresy w aplikacji, dopuszcza wybrane adresy do wglądu dla wszystkich użytkowników bez konieczności logowania,
     * - określa sposób zalogowania na stronę i autentykację użytkownika,
     * - definiuje przekierowanie po poprawnym zalogowaniu,
     * - określa stronę przekierowania po wylogowaniu.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home", "/index", "/login", "/register", "/process_register", "/error").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .defaultSuccessUrl("/summary")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/")
                .permitAll()
                .and()
                .headers().frameOptions().disable();
    }
}
