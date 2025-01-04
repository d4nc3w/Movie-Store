package com.example.moviestoreapplication.controller;

import com.example.moviestoreapplication.model.Movie;
import com.example.moviestoreapplication.model.MovieDTO;
import com.example.moviestoreapplication.model.MovieOrderDTO;
import com.example.moviestoreapplication.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

//    @GetMapping()
//    public String getHome(Model model){
//        model.addAttribute("movies", movieService.getAllMovies());
//        return "index";
//    }

    @GetMapping()
    public String getHome(
            @RequestParam(defaultValue = "1") int page,
            Model model) {
        Page<Movie> moviePage = movieService.getPaginatedMovies(page, 10);
        model.addAttribute("movies", moviePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moviePage.getTotalPages());
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

    @GetMapping("editMovie")
    public String updateBookForm(@RequestParam Integer id, Model model) {
        movieService.findMovieById(id).ifPresent(movie -> model.addAttribute("movie", movie));
        return "edit-movie";
    }

    @PostMapping("editMovie")
    public String editBook(@ModelAttribute("movie") MovieDTO movieDTO) {
        movieService.updateMovie(movieDTO);
        return "redirect:/";
    }

    @GetMapping("deleteMovie")
    public String deleteMovie(@RequestParam Integer id) {
        movieService.deleteMovie(id);
        return "redirect:/";
    }

    @GetMapping("orderMovie")
    public String orderMovieForm(@RequestParam  Integer id, Model model){
        movieService.findMovieById(id).ifPresent(movie -> model.addAttribute("movie", movie));
        model.addAttribute("movieOrder", new MovieOrderDTO());
        return "order-movie";
    }

    @PostMapping("orderMovie")
    public String orderMovie(@ModelAttribute("movieOrder") MovieOrderDTO movieOrderDTO, @RequestParam("movieId") Integer movieId) {
        movieService.orderMovie(movieOrderDTO, movieId);
        return "redirect:/";
    }

    @GetMapping("displayFullTable")
    public String displayFullTable(Model model){
        model.addAttribute("movies", movieService.getAllMovies());
        return "full-table";
    }
}
