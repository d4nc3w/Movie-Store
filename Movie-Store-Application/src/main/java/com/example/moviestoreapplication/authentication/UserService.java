package com.example.moviestoreapplication.authentication;

import com.example.moviestoreapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> findUserCredentialsByEmail(String email){
        return userRepository.findByEmail(email)
                .map(UserDTOMapper::map);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUserByEmail(String email){
        userRepository.deleteByEmail(email);
    }

    public String findRolesByEmail(String email){
        Optional<UserDTO> user = findUserCredentialsByEmail(email);
        if (user.isPresent()){
            return user.get().getRole();
        }
        return "";
    }
}
