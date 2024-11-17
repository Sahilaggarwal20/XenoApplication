package com.xeno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home() {
        return "index"; // Public landing page
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Redirect here after successful login
    }

    @GetMapping("/login")
    public String login() {
        return "index"; // Custom login page
    }
}
