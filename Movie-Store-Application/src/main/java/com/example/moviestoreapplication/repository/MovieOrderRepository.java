package com.example.moviestoreapplication.repository;

import com.example.moviestoreapplication.model.MovieOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("SELECT o FROM MovieOrder o WHERE o.customerEmail = :customerEmail")
    Page<MovieOrder> findOrdersByCustomerEmail(@Param("customerEmail") String customerEmail, Pageable pageable);

    @Query("SELECT mo FROM MovieOrder mo JOIN FETCH mo.movie JOIN FETCH mo.user")
    Page<MovieOrder> findAllOrdersWithDetails(Pageable pageable);


}
