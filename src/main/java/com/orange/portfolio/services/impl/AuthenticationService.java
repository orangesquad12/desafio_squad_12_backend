package com.orange.portfolio.services.impl;

import com.orange.portfolio.dtos.user.LoginDTO;
import com.orange.portfolio.dtos.user.RegisterDTO;
import com.orange.portfolio.entities.User;
import com.orange.portfolio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public ResponseEntity login(LoginDTO data){
        var user = repository.findByEmail(data.email());
        if (user != null) {
            if (passwordEncoder.matches(data.password(), user.getPassword())){
                return ResponseEntity.ok().build();
            }
        } return ResponseEntity.badRequest().build();
    }

    public ResponseEntity register(RegisterDTO data){
        if (repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.email(), encryptedPassword);
        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
