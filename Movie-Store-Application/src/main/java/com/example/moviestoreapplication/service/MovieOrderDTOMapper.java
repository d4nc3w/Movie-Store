package com.example.moviestoreapplication.service;

import com.example.moviestoreapplication.model.MovieOrder;
import com.example.moviestoreapplication.model.MovieOrderDTO;
import org.springframework.stereotype.Service;

@Service
public class MovieOrderDTOMapper {
    public MovieOrderDTO map(MovieOrder movieOrder){
        MovieOrderDTO movieOrderDTO = new MovieOrderDTO();
        movieOrderDTO.setId(movieOrder.getId());
        movieOrderDTO.setMovie(movieOrder.getMovie());
        movieOrderDTO.setUser(movieOrder.getUser());
        movieOrderDTO.setOrderDate(movieOrder.getOrder_Date());
        movieOrderDTO.setTitle(movieOrder.getTitle());
        movieOrderDTO.setFirstName(movieOrder.getFirstName());
        movieOrderDTO.setLastName(movieOrder.getLastName());
        movieOrderDTO.setEmail(movieOrder.getEmail());
        movieOrderDTO.setAddress(movieOrder.getAddress());
        movieOrderDTO.setCity(movieOrder.getCity());
        movieOrderDTO.setPrice(movieOrder.getPrice());
        movieOrderDTO.setCard_Number(movieOrder.getCard_Number());
        return movieOrderDTO;
    }

    public MovieOrder map(MovieOrderDTO movieOrderDTO){
        MovieOrder movieOrder = new MovieOrder();
        movieOrder.setId(movieOrderDTO.getId());
        movieOrder.setMovie(movieOrderDTO.getMovie());
        movieOrder.setUser(movieOrderDTO.getUser());
        movieOrder.setOrder_Date(movieOrderDTO.getOrderDate());
        movieOrder.setTitle(movieOrderDTO.getTitle());
        movieOrder.setFirstName(movieOrderDTO.getFirstName());
        movieOrder.setLastName(movieOrderDTO.getLastName());
        movieOrder.setEmail(movieOrderDTO.getEmail());
        movieOrder.setAddress(movieOrderDTO.getAddress());
        movieOrder.setCity(movieOrderDTO.getCity());
        movieOrder.setPrice(movieOrderDTO.getPrice());
        movieOrder.setCard_Number(movieOrderDTO.getCard_Number());
        return movieOrder;
    }
}
