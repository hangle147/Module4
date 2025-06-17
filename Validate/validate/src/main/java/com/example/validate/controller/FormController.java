package com.example.validate.controller;

import com.example.validate.model.User;
import com.example.validate.repository.UserRepository;
import com.example.validate.service.UserService;
import jakarta.validation.Valid;
import org.hibernate.engine.jdbc.mutation.spi.BindingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid User user,
                           BindingResult result) {
        if (userRepository.existsByEmail(user.getEmail())) {
            result.rejectValue("email", "Lỗi người dùng", "Email đã tồn tại");
        }

        if (result.hasErrors()) {
            return "index";
        }

        userService.save(user);
        return "result";
    }
}
