package com.orange.portfolio.services.impl;

import com.orange.portfolio.dtos.project.ProjectDTO;
import com.orange.portfolio.entities.Project;
import com.orange.portfolio.repositories.ProjectRepository;
import com.orange.portfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    public Project save(Project project) {
        return repository.save(project);
    }

    @Override
    public Project create(ProjectDTO projectDTO) {
        Project project = new Project(projectDTO);
        return this.save(project);
    }

    @Override
    public Project getProjectByTag(String tag) {
        return repository.findProjectByTag(tag);
    }

    @Override
    public Project findProjectById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Project> getAllByUserId(Long userId) {
        if (userId > 0){
            return repository.findAllByUserId(userId);
        } else return this.getAllProjects();
    }


    @Override
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        var project = repository.findById(id).orElseThrow();
        repository.delete(project);
    }
}
