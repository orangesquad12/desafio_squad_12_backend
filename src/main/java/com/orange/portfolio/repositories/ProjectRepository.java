package com.orange.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.portfolio.entities.Project;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {

    Project findProjectByTag(String tag);

    void delete(Optional<Project> project);
}
