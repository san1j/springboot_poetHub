package com.poethub.demo.service;

import java.util.List;
import java.util.Optional;

import com.poethub.demo.model.UserModel;

public interface UserService {
		public void saveUser(UserModel userModel);
		List<UserModel> findByUsername(String username);
		List<UserModel> findByEmail(String email);
}
