package com.example.moviestoreapplication.authentication;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDTOMapper {

    public static UserDTO map(User user){
        return new UserDTO(
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }
}
