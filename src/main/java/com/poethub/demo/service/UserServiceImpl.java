package com.poethub.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poethub.demo.model.UserModel;
import com.poethub.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public void saveUser(UserModel userModel) {
		userRepo.save(userModel);
	}

	@Override
	public List<UserModel> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public List<UserModel> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	

	
}
