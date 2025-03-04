package com.example.budget_app.service;

import com.example.budget_app.repository.ExpenseRepository;
import org.springframework.stereotype.Service;


public interface ExpenseService {
    double getTotalBalance(Long userId);
}
