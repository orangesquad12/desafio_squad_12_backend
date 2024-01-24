package com.orange.portfolio.services.impl;

import com.orange.portfolio.entities.Project;
import com.orange.portfolio.repositories.ProjectRepository;
import com.orange.portfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    public Project save(Project project) {
        return repository.save(project);
    }

    @Override
    public Project findProjectByTag(String tag) {
        return repository.findProjectByTag(tag);
    }

    @Override
    public void delete(Long id) {
        var project = repository.findById(id);
        repository.delete(project);
    }
}
