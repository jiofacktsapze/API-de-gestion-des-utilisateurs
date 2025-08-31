package com.userManagment.controller;


import com.userManagment.model.Roles;
import com.userManagment.model.User;
import com.userManagment.repository.UserRepository;
import com.userManagment.security.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Endpoint pour créer un utilisateur
    @PostMapping("/register")
    @Operation(summary = "Ajouter un nouveau utilisateur")
    public String register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already in use";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Roles.ADMIN); // Vous pouvez assigner un rôle par défaut (USER par exemple)
        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            // Si la correspondance est trouvée
            return Map.of("token", jwtService.generateToken(user));
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }


//    @PostMapping("/login")
//    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
//        String email = request.get("email");
//        String password = request.get("password");
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return new ResponseEntity<>(Map.of("message", "L'email et le mot de passe ne doivent pas être vides"), HttpStatus.BAD_REQUEST);
//        }
//
//        try {
//            authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//            User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
//
//            String token = jwtService.generateToken(user);
//
//            return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(Map.of("message", "Échec de l'authentification : " + e.getMessage()), HttpStatus.UNAUTHORIZED);
//        }
//    }

}
