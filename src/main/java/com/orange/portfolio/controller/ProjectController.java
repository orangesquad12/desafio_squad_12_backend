package com.orange.portfolio.controller;

import com.orange.portfolio.dtos.project.ProjectDTO;
import com.orange.portfolio.entities.Project;
import com.orange.portfolio.services.impl.ProjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;


    @PostMapping
    public ResponseEntity<ProjectDTO> save(@RequestBody @Valid ProjectDTO projectDTO){
        var project = projectService.create(projectDTO);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PostMapping("/image/{id}")
    public ResponseEntity uploadImage(@RequestPart(value = "image") MultipartFile file, @PathVariable Long id) {
        projectService.uploadImage(file, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllByUserId(@RequestParam(name = "userId",
            required = false) Long userId){
        var projectList = projectService.getAllByUserId(userId);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @GetMapping("/{tag}")
    public ResponseEntity<List<Project>> getProjectByTag(@PathVariable String tag){
        var project = projectService.getProjectByTag(tag);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@PathVariable Long id, @RequestBody @Valid ProjectDTO projectDTO){
        var project = projectService.update(id, projectDTO);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        projectService.delete(id);
    }
}
