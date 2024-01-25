package com.orange.portfolio.services;

import com.orange.portfolio.dtos.project.ProjectDTO;
import com.orange.portfolio.entities.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project create(ProjectDTO projectDTO);

    Project getProjectByTag(String tag);

    Project findProjectById(Long id);

    List<Project> getAllByUserId(Long userId);

    List<Project> getAllProjects();

    void delete(Long id);
}
