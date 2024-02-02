package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UsersController
{
	@Autowired
	UsersService userv;

	//  Another Method to check Email
	//	@PostMapping("/register")
	//	public String addUser(@ModelAttribute Users user)
	//	
	//	{
	//		String msg=userv.addUser(user);
	//		return msg; 
	//	}

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) 
	{
		boolean userstatus=userv.emailExists(user.getEmail());

		if(userstatus == false)
		{
			userv.addUser(user);
			System.out.println("User is added");
			return"registersuccess";
		}
		else {
			System.out.println("User is already exist");
		}
		
		return "registerfail";
		
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password) {

		if(userv.validateUser(email, password) == true)
		{
			if (userv.getRole(email).equals("admin")) {
				return"adminlogin";

			}
			else {
				return "customerlogin";
			}
		}
			else 
			{
				return "loginfail";
			}
		

	}
}

