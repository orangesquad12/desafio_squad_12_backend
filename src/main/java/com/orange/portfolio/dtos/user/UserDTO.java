package com.orange.portfolio.dtos.user;

import com.orange.portfolio.entities.User;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String image;
    private String country;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String firstName, String lastName,
                   String country, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.password = password;
    }

    public UserDTO(User saveUser) {
        this.firstName = saveUser.getFirstName();
        this.lastName = saveUser.getLastName();
        this.country = saveUser.getCountry();
        this.email = saveUser.getEmail();
    }

    public User toEntity(User user){
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCountry(country);
        user.setEmail(email);
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", image='" + image + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
