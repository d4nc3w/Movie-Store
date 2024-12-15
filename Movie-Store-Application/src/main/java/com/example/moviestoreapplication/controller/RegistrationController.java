package com.example.moviestoreapplication.controller;

import com.example.moviestoreapplication.authentication.UserRegisterDTO;
import com.example.moviestoreapplication.authentication.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/client")
    public String registerReaderForm(Model model) {
        model.addAttribute("user", new UserRegisterDTO());
        return "client-registration-form";
    }

    @PostMapping("/client")
    public String registerReader(UserRegisterDTO user) {
        userService.registerClient(user);
        return "redirect:/register/confirm";
    }

    @GetMapping("/confirm")
    public String confirm() {
        return "registration-confirm";
    }
}

