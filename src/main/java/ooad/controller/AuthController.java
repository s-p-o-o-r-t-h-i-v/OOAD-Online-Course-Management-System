package ooad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ooad.service.AuthService;
import ooad.model.User;

@Controller
public class AuthController {

    @Autowired
    AuthService service;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // REGISTER USER
    @PostMapping("/register")
    public String register(User user, Model model) {

        User existingUser = service.findByEmail(user.getEmail());

        if(existingUser != null){
            model.addAttribute("error","Email already exists!");
            return "register";
        }

        service.register(user);

        return "redirect:/";
    }

    // LOGIN USER
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        User user = service.login(email, password);

        if (user != null) {
            return "dashboard";
        }

        model.addAttribute("error","Invalid Email or Password!");

        return "login";
    }
}