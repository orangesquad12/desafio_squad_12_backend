package com.orange.portfolio.services.impl;

import com.orange.portfolio.dtos.project.ProjectDTO;
import com.orange.portfolio.entities.Project;
import com.orange.portfolio.repositories.ProjectRepository;
import com.orange.portfolio.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;


    @Autowired
    private AmazonS3ServiceImpl amazonS3Service;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Project save(Project project) {
        return repository.save(project);
    }

    @Override
    public Project uploadImage(MultipartFile file, Long id) {
        var project = repository.findById(id).orElseThrow();
        String fileUrl = amazonS3Service.uploadFile(file);
        project.setImage(fileUrl);
        repository.save(project);
        return project;
    }

    @Override
    public ProjectDTO create(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        project.setDate(LocalDate.now());
        var savedProject = this.save(project);
        return new ProjectDTO(savedProject);
    }

    @Override
    public List<Project> getProjectByTag(String tag) {
        return repository.findProjectByTags(tag);

    }

    @Override
    public Project findProjectById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Project> getAllByUserId(Long userId) {
        if (userId > 0){
            return repository.findAllByClientId(userId);
        } else return this.getAllProjects();
    }


    @Override
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public ProjectDTO update(Long id, ProjectDTO projectDTO) {
        var findProject = this.findProjectById(id);
        var project = modelMapper.map(projectDTO, Project.class);
        var projectUpdated = this.save(project);
        var dto = modelMapper.map(projectUpdated, ProjectDTO.class);
        return dto;
    }

    @Override
    public void delete(Long id) {
        var project = repository.findById(id).orElseThrow();
        repository.delete(project);
    }


}
