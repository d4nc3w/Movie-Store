package com.example.moviestoreapplication.repository;

import com.example.moviestoreapplication.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {

    Optional<Movie> findById(Integer id);
    void save(Movie movie);
    void deleteById(Integer id);
    Iterable<Movie> findAll();
}
