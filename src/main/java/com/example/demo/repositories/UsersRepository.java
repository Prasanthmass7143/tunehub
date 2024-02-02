package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {


	//     boolean existsByEmail(String email);   --------->>>Another Method to check Email
	
	public Users findByEmail(String email);

}
