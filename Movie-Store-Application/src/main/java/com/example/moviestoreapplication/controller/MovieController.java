package com.example.moviestoreapplication.controller;

import com.example.moviestoreapplication.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping()
    public String getHome(Model model){
        model.addAttribute("books", movieService.getAllMovies());
        return "index";
    }
}
