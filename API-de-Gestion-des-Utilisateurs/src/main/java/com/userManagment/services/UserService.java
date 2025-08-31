package com.userManagment.services;

import com.userManagment.model.Roles;
import com.userManagment.model.User;
import com.userManagment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Configuration
@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

//    public User createUser(User user) {
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        return userRepository.save(user);
//    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(new BCryptPasswordEncoder().encode(userDetails.getPassword()));
        }
        return userRepository.save(user);
    }



//    public Optional<User> updateUser(Long id, User userdetail) {
//        return userRepository.findById(id).map(user -> {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//           user.setUsername(userdetail.getUsername());
//            user.setEmail(userdetail.getEmail());
//            return userRepository.save(user);
//        });
//    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


//    private final UserRepository userRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public Optional<User> getUserById(Long id) {
//        return userRepository.findById(id);
//    }
//
//    public Optional<User> getUsersByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public List<User> getUserByRoles(Roles role) {
//        return userRepository.findByRole(role);
//    }
//
//    public User createUser (User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    public Optional<User> updateUser(Long id, User userdetail) {
//        return userRepository.findById(id).map(user -> {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            user.setUsername(userdetail.getUsername());
//            user.setEmail(userdetail.getEmail());
//            return userRepository.save(user);
//        });
//    }
//
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }



}
