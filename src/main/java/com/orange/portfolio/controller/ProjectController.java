package com.orange.portfolio.controller;

import com.orange.portfolio.dtos.project.ProjectDTO;
import com.orange.portfolio.entities.Project;
import com.orange.portfolio.services.impl.ProjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;


    @PostMapping
    public ResponseEntity<Project> save(@RequestBody @Valid ProjectDTO projectDTO){
        var project = projectService.create(projectDTO);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllByUserId(@RequestParam(value = "userId") @Valid Long userId){
        var projectList = projectService.getAllByUserId(userId);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @GetMapping("/{tag}")
    public ResponseEntity<Project> getProjectByTag(@PathVariable String tag){
        var project = projectService.getProjectByTag(tag);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody @Valid ProjectDTO projectDTO){
        var findProject = projectService.findProjectById(id);
        var saveProject = projectService.save(findProject);
        return new ResponseEntity<>(saveProject, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long id){
        projectService.delete(id);
    }
}
