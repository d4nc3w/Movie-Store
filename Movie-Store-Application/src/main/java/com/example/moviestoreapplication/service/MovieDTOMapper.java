package com.example.moviestoreapplication.service;

import com.example.moviestoreapplication.model.Movie;
import com.example.moviestoreapplication.model.MovieDTO;
import org.springframework.stereotype.Service;

@Service
public class MovieDTOMapper {
    public MovieDTO map(Movie movie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setPrice(movie.getPrice());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setAvailable(movie.isAvailable());
        return movieDTO;
    }

    public Movie map(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setId(movieDTO.getId());
        movie.setDirector(movieDTO.getDirector());
        movie.setPrice(movieDTO.getPrice());
        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setAvailable(movieDTO.isAvailable());
        return movie;
    }
}
