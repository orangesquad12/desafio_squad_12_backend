package com.orange.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.orange.portfolio.dtos.project.ProjectDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "client_id")
    private User user;

    private String title;

    @ElementCollection
    @CollectionTable(name = "project_tags", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "tags")
    private List<String> tags;

    private String detailing;
    private String image;
    private LocalDate date;

    public Project() {

    }

    public Project(ProjectDTO data) {
        this.id = data.getId();
        this.detailing = data.getDetailing();
        this.title = data.getTitle();
        this.tags = data.getTags();
        this.date = LocalDate.now();
    }

    public Project(Long id, User userId, String title, List<String> tags, String detailing, String image, LocalDate date) {
        this.id = id;
        this.user = userId;
        this.title = title;
        this.tags = tags;
        this.detailing = detailing;
        this.image = image;
        this.date = date;
    }

    public Project(Long id, User userId, String title, List<String> tags, String detailing) {
        this.id = id;
        this.user = userId;
        this.title = title;
        this.tags = tags;
        this.detailing = detailing;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getDetailing() {
        return detailing;
    }

    public String getImage() {
        return image;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setDetailing(String detailing) {
        this.detailing = detailing;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id && Objects.equals(user, project.user) && Objects.equals(title, project.title) && Objects.equals(tags, project.tags) && Objects.equals(detailing, project.detailing) && Objects.equals(image, project.image) && Objects.equals(date, project.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, title, tags, detailing, image, date);
    }
}


