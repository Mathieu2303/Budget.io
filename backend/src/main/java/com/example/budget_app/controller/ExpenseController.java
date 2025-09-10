package com.example.budget_app.controller;

import com.example.budget_app.entity.ExpenseEntity;
import com.example.budget_app.entity.UserEntity;
import com.example.budget_app.repository.ExpenseRepository;
import com.example.budget_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createExpense/{userId}")
    public ResponseEntity<ExpenseEntity> createExpense(@PathVariable Long userId, @RequestBody ExpenseEntity expense) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        expense.setUser(user);
        return ResponseEntity.ok(expenseRepository.save(expense));
    }

    @GetMapping("/getUserExpenses/{userId}")
    public List<ExpenseEntity> getUserExpenses(@PathVariable Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    @PutMapping("user/{userId}/update/{expenseId}")
    public ResponseEntity<ExpenseEntity> updateExpense(
            @PathVariable Long userId,
            @PathVariable Long expenseId,
            @RequestBody ExpenseEntity expenseDetails) {
        Optional<UserEntity> existingUser = userRepository.findById(userId);
        Optional<ExpenseEntity> existingExpense = expenseRepository.findById(expenseId);

        if (existingUser.isEmpty() || existingExpense.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ExpenseEntity expense = existingExpense.get();

        if(!expense.getUser().getId().equals(userId)) {
            return ResponseEntity.badRequest().build();
        }

        expense.setUser(existingUser.get());
        expense.setAmount(expenseDetails.getAmount());
        expense.setDate(expenseDetails.getDate());
        expenseRepository.save(expense);
        return ResponseEntity.ok(expense);
    }

    @DeleteMapping("/user/{userId}/delete/{expenseId}")
    public ResponseEntity<Void> deleteExpense(
            @PathVariable Long userId,
            @PathVariable Long expenseId) {
        Optional<UserEntity> existingUser = userRepository.findById(userId);
        Optional<ExpenseEntity> existingExpense = expenseRepository.findById(expenseId);

        if (existingUser.isEmpty() || existingExpense.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ExpenseEntity expense = existingExpense.get();

        // Check if the expense is owned by this user
        if (!expense.getUser().getId().equals(userId)) {
            return ResponseEntity.badRequest().build(); // Unauthorized delete
        }

        expenseRepository.delete(expense);
        return ResponseEntity.ok().build();
    }
}
