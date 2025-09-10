//package com.example.budget_app.service;
//
//import com.example.budget_app.entity.UserEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@Service
//public class ExpenseService {
//
//    public Double calculateTotalExpenses(UserEntity user) {
//        return user.getExpenses()
//                .stream()
//                .mapToDouble(ExpenseEntity::getAmount)
//                .sum();
//    }
//}
