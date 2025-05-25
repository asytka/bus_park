package com.asytka.bus_park.controller;

import com.asytka.bus_park.model.User;
import com.asytka.bus_park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login"; // name of the HTML file
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("message", "Login Successful");
            return "redirect:index"; // redirect to home page
        }
        model.addAttribute("message", "Invalid Credentials");
        return "login"; // back to login page
    }
}
