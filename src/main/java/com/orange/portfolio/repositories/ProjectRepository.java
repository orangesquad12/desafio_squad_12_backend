package com.orange.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.portfolio.entities.Project;
public interface ProjectRepository extends JpaRepository <Project, Long> {

}
