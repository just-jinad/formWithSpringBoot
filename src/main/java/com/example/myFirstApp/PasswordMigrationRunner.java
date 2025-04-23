package com.example.myFirstApp;

import com.example.myFirstApp.entity.User;
import com.example.myFirstApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordMigrationRunner implements CommandLineRunner {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        for (User user : userRepository.findAll()) {
            String password = user.getPassword();
            if (password != null && !password.startsWith("$2a$")) {
                String encodedPassword = passwordEncoder.encode(password);
                user.setPassword(encodedPassword);
                userRepository.save(user);
            }
        }
        System.out.println("Password migration completed.");
    }
}