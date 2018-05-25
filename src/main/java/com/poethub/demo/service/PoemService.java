package com.poethub.demo.service;

 
import java.util.List;

import com.poethub.demo.model.PoemModel;
import com.poethub.demo.model.UserModel;

 public interface PoemService {
	public void savePoem(PoemModel poemModel);
	List<PoemModel>findAllByOrderByPoemIdDesc();
	List<PoemModel>findAllByUserModelOrderByPoemIdDesc(UserModel userModel);
}
