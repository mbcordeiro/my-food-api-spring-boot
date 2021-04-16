package com.matheuscordeiro.myfoodapi.services;

import com.matheuscordeiro.myfoodapi.models.User;
import com.matheuscordeiro.myfoodapi.repositories.UserRepository;
import com.matheuscordeiro.myfoodapi.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        verifyIfExists(user.getId());
        return saveUser(user);
    }

    @Override
    public boolean inactivateUser() {
        return false;
    }

    public User verifyIfExists(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
