package com.userManagment.controller;


import com.userManagment.model.User;
import com.userManagment.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "API DE GESTION DES UTILISATEURS")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Liste de tous les utilisateurs")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Affiche un utilisateur par son ID")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

//    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    @Operation(summary = "Créer un utilisateur")
//    public User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Met à jour un utilisateur")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        //return userService.updateUser(id, user);
        userService.updateUser(id, user);
        return ("Utilisateur modifié avec succès !");
    }

//    public Optional<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }



    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Supprimer un utilisateur")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        System.out.println("Utilisateur supprimé avec succès");
        //return ResponseEntity.noContent().build();
        return ("Utilisateur supprimé avec succès !");
    }

//    private UserService userService;
//
//
//    @GetMapping("/api/users")
//    @Operation(summary = "Liste de tous les utilisateurs")
//    public List<User> getUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/{id}")
//    @Operation(summary = "Liste des utilisateurs par ID")
//    public ResponseEntity<User> getUsersByID(@PathVariable Long id) {
//        return ResponseEntity.of(userService.getUserById(id));
//    }
//
//    @GetMapping
//    @Operation(summary = "Liste des utilisateurs par email")
//    public ResponseEntity<User> getUsersByEmail(@PathVariable String email) {
//        return ResponseEntity.of(userService.getUsersByEmail(email));
//    }
//
//    @GetMapping("/api/users/role/{role}")
//    @Operation(summary = "Liste des utilisateurs par leurs roles")
//    public List<User> getUsersByRole(@PathVariable Roles role) {
//        return (role != null) ? userService.getUserByRoles(role) : userService.getAllUsers();
//    }
//
//    @PostMapping
//    @Operation(summary = "Ajouter un nouveau utilisateur")
//    public User addUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    @PutMapping("/{id}")
//    @Operation(summary = "Mettre à jour ou modifier un utilisateur")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        return ResponseEntity.of(userService.updateUser(id, user));
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Supprimer un utilisateur")
//    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }



}
