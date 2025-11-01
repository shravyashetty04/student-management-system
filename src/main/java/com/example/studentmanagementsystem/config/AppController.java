package com.example.studentmanagementsystem.config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    // Handles GET requests to "/login" and serves the "login.html" template
    @GetMapping("/login")
    public String login() {
        return "login"; // This returns "src/main/resources/templates/login.html"
    }

    // Handles the successful login redirect
    @GetMapping("/welcome")
    public String welcome() {
        // You should create a "welcome.html" template for this page
        return "welcome";
    }
}