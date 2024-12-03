package com.example.moviestoreapplication.model;

import com.example.moviestoreapplication.authentication.User;

import java.time.LocalDate;

public class MovieOrderDTO {
    public Integer id;
    private Movie movie;
    private User user;
    public LocalDate orderDate;

    public MovieOrderDTO(){}

    public MovieOrderDTO(Movie movie, User user, LocalDate orderDate){
        this.movie = movie;
        this.user = user;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
