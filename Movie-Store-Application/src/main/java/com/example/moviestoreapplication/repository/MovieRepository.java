package com.example.moviestoreapplication.repository;

import com.example.moviestoreapplication.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
