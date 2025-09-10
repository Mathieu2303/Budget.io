package com.example.budget_app.controller;

//import com.example.budget_app.entity.ExpenseEntity;
import com.example.budget_app.entity.UserEntity;
import com.example.budget_app.repository.UserRepository;
//import com.example.budget_app.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user) {
        UserEntity savedUser = userRepository.save(user);
        System.out.println("User created with ID " + savedUser.getId());
        return savedUser;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {return userRepository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // 200 OK with user data
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            UserEntity savedUser = userRepository.save(user);
            return ResponseEntity.ok(savedUser);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserEntity> deleteUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
