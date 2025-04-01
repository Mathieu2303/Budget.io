package com.example.budget_app.controller;

import com.example.budget_app.entity.UserEntity;
import com.example.budget_app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}/balance")
    public ResponseEntity<UserEntity> updateUserBalance(
            @PathVariable("id") Long userId,
            @RequestParam("amount") Double amount) {

        UserEntity updatedUser = userService.updateUserBalance(userId, amount);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}/balance")
    public void deleteUserBalanceById(@PathVariable("id") Long id){
        userService.deleteUserBalance(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }


}
