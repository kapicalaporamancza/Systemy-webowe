package com.example.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.securitydemo.models.User;


@Controller
public class UserController {

    @GetMapping("/admin/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/createUser";
    }

    @Autowired
        private UserRepository userRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;

        @PostMapping("/admin/createUser")
            public String handleCreateUser(@ModelAttribute User user) {
            // check if user name already exists
            System.out.println(user.getUserName());
            System.out.println(userRepository.findByUserName(user.getUserName())!=null);
            if(userRepository.findByUserName(user.getUserName()).isPresent()) {
                // return error message
                return "redirect:/admin/createUser?error=username_exists";
            }
            // encrypt password
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            // save user
            userRepository.save(user);
            return "redirect:/";
}
}
