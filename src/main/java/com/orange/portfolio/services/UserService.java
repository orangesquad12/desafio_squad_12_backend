package com.orange.portfolio.services;

import com.orange.portfolio.dtos.user.UserDTO;
import com.orange.portfolio.entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User save(User user);

    User create(UserDTO userDTO);

    User findUserById(Long id);

    User uploadImage(MultipartFile file, Long id);

    void delete(Long id);
}
