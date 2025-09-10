//package com.example.budget_app.service;
//
//import com.example.budget_app.entity.ExpenseEntity;
//import com.example.budget_app.entity.UserEntity;
//import com.example.budget_app.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
////    public UserEntity createUser(UserEntity user) {
////        return userRepository.save(user);
////    }
////
////    public Optional<UserEntity> getUserById(long id) {
////        return userRepository.findById(id);
////    }
////    public void addExpensesToUser(UserEntity user, double amount, String Catergory, int frequency){
////        ExpenseEntity expense = new ExpenseEntity();
////        expense.setAmount(amount);
////        expense.setCategory(Catergory);
////        expense.setFrequency(frequency);
////        expense.setUser(user);
////
////        user.getExpenses().add(expense);
////
////    }
////
////    public void deleteUserById(long id) {
////        userRepository.deleteById(id);
////    }
//
//
//}
