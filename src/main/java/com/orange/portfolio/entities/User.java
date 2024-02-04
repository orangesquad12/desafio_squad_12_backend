package com.orange.portfolio.entities;

import com.orange.portfolio.dtos.user.UserDTO;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String firstName;
    private String image;
    private String country;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @JoinColumn(name = "project_id")
    //@JsonIgnore
    @OneToMany
    private List<Project> projects;
    public User(){
        //Construtor sem argumentos
    }
    public User(Long aLong) {

    }

    public User(UserDTO data){
        this.firstName = data.getFirstName();
        this.lastName = data.getLastName();
        this.country = data.getCountry();
        this.email = data.getEmail();
        this.password = data.getPassword();
        this.image = data.getImage();
    }


    public User(String firstName, String lastName, String image, String country, String email, String password, List<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.country = country;
        this.email = email;
        this.password = password;
        this.projects = projects;
    }

    public User(String email, String password) {

    }

    public User(String firstName, String lastName, String country, String email) {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
        //return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(image, user.image) && Objects.equals(country, user.country) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(projects, user.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, image, country, email, password, projects);
    }

}









