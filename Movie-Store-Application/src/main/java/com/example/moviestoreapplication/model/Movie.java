package com.example.moviestoreapplication.model;

import com.example.moviestoreapplication.constraint.StartWithUppercase;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieOrder> listOfMovieOrders = new ArrayList<>();

    public Movie(){}

    public Movie(String Director, String Title, double Price, String Description, boolean isAvailable){
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
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
