package com.example.moviestoreapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String Director;
    public String Title;
    public double Price;
    public boolean isAvailable;
    public String Description;

    public Movie(){}

    public Movie(String Director, String Title, double Price, String Description){
        this.Director = Director;
        this.Title = Title;
        this.Price = Price;
        this.isAvailable = true;
        this.Description = Description;
    }

}
