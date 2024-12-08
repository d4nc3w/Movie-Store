package com.example.moviestoreapplication.service;

import com.example.moviestoreapplication.model.Movie;
import com.example.moviestoreapplication.model.MovieDTO;
import com.example.moviestoreapplication.repository.MovieOrderRepository;
import com.example.moviestoreapplication.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private MovieOrderRepository movieOrderRepository;
    private MovieDTOMapper movieDTOMapper;

    public MovieService(MovieRepository movieRepository, MovieDTOMapper movieDTOMapper, MovieOrderRepository movieOrderRepository){
        this.movieRepository = movieRepository;
        this.movieDTOMapper = movieDTOMapper;
        this.movieOrderRepository = movieOrderRepository;
    }

    public List<MovieDTO> getAllMovies(){
        Iterable<Movie> movies = movieRepository.findAll();
        List<MovieDTO> moviesDTO = new ArrayList<>();
        for(Movie m : movies){
            movieDTOMapper.map(m);
            moviesDTO.add(movieDTOMapper.map(m));
        }
        return moviesDTO;
    }

    public Optional<Movie> findMovieById(Integer id) {
        return movieRepository.findById(id);
    }

    @Transactional
    public void addMovie(MovieDTO movieDTO){
        movieRepository.save(movieDTOMapper.map(movieDTO));
    }

    @Transactional
    public void updateMovie(MovieDTO movieDTO) {
        movieRepository.save(movieDTOMapper.map(movieDTO));
    }

    @Transactional
    public void deleteMovie(Integer id) {
        movieOrderRepository.deleteAllByMovieId(id);
        movieRepository.deleteById(id);
    }
}
