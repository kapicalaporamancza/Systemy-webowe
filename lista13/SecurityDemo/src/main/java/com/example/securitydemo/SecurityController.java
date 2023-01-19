package com.example.securitydemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/admin/admin")
    public String adminPage(){
        return "/admin/admin";
    }
    @GetMapping("/user")
    public String userPage(){
        return "user";
    }
}
