package com.example.moviestoreapplication.repository;

import com.example.moviestoreapplication.model.MovieOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface MovieOrderRepository extends PagingAndSortingRepository<MovieOrder, Integer> {
    @Modifying
    @Query("DELETE FROM MovieOrder mo WHERE mo.movie.id = :movieId")
    void deleteAllByMovieId(@Param("movieId") Integer movieId);
    void save(MovieOrder movieOrder);
    Iterable<MovieOrder> findAll();
}
