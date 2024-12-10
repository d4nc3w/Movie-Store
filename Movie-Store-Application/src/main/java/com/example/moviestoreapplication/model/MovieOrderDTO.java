package com.example.moviestoreapplication.model;

import com.example.moviestoreapplication.authentication.User;

import java.time.LocalDate;

public class MovieOrderDTO {
    public Integer id;
    private Movie movie;
    private User user;
    public String FirstName;
    public String LastName;
    public String Email;
    public String Address;
    public String City;
    public double Price;
    public String Card_Number;
    public LocalDate orderDate;

    public MovieOrderDTO(){}

    public MovieOrderDTO(Movie movie, User user, LocalDate orderDate, String FirstName, String LastName, String Email, String Address, String City, double Price, String Card_Number){
        this.movie = movie;
        this.user = user;
        this.orderDate = orderDate;
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

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
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

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCard_Number() {
        return Card_Number;
    }

    public void setCard_Number(String card_Number) {
        Card_Number = card_Number;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
