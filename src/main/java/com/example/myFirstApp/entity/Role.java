// package com.example.myFirstApp.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// import jakarta.persistence.ManyToMany;

// import java.util.HashSet;
// import java.util.Set;

// @Entity
// public class Role {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @ManyToMany(mappedBy = "roles")
//     private Set<User> users = new HashSet<>();

//     // Getters and Setters

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }
    
// }
