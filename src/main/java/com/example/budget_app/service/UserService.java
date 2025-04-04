package com.example.budget_app.service;

import com.example.budget_app.entity.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUsers();
    Optional<UserEntity> findUserById(Long id);
    UserEntity saveUser(UserEntity user);
    void deleteUser(Long id);
    void deleteUserBalance(Long id);

    UserEntity updateUserBalance(Long userId, Double amount);

}
