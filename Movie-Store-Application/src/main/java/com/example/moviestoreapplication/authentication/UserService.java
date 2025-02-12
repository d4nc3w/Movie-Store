package com.example.moviestoreapplication.authentication;

import com.example.moviestoreapplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDTOMapper userDTOMapper;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper){
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    public Optional<UserDTO> findUserCredentialsByEmail(String email){
        return userRepository.findByEmail(email).map(userDTOMapper::map);
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
        return authentication.getName();
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = findUserCredentialsByEmail(authentication.getName()).get();
        return userRepository.findByEmail(userDTO.getEmail()).get();
    }

    @Transactional
    public void registerClient(UserRegisterDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword("{SHA-256}" + new MessageDigestPasswordEncoder("SHA-256").encode(userDTO.getPassword()));
        user.setRole("CLIENT");
        userRepository.save(user);
    }

    public Page<User> getPaginatedUsers(int page, int size) {
         Page<User> userPage = userRepository.findAll(PageRequest.of(page, size));
        return userPage;
    }
}
