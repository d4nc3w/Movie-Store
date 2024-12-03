package com.example.moviestoreapplication.model;

import com.example.moviestoreapplication.authentication.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "movie_order")
public class MovieOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    public Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public LocalDate order_Date;

    public MovieOrder(){}

    public MovieOrder(Movie movie, User user, LocalDate order_Date){
        this.movie = movie;
        this.user = user;
        this.order_Date = order_Date;
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

    public LocalDate getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(LocalDate orderDate) {
        this.order_Date = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
