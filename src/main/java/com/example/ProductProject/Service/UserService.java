package com.example.ProductProject.Service;

import org.springframework.http.ResponseEntity;

import com.example.ProductProject.Entity.User;
import com.example.ProductProject.utility.ResponseStructure;

public interface UserService {
	ResponseEntity<ResponseStructure<User>> addUser(User user);
}
