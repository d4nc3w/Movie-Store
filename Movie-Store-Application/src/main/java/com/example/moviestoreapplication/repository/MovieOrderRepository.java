package com.example.moviestoreapplication.repository;

import com.example.moviestoreapplication.model.MovieOrder;
import org.springframework.data.repository.CrudRepository;

public interface MovieOrderRepository extends CrudRepository<MovieOrder, Integer>  {
}
