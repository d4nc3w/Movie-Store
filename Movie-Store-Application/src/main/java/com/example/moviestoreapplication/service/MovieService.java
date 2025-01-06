package com.example.moviestoreapplication.service;

import com.example.moviestoreapplication.authentication.UserService;
import com.example.moviestoreapplication.model.Movie;
import com.example.moviestoreapplication.model.MovieDTO;
import com.example.moviestoreapplication.model.MovieOrder;
import com.example.moviestoreapplication.model.MovieOrderDTO;
import com.example.moviestoreapplication.repository.MovieOrderRepository;
import com.example.moviestoreapplication.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final UserService userService;
    private MovieRepository movieRepository;
    private MovieOrderRepository movieOrderRepository;
    private MovieDTOMapper movieDTOMapper;
    private MovieOrderDTOMapper movieOrderDTOMapper;

    public MovieService(MovieRepository movieRepository, MovieDTOMapper movieDTOMapper, MovieOrderRepository movieOrderRepository, MovieOrderDTOMapper movieOrderDTOMapper, UserService userService){
        this.movieRepository = movieRepository;
        this.movieDTOMapper = movieDTOMapper;
        this.movieOrderRepository = movieOrderRepository;
        this.movieOrderDTOMapper = movieOrderDTOMapper;
        this.userService = userService;
    }

    public List<MovieDTO> getAllMovies(){
        Iterable<Movie> movies = movieRepository.findAll();
        List<MovieDTO> moviesDTO = new ArrayList<>();
        for(Movie m : movies){
            movieDTOMapper.map(m);
            moviesDTO.add(movieDTOMapper.map(m));
        }
        return moviesDTO;
    }

    public Optional<Movie> findMovieById(Integer id) {
        return movieRepository.findById(id);
    }

    @Transactional
    public void addMovie(MovieDTO movieDTO){
        movieRepository.save(movieDTOMapper.map(movieDTO));
    }

    @Transactional
    public void updateMovie(MovieDTO movieDTO) {
        movieRepository.save(movieDTOMapper.map(movieDTO));
    }

    @Transactional
    public void deleteMovie(Integer id) {
        movieOrderRepository.deleteAllByMovieId(id);
        movieRepository.deleteById(id);
    }

    @Transactional
    public void orderMovie(MovieOrderDTO movieOrderDTO, Integer movieID) {
        Movie movie = movieRepository.findById(movieID)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        MovieOrder movieOrder = new MovieOrder();
        movieOrder.setMovie(movie);
        movieOrder.setUser(userService.getCurrentUser());
        movieOrder.setTitle(movie.getTitle());
        movieOrder.setOrder_Date(LocalDate.now());
        movieOrder.setFirstName(movieOrderDTO.getFirstName());
        movieOrder.setLastName(movieOrderDTO.getLastName());
        movieOrder.setEmail(userService.getCurrentUserEmail());
        movieOrder.setAddress(movieOrderDTO.getAddress());
        movieOrder.setCity(movieOrderDTO.getCity());
        movieOrder.setPrice(movie.Price);
        movieOrder.setCard_Number(movieOrderDTO.getCard_Number());
        movieOrderRepository.save(movieOrder);
    }

//    public List<MovieOrderDTO> getAllOrders(){
//        Iterable<MovieOrder> orders = movieOrderRepository.findAll();
//        List<MovieOrderDTO> ordersDTO = new ArrayList<>();
//        for(MovieOrder m : orders){
//            movieOrderDTOMapper.map(m);
//            ordersDTO.add(movieOrderDTOMapper.map(m));
//        }
//        return ordersDTO;
//    }

    public Page<MovieOrderDTO> getAllOrders(int page, int size) {
        Page<MovieOrder> ordersPage = movieOrderRepository.findAll(PageRequest.of(page, size));
        return ordersPage.map(movieOrderDTOMapper::map);
    }

    public Page<MovieDTO> getPaginatedMovies(int page, int size) {
         Page<Movie> moviesPage = movieRepository.findAll(PageRequest.of(page, size));
         return moviesPage.map(movieDTOMapper::map);
    }

    public Optional<Object> findMovieOrderById(Integer id) {
        return movieOrderRepository.findById(id);
    }
}
