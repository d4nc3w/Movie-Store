package com.example.moviestoreapplication.controller;

import com.example.moviestoreapplication.authentication.User;
import com.example.moviestoreapplication.authentication.UserDTO;
import com.example.moviestoreapplication.authentication.UserService;
import com.example.moviestoreapplication.model.MovieOrderDTO;
import com.example.moviestoreapplication.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    UserService userService;
    MovieService movieService;

    public AdminController(UserService userService, MovieService movieService){
        this.userService = userService;
        this.movieService = movieService;
    }

//    @GetMapping
//    public String index(Model model) {
//        model.addAttribute("userEmails", userService.findAllUsers());
//        return "admin-page";
//    }

    @GetMapping
    public String index(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<UserDTO> userPage = userService.getPaginatedUsers(page, 10);
        model.addAttribute("userEmails", userPage.getContent());
        model.addAttribute("currentPage", userPage.getNumber());
        model.addAttribute("totalPages", userPage.getTotalPages());
        return "admin-page";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam String email, Model model){
        userService.findUserCredentialsByEmail(email).ifPresent(user -> model.addAttribute("user", user));
        String role = userService.findRolesByEmail(email);
        model.addAttribute("role", role);
        return "edit-user";
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam String email, @RequestParam String role){
        userService.updateUserRole(email, role);
        return "redirect:/adminPage";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam String email){
        userService.deleteUserByEmail(email);
        return "redirect:/adminPage";
    }

    @GetMapping("/orderList")
    public String orderList(@RequestParam(defaultValue = "0") int page, Model model){
        Page<MovieOrderDTO> ordersPage = movieService.getAllOrders(page, 10);
        model.addAttribute("orders", ordersPage.getContent());
        model.addAttribute("currentPage", ordersPage.getNumber());
        model.addAttribute("totalPages", ordersPage.getTotalPages());
        return "order-list";
    }
}
