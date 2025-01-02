package com.example.moviestoreapplication.authentication;

import com.example.moviestoreapplication.constraint.NotEnoughDigits;
import com.example.moviestoreapplication.constraint.NotEnoughUppercase;
import com.example.moviestoreapplication.constraint.StartWithUppercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class UserDTO {

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8)
    @NotEnoughDigits
    @NotEnoughUppercase
    private String password;

    @NotNull
    private String role;


    public UserDTO(String email, String password, String role){
        this.email = email;
        this.password = password;
        this.role = role;
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
        return  role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
