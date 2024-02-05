package com.orange.portfolio.dtos.project;

import com.orange.portfolio.entities.Project;

import java.time.LocalDate;
import java.util.List;

public class ProjectDTO {

    private Long id;
    private Long userId;
    private String title;
    private List<String> tags;
    private String detailing;
    private LocalDate date;

    public ProjectDTO(Long id, Long userId, String title, List<String> tags, String detailing, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.tags = tags;
        this.detailing = detailing;
        this.date = date;
    }

    public ProjectDTO(Long id, Long userId, String title, List<String> tags, String detailing){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.tags = tags;
        this.detailing = detailing;
    }

    public ProjectDTO() {
    }

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.userId = project.getUser().getId();
        this.title = project.getTitle();
        this.tags = project.getTags();
        this.detailing = project.getDetailing();
        this.date = project.getDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDetailing() {
        return detailing;
    }

    public void setDetailing(String detailing) {
    }
}
