package com.orange.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String image;
    private String country;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "userId")
    private List<Project> projects;

    public User() {
        //Construtor sem argumentos


    }

    public User(String firstName, String lastName, String image, String country, String email, List<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.country = country;
        this.email = email;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImage() {
        return image;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(image, user.image) && Objects.equals(country, user.country) && Objects.equals(email, user.email) && Objects.equals(projects, user.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, image, country, email, projects);
    }

}









