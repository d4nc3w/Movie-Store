package com.example.moviestoreapplication.controller;

import com.example.moviestoreapplication.authentication.UserService;
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
    private final UserService userService;
    private MovieService movieService;

    public MovieController(MovieService movieService, UserService userService){
        this.movieService = movieService;
        this.userService = userService;
    }

/*    @GetMapping()
    public String getHome(Model model){
        model.addAttribute("movies", movieService.getAllMovies());
        return "index";
    }*/

    @GetMapping()
    public String getHome(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<MovieDTO> moviePage = movieService.getPaginatedMovies(page, 10);
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
        model.addAttribute("customerEmail", userService.getCurrentUserEmail());
        return "order-movie";
    }

    @PostMapping("orderMovie")
    public String orderMovie(
            @ModelAttribute("movieOrder") MovieOrderDTO movieOrderDTO,
            @RequestParam("movieId") Integer movieId,
            @RequestParam("customerEmail") String customerEmail) {
        movieService.orderMovie(movieOrderDTO, movieId, customerEmail);
        return "order-confirm";
    }

    @GetMapping("displayFullTable")
    public String displayFullTable(@RequestParam(defaultValue = "0") int page, Model model){
        Page<MovieDTO> moviePage = movieService.getPaginatedMovies(page, 10);
        model.addAttribute("movies", moviePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moviePage.getTotalPages());
        return "full-table";
    }

    @GetMapping("/orders")
    public String orderList(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<MovieOrderDTO> ordersPage = movieService.getAllOrdersByEmail(page, 10);

        model.addAttribute("orders", ordersPage.getContent());
        model.addAttribute("currentPage", ordersPage.getNumber());
        model.addAttribute("totalPages", ordersPage.getTotalPages());

        return "orders";
    }

}
