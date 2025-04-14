package com.example.myFirstApp.repo;

import com.example.myFirstApp.entity.UserF;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserF, String> {
	
}