package com.example.moviestoreapplication.repository;

import com.example.moviestoreapplication.authentication.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    Optional<UserRole> findByName(String name);
}
