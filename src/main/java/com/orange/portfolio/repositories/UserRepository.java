package com.orange.portfolio.repositories;

import com.orange.portfolio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    void delete(User user);

    User findByEmail(String email);
}
