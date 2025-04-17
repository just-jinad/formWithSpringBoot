package com.example.myFirstApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;
    private String hobby;
    private String phone;
    private String password;

    public User() {
    }

    public User(String name, String email, String address, String hobby, String phone, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.hobby = hobby;
        this.phone = phone;
        this.password = password;
    }

    // Getters and Setters    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getHobby(){
        return hobby;
    }
    public void setHobby(String hobby){
        this.hobby = hobby;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
