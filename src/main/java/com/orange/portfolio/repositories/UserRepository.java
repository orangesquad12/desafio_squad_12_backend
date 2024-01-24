package com.orange.portfolio.repositories;

import com.orange.portfolio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    void delete(Optional<User> user);
}
