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
    public String landingPage() {
        return "entry";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "redirect:/register/student";
    }

    @GetMapping("/login/{role}")
    public String roleLoginPage(@PathVariable String role, Model model) {
        String normalizedRole = normalizeRole(role);
        model.addAttribute("role", normalizedRole);
        model.addAttribute("roleDisplay", toDisplayRole(normalizedRole));
        model.addAttribute("signupUrl", "/register/" + normalizedRole.toLowerCase());
        return "login";
    }

    @GetMapping("/register/{role}")
    public String roleRegisterPage(@PathVariable String role, Model model) {
        String normalizedRole = normalizeRole(role);
        model.addAttribute("role", normalizedRole);
        model.addAttribute("roleDisplay", toDisplayRole(normalizedRole));
        model.addAttribute("loginUrl", "/login/" + normalizedRole.toLowerCase());
        return "register";
    }

    // REGISTER USER
    @PostMapping("/register")
    public String register(User user,
            @RequestParam(required = false) String role,
            Model model) {

        String normalizedRole = normalizeRole(role != null ? role : user.getRole());
        user.setRole(normalizedRole);

        User existingUser = service.findByEmail(user.getEmail());

        if (existingUser != null) {
            model.addAttribute("error", "Email already exists!");
            model.addAttribute("role", normalizedRole);
            model.addAttribute("roleDisplay", toDisplayRole(normalizedRole));
            model.addAttribute("loginUrl", "/login/" + normalizedRole.toLowerCase());
            return "register";
        }

        service.register(user);

        return "redirect:/login/" + normalizedRole.toLowerCase();
    }

    // LOGIN USER
    @PostMapping("/login")
    public String login(@RequestParam String email,
            @RequestParam String password,
            @RequestParam(required = false) String role,
            Model model) {

        String selectedRole = normalizeRole(role);

        User user = service.login(email, password);

        if (user != null) {
            if (!selectedRole.equalsIgnoreCase(user.getRole())) {
                model.addAttribute("error", "This account is for " + toDisplayRole(user.getRole()) + ". Please use the correct login option.");
                model.addAttribute("role", selectedRole);
                model.addAttribute("roleDisplay", toDisplayRole(selectedRole));
                model.addAttribute("signupUrl", "/register/" + selectedRole.toLowerCase());
                return "login";
            }

            // Route to admin dashboard if role is ADMIN
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                return "redirect:/admin/dashboard";
            }
            // Route instructor
            if ("INSTRUCTOR".equalsIgnoreCase(user.getRole())) {
                return "redirect:/instructor/dashboard";
            }
            // Default: student dashboard
            return "dashboard";
        }

        model.addAttribute("error", "Invalid Email or Password!");
        model.addAttribute("role", selectedRole);
        model.addAttribute("roleDisplay", toDisplayRole(selectedRole));
        model.addAttribute("signupUrl", "/register/" + selectedRole.toLowerCase());
        return "login";
    }

    private String normalizeRole(String role) {
        if (role == null) {
            return "STUDENT";
        }
        String value = role.trim().toUpperCase();
        if (!"STUDENT".equals(value) && !"INSTRUCTOR".equals(value) && !"ADMIN".equals(value)) {
            return "STUDENT";
        }
        return value;
    }

    private String toDisplayRole(String role) {
        if ("INSTRUCTOR".equalsIgnoreCase(role)) {
            return "Instructor";
        }
        if ("ADMIN".equalsIgnoreCase(role)) {
            return "Admin";
        }
        return "Student";
    }
}