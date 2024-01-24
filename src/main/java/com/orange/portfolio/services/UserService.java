package com.orange.portfolio.services;

import com.orange.portfolio.dtos.user.UserDTO;
import com.orange.portfolio.entities.User;

public interface UserService {

    User save(User user);

    User create(UserDTO userDTO);

    User findUserById(Long id);

    void delete(Long id);
}
