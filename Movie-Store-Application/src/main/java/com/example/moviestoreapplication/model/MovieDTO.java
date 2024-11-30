package com.example.moviestoreapplication.model;

public class MovieDTO {
    public Integer id;
    public String Director;
    public String Title;
    public double Price;
    public boolean isAvailable;
    public String Description;

    public MovieDTO(){}

    public MovieDTO(String Director, String Title, double Price, String Description){
        this.Director = Director;
        this.Title = Title;
        this.Price = Price;
        this.isAvailable = true;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
