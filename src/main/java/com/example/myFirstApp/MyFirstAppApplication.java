package com.example.myFirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import javax.mail.MessagingException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootApplication
@Controller
public class MyFirstAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstAppApplication.class, args);
    }

    @Autowired
    private MailService mailService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("userForm") UserForm userForm, Model model) {

        String filePath = "src/main/resources/About.txt";

        try (FileWriter userDetails = new FileWriter(filePath, true)) {
            userDetails.write("-----Filed Records--------📝 \n" + LocalDateTime.now() + "---\n");
            userDetails.write("Name: " + userForm.getName() + " \n");
            userDetails.write("Email: " + userForm.getEmail() + " \n");
            userDetails.write("Address: " + userForm.getAddress() + " \n");
            userDetails.write("Hobby: " + userForm.getHobby() + " \n");
            userDetails.write("Phone Number: " + userForm.getPhone() + " \n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Send the email
        try {
            String recipientEmail = userForm.getEmail(); // Replace with the recipient's email
            String subject = "New Form Submission - " + userForm.getName();
            String body = "A new form submission has been received from " + userForm.getName() + ".\n" +
                    "Email: " + userForm.getEmail() + "\n" +
                    "See the attached file for details.";
            mailService.sendEmailWithAttachment(recipientEmail, subject, body, filePath);
            model.addAttribute("emailMessage", "Email sent successfully with attachment!");
        } catch (Exception e) { // Catching a more generic exception
            e.printStackTrace();
            model.addAttribute("emailMessage", "Error sending email: " + e.getMessage());
        }
        model.addAttribute("userForm", userForm);
        return "result";
    }
}