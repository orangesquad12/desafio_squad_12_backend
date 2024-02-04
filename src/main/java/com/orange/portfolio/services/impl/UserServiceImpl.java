package com.orange.portfolio.services.impl;

import com.orange.portfolio.dtos.user.UserDTO;
import com.orange.portfolio.entities.User;
import com.orange.portfolio.repositories.UserRepository;
import com.orange.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AmazonS3ServiceImpl amazonS3Service;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User create(UserDTO userDTO) {
        User newUser = new User(userDTO);
        return this.save(newUser);
    }

    public UserDetails findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User uploadImage(MultipartFile file, Long id) {
        var user = repository.findById(id).orElseThrow();
        String fileUrl = amazonS3Service.uploadFile(file);
        user.setImage(fileUrl);
        repository.save(user);
        return user;
    }



    @Override
    public void delete(Long id) {
        var user = repository.findById(id).orElseThrow();
        repository.delete(user);
    }
}
