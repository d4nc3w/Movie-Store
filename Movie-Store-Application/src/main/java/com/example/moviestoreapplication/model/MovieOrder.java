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

    public String Title;
    public String FirstName;
    public String LastName;
    public String Email;
    public String Address;
    public String City;
    public double Price;
    public String Card_Number;

    public LocalDate order_Date;

    public MovieOrder(){}

    public MovieOrder(Movie movie, User user, LocalDate order_Date, String FirstName, String LastName, String Email, String Address, String City, double Price, String Card_Number, String Title){
        this.movie = movie;
        this.user = user;
        this.Title = Title;
        this.order_Date = order_Date;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Address = Address;
        this.City = City;
        this.Price = Price;
        this.Card_Number = Card_Number;
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

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getCard_Number() {
        return Card_Number;
    }

    public void setCard_Number(String card_Number) {
        Card_Number = card_Number;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
