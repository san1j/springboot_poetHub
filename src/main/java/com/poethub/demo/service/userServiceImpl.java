package com.poethub.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poethub.demo.model.userModel;
import com.poethub.demo.repo.userRepo;

@Service
public class userServiceImpl implements userService {
	
	private final userRepo userRepo;
	
	@Autowired
	userServiceImpl(userRepo userRepo){
		this.userRepo = userRepo;
	}

	@Override
	public void saveUser(userModel userModel) {
		userRepo.save(userModel);
	}

	@Override
	public List<userModel> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public List<userModel> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
}
