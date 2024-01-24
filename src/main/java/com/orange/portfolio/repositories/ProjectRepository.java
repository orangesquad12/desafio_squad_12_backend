package com.orange.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.portfolio.entities.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {

}
