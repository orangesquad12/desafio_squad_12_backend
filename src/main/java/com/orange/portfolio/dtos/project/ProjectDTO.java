package com.orange.portfolio.dtos.project;

import com.orange.portfolio.entities.Project;

import java.time.LocalDate;
import java.util.List;

public class ProjectDTO {

    private Long userId;
    private String title;
    private List<String> tags;
    private String description;
    private LocalDate date;

    public ProjectDTO(Long userId, String title, List<String> tags, String description, LocalDate date) {
        this.userId = userId;
        this.title = title;
        this.tags = tags;
        this.description = description;
        this.date = date;
    }

    public ProjectDTO() {
    }

    public ProjectDTO(Project project) {
        this.userId = project.getUserId().getId();
        this.title = project.getTitle();
        this.tags = project.getTags();
        this.description = project.getDescription();
        this.date = project.getDate();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
    }
}
