package com.orange.portfolio.services;

import com.orange.portfolio.entities.Project;

public interface ProjectService {

    Project save(Project project);

    Project findProjectByTag(String tag);

    void delete(Long id);
}
