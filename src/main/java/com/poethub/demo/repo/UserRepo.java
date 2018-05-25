package com.poethub.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.poethub.demo.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer> {
		List<UserModel> findByUsername(String username);
		List<UserModel> findByEmail(String email);
}
