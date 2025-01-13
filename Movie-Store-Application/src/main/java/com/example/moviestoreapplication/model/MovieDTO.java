package com.example.moviestoreapplication.model;

import com.example.moviestoreapplication.constraint.StartWithUppercase;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MovieDTO {
    public Integer id;

    @NotNull
    @StartWithUppercase
    public String Director;

    @NotNull
    @Size(min = 2)
    public String Title;

    @DecimalMin(value = "0.0" , inclusive = false)
    public double Price;

    public boolean isAvailable;

    @NotNull
    @Size(min = 10)
    public String Description;

    public MovieDTO(){}

    public MovieDTO(String Director, String Title, double Price, String Description, boolean isAvailable){
        this.Director = Director;
        this.Title = Title;
        this.Price = Price;
        this.isAvailable = isAvailable;
        this.Description = Description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
