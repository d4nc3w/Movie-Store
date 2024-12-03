package com.example.moviestoreapplication.model;

import com.example.moviestoreapplication.authentication.User;

import java.util.Date;

public class OrderDTO {
    public Integer id;
    private Movie movie;
    private User user;
    public Date orderDate;

    public OrderDTO(){}

    public OrderDTO(Movie movie, User user, Date orderDate){
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
