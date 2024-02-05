package com.orange.portfolio.repositories;

import com.orange.portfolio.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {

    void delete(Project project);

    List<Project> findAllProjectByUserId(Long userId);
}
