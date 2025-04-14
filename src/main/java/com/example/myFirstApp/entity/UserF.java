package com.example.myFirstApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserF {

    @Id
    private String id; 

    private String name;
    private String email;
    private String address;
    private String phone;
    private String hobby;
    private String password;

    
    public UserF(String name, String email, String address, String hobby, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.hobby = hobby;
        this.phone = phone;
    }

    
    public UserF(String name, String email, String address, String phone, String hobby, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.hobby = hobby;
        this.password = password;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}