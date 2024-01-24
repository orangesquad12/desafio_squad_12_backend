package com.orange.portfolio.services.impl;

import com.orange.portfolio.dtos.user.UserDTO;
import com.orange.portfolio.entities.User;
import com.orange.portfolio.repositories.UserRepository;
import com.orange.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User create(UserDTO userDTO) {
        User newUser = new User(userDTO);
        return this.save(newUser);
    }

    @Override
    public User findUserById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        var user = repository.findById(id);
        repository.delete(user);
    }
}
