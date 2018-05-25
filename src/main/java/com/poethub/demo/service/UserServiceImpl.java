package com.poethub.demo.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

 import com.poethub.demo.model.UserModel;
 import com.poethub.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	public static final String roles = "USER";

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	 

	@Override
	public void saveUser(UserModel userModel) {
		//userModel.setRoles(Collections.singletonList( roleRepo.findByRole(roles)) );
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userModel.setRole(roles);
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
