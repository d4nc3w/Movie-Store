package com.example.moviestoreapplication.controller;

import com.example.moviestoreapplication.authentication.UserService;
import com.example.moviestoreapplication.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    UserService userService;
    MovieService movieService;

    public AdminController(UserService userService, MovieService movieService){
        this.userService = userService;
        this.movieService = movieService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("userEmails", userService.findAllUsers());
        return "admin-page";
    }


}
