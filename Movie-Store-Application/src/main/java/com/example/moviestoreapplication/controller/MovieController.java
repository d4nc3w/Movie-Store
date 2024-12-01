package com.example.moviestoreapplication.controller;

import com.example.moviestoreapplication.model.MovieDTO;
import com.example.moviestoreapplication.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping()
    public String getHome(Model model){
        model.addAttribute("movies", movieService.getAllMovies());
        return "index";
    }

    @GetMapping("addMovie")
    public String addBookForm(Model model) {
        model.addAttribute("movie", new MovieDTO());
        return "add-movie";
    }

    @PostMapping("addMovie")
    public String addBook(MovieDTO movieDTO) {
        movieService.addMovie(movieDTO);
        return "redirect:/";
    }

    @GetMapping("movie")
    public String getBook(@RequestParam Integer id, Model model){
        movieService.findMovieById(id).ifPresent(movie -> model.addAttribute("movie", movie));
        return "movie";
    }



}
