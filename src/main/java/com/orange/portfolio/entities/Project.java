package com.orange.portfolio.entities;

import com.orange.portfolio.dtos.project.ProjectDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_project")
public class Project  implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User userId;

    private String title;

    @ElementCollection
    private List<String> tags;

    private String description;
    private String image;
    private LocalDate date;

    public Project() {

    }

    public Project(ProjectDTO data){
        this.userId = new User(data.userId());
        this.description = data.description();
        this.title = data.title();
        this.image = data.image();
        this.tags = data.tags();
        this.date = LocalDate.now();
    }

    public Project(User userId, String title, List<String> tags, String description, String image, LocalDate date) {
        this.userId = userId;
        this.title = title;
        this.tags = tags;
        this.description = description;
        this.image = image;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return id == project.id && Objects.equals(userId, project.userId) && Objects.equals(title, project.title) && Objects.equals(tags, project.tags) && Objects.equals(description, project.description) && Objects.equals(image, project.image) && Objects.equals(date, project.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, tags, description, image, date);
    }
}


