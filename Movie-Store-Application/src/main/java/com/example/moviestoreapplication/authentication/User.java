package com.example.moviestoreapplication.authentication;

import com.example.moviestoreapplication.constraint.NotEnoughDigits;
import com.example.moviestoreapplication.constraint.NotEnoughUppercase;
import com.example.moviestoreapplication.constraint.StartWithUppercase;
import com.example.moviestoreapplication.model.MovieOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "App_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @StartWithUppercase
    private String firstName;

    @NotNull
    @StartWithUppercase
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8)
    @NotEnoughDigits
    @NotEnoughUppercase
    private String password;
    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MovieOrder> listOfMovieOrders = new ArrayList<>();

    public User() {}

    public User(String firstName, String lastName, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}