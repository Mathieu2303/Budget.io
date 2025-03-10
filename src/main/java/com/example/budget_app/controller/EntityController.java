package com.example.budget_app.controller;

import com.example.budget_app.entity.UserEntity;
import com.example.budget_app.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class EntityController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/total-balance/{userId}")
    public Optional<UserEntity> findExpensiseById(@PathVariable Long userId) {
        double totalBalance = expenseService.getTotalBalance(userId);
        return ResponseEntity.ok(totalBalance);
    }
}
