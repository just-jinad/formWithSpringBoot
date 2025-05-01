package com.example.myFirstApp.controller;

import com.example.myFirstApp.MailService;
import com.example.myFirstApp.entity.Role;
import com.example.myFirstApp.entity.User;
import com.example.myFirstApp.repo.RoleRepository;
import com.example.myFirstApp.repo.UserRepo;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.HashSet;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private MailService mailService;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            logger.error("Validation errors: {}", result.getAllErrors());
            return "register";
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("errorMessage", "Email already exists. Please use a different email.");
            return "register";
        }

        String filePath = "src/main/resources/About.txt";
        user.setName(user.getName().trim());
        user.setEmail(user.getEmail().trim());
        user.setHobby(user.getHobby() != null ? user.getHobby().trim() : null);
        user.setAddress(user.getAddress() != null ? user.getAddress().trim() : null);
        user.setPhone(user.getPhone() != null ? user.getPhone().trim() : null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Error: Role ROLE_USER is not found."));
        user.setRoles(new HashSet<>());
        user.getRoles().add(userRole);

        userRepository.save(user);
        model.addAttribute("message", "User data saved to MySQL successfully!");

        try {
            String recipientEmail = user.getEmail();
            String subject = "Dear Admin";
            String body = "Below is a list of all applicants details " + user.getName() + ".\n" +
                    "See the attached file for details.";
            mailService.sendEmailWithAttachment(recipientEmail, subject, body, filePath);
            model.addAttribute("emailMessage", "Email sent successfully with attachment!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("emailMessage", "Error sending email: " + e.getMessage());
        }
        model.addAttribute("userForm", user);
        return "result";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('USER')")
    public String showUsers(Model model, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("users", Collections.singletonList(user));
        return "users";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAdminPanel(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }

    @PostMapping("/update-user")
    @PreAuthorize("hasRole('USER')")
    public String updateUser(@Valid @ModelAttribute User user, BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update user due to validation errors.");
            return "redirect:/users";
        }
        try {
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            } else {
                User existingUser = userRepository.findById(user.getId()).orElse(null);
                if (existingUser != null) {
                    user.setPassword(existingUser.getPassword());
                }
            }
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("successMessage", "User updated successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update user: " + e.getMessage());
        }
        return "redirect:/users";
    }

    @PostMapping("/delete-user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            userRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete user: " + e.getMessage());
        }
        return "redirect:/admin";
    }
}