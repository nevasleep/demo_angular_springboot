package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByUsername(String username);
	
//	Optional<Users> findByEmail(String email);
	
}
