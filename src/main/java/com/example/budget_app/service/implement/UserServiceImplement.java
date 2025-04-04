package com.example.budget_app.service.implement;

import com.example.budget_app.entity.UserEntity;
import com.example.budget_app.repository.UserRepository;
import com.example.budget_app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUserBalance(Long id) {
        userRepository.deleteUserBalance(id);
    }

    @Override
    public UserEntity updateUserBalance(Long userId, Double amount) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId)); // Extract UserEntity

        user.setTotalBalance(amount);
        return userRepository.save(user);
    }
}
