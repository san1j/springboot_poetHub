package com.poethub.demo.service;

import java.util.List;
import java.util.Optional;

import com.poethub.demo.model.userModel;

public interface userService {
		public void saveUser(userModel userModel);
		List<userModel> findByUsername(String username);
		List<userModel> findByEmail(String email);
		
}
