package com.poethub.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poethub.demo.model.PoemModel;
import com.poethub.demo.model.UserModel;

public interface PoemRepo extends JpaRepository<PoemModel,Integer> {
	List<PoemModel>findAllByOrderByPoemIdDesc();
	List<PoemModel>findAllByUserModelOrderByPoemIdDesc(UserModel userModel);
	PoemModel findByPoemId(int poemId);
	}
