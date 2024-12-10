package com.example.moviestoreapplication.authentication;

import com.example.moviestoreapplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Transactional
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

    @Transactional
    public void updateUserRole(String email, String role) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()){
            user.get().setRole(role);
            userRepository.save(user.get());
        }
    }

    public String getCurrentUserEmail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = findUserCredentialsByEmail(authentication.getName()).get();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = findUserCredentialsByEmail(authentication.getName()).get();
        User user = userRepository.findByEmail(userDTO.getEmail()).get();
        return user;
    }
}
