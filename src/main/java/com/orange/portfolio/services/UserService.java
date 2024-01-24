package com.orange.portfolio.services;

import com.orange.portfolio.entities.User;

public interface UserService {

    User save(User user);

    void delete(Long id);
}
