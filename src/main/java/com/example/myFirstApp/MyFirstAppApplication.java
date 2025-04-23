package com.example.myFirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.beans.factory.annotation.Autowired;
// import com.example.myFirstApp.entity.User;
// import com.example.myFirstApp.repo.UserRepo;
// import com.example.myFirstApp.entity.UserF;
// import com.example.myFirstApp.repo.UserRepository;

// import org.springframework.ui.Model;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.time.LocalDateTime;

@SpringBootApplication

public class MyFirstAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstAppApplication.class, args);
    }

    // @Autowired
    // private MailService mailService;
    // @Autowired
    // // private UserRepository userRepository;
    // private UserRepo userRepo;

    // @GetMapping("/register")
    // public String showForm(Model model) {
    //     model.addAttribute("userForm", new UserForm());
    //     return "register";
    // }

    // @PostMapping("/submit")
    // public String submitForm(@ModelAttribute("userForm") UserForm userForm, Model model) {

    //     String filePath = "src/main/resources/About.txt";

    //     User user = new User(userForm.getName(), userForm.getEmail(), userForm.getAddress(), userForm.getHobby(),
    //             userForm.getPhone(), userForm.getPassword());
    //     userRepo.save(user);
    //     model.addAttribute("message", "User details saved successfully to mongodb!");

    //     try {
    //         String recipientEmail = userForm.getEmail();
    //         String subject = "Dear Admin";
    //         String body = "Below is a list of all applicants details " + userForm.getName() + ".\n" +
    //                 "See the attached file for details.";
    //         mailService.sendEmailWithAttachment(recipientEmail, subject, body, filePath);
    //         model.addAttribute("emailMessage", "Email sent successfully with attachment!");
    //     } catch (Exception e) { // Catching a more generic exception
    //         e.printStackTrace();
    //         model.addAttribute("emailMessage", "Error sending email: " + e.getMessage());
    //     }
    //     model.addAttribute("userForm", userForm);
    //     return "result";
    // }

    // @GetMapping("/users")
    // public String showUsers(Model model) {
    //     model.addAttribute("users", userRepo.findAll());
    //     return "users";
    // }

    // @PostMapping("/update-user")
    // public String updateUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
    //     try {
    //         userRepo.updateUser(user);
    //         redirectAttributes.addFlashAttribute("successMessage", "User updated successfully!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("errorMessage", "Failed to update user: " + e.getMessage());
    //     }
    //     return "redirect:/users"; 
    // }

    // @PostMapping("/delete-user/{id}")
    // public String deleteUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
    //     try {
    //         userRepo.deleteById(user.getId());
    //         redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully!");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete user: " + e.getMessage());
    //     }
    //     return "redirect:/users"; 
    // }
}




























// try (FileWriter userDetails = new FileWriter(filePath, true)) {
// userDetails.write("-----Filed Records--------📝 \n" + LocalDateTime.now() +
// "---\n");
// userDetails.write("Name: " + userForm.getName() + " \n");
// userDetails.write("Email: " + userForm.getEmail() + " \n");
// userDetails.write("Address: " + userForm.getAddress() + " \n");
// userDetails.write("Hobby: " + userForm.getHobby() + " \n");
// userDetails.write("Phone Number: " + userForm.getPhone() + " \n");

// } catch (IOException e) {
// e.printStackTrace();
// }