package com.matheuscordeiro.myfoodapi.controllers;

import com.matheuscordeiro.myfoodapi.models.User;
import com.matheuscordeiro.myfoodapi.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id).get());
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid User user) {
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }
}
