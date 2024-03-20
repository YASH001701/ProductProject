package com.example.ProductProject.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.apache.catalina.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ProductProject.Entity.User;
import com.example.ProductProject.Repository.UserRepository;
import com.example.ProductProject.Service.UserService;
import com.example.ProductProject.utility.ResponseStructure;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	private ResponseStructure<User> structure;
	
	@Override
	public ResponseEntity<ResponseStructure<User>> addUser(User user){
		User uniqueUser=userRepository.save(user);
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("")
				.setData(uniqueUser));
	}


}
