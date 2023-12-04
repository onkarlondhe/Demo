package com.oneclick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oneclick.entity.User;
import com.oneclick.service.UserService;

@RestController
@RequestMapping("/oneclick")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/createuser")
	public ResponseEntity<String> createUser(@RequestBody User user){
		User createUser =userService.createUser(user);
		if(createUser != null) {
			return new ResponseEntity<String>("User Create Successfully...",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Something Went Wrong",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/validateuser")
	public ResponseEntity<User> validateUser(@RequestParam String email, @RequestParam String password){
		User validatedUser = userService.validateLogin(email, password);

		if (validatedUser != null) {
			return new ResponseEntity<User>(validatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
