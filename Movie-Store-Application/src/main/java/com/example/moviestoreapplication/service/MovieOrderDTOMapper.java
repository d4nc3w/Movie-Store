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
        return movieOrderDTO;
    }

    public MovieOrder map(MovieOrderDTO movieOrderDTO){
        MovieOrder movieOrder = new MovieOrder();
        movieOrder.setId(movieOrderDTO.getId());
        movieOrder.setMovie(movieOrderDTO.getMovie());
        movieOrder.setUser(movieOrderDTO.getUser());
        movieOrder.setOrder_Date(movieOrderDTO.getOrderDate());
        return movieOrder;
    }
}
