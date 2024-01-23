package com.orange.portfolio.repositories;

import com.orange.portfolio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
