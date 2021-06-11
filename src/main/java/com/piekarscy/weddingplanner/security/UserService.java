/**
 * Klasa UserService - serwis użytkownika
 * @author Martyna Piekarska
 */

package com.piekarscy.weddingplanner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Adnotacja Service - ziarno utrzymuje logikę biznesową, jest używane w warstwie usług.
 */
@Service
public class UserService {

    /**
     * Adnotacja Autowired - (Dependency Injection) wstrzykiwanie zależności.
     * Wstrzykiwanie zależności poprzez pole.
     */
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;


    /**
     * Metoda zapisująca użytkownika z domyślną rolą user.
     * Zawiera szyfrowanie haseł BCrypt.
     * Zapisuje użytkownika do repozytorium.
     */
    public void saveUserWithDefaultRole(User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);

        userRepo.save(user);
    }

    /**
     * Zwraca listę wszystkich użytkowników.
     */
    public List<User> listAll() {
        return userRepo.findAll();
    }



}
