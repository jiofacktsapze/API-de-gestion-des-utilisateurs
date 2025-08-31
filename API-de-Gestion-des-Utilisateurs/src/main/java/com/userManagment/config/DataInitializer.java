package com.userManagment.config;

import com.userManagment.model.Roles;
import com.userManagment.model.User;
import com.userManagment.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    // 🔧 Injection via constructeur
//    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    public CommandLineRunner createDefaultUser() {
//        return args -> {
//            String defaultEmail = "admin@example.com";
//
//            if (userRepository.findByEmail(defaultEmail).isEmpty()) {
//                User user = new User();
//                user.setEmail(defaultEmail);
//                user.setPassword(passwordEncoder.encode("admin"));
//                user.setRole(Roles.ADMIN);
//
//                userRepository.save(user);
//                System.out.println("✔ Utilisateur par défaut créé : admin@example.com / admin123");
//            }
//        };
//    }

}
