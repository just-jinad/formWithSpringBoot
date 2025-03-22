package com.example.myFirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@SpringBootApplication
@Controller
public class MyFirstAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstAppApplication.class, args);
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm()); 
        return "register";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("userForm") UserForm userForm, Model model) {
        model.addAttribute("userForm", userForm);
        return "result";
    }
}