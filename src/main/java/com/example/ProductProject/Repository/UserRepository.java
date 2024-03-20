package com.example.ProductProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductProject.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
