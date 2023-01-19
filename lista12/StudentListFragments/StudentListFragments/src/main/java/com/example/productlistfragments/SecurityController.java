package com.example.productlistfragments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/adm")
    public String adminPage(){
        return "admin";
    }
    @GetMapping("/user")
    public String userPage(){
        return "user";
    }
}
