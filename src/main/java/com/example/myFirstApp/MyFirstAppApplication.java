package com.example.myFirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

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
        
        try(FileWriter userDetails = new FileWriter("src/main/resources/About.txt", true)){
            userDetails.write("-----Filed Records--------📝 \n"+ LocalDateTime.now() + "---\n");
            userDetails.write("Name: " + userForm.getName() + " \n");
            userDetails.write("Email: " + userForm.getEmail() + " \n");
            userDetails.write("Address: " + userForm.getAddress() + " \n");
            userDetails.write("Hobby: " + userForm.getHobby() + " \n");
            userDetails.write("Phone Number: " + userForm.getPhone() + " \n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        model.addAttribute("userForm", userForm);
        return "result";
    }
}