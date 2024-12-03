package com.example.moviestoreapplication.model;

import com.example.moviestoreapplication.authentication.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "`Order`")
public class Order {

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

    public LocalDate orderDate;

    public Order(){}

    public Order(Movie movie, User user, LocalDate orderDate){
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
