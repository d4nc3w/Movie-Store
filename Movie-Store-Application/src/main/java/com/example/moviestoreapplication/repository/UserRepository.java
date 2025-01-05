package com.example.moviestoreapplication.repository;

import com.example.moviestoreapplication.authentication.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void deleteByEmail(String email);
    void save(User user);
}
