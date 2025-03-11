package com.example.budget_app.controller;

import com.example.budget_app.entity.ApiResponse;
import com.example.budget_app.entity.UserEntity;
import com.example.budget_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ApiResponse homeController() {
        ApiResponse res = new ApiResponse();
        res.setMessage("welcome to budget-app api");
        res.setStatus(true);
        return res;
    }

    @GetMapping("/all")
    public List<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

//    @GetMapping("/{id}/totalExpenses")
//    public Optional<UserEntity> findExpensiseById(@PathVariable("id") Long id) {
//        return userService.findExpenseById(id);
//    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }
//
//    public UserEntity updateUser(@RequestBody UserEntity user) {
//        return userService.updateUser(user);
//    }

    @PutMapping("/{userId}/balance")
    public ResponseEntity<UserEntity> updateUserBalance(
            @PathVariable("userId") Long userId,
            @RequestParam("amount") Double amount) {

        UserEntity updatedUser = userService.updateUserBalance(userId, amount);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteUserById(@PathVariable("id") Long id){
        userService.deleteUser(id);
        ApiResponse res = new ApiResponse();
        res.setMessage("Deleted user");
        res.setStatus(true);
        return res;
    }


}
