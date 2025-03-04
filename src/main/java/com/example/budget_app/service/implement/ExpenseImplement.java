package com.example.budget_app.service.implement;

import com.example.budget_app.repository.ExpenseRepository;
import com.example.budget_app.service.ExpenseService;
import org.springframework.stereotype.Service;

@Service
public class ExpenseImplement implements ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseImplement(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public double getTotalBalance(Long userId) {
        List<ExpenseEntity> expenses = expenseRepository.findByUserId(userId);
        return expenses.stream().mapToDouble(ExpenseEntity::getAmount).sum();
    }
}
