package com.oneclick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneclick.entity.User;
import com.oneclick.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public User createUser(User user) {
		return userRepo.save(user);
	}

	public User validateLogin(String email, String password) {
		User user = userRepo.findByEmail(email);
		String oldPassword = user.getPassword();

		if (oldPassword.equals(password)) {
			return user;
		} else {
			return null;
		}
	}
}
