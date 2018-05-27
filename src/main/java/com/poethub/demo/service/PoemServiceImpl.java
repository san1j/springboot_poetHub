package com.poethub.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poethub.demo.model.PoemModel;
import com.poethub.demo.model.UserModel;
import com.poethub.demo.repo.PoemRepo;

@Service
public class PoemServiceImpl implements PoemService{
	@Autowired
	private PoemRepo poemRepo;
	
	@Override
	public void savePoem(PoemModel poemModel) {
		poemRepo.saveAndFlush(poemModel);
	}

	@Override
	public List<PoemModel> findAllByOrderByPoemIdDesc() {
		return poemRepo.findAllByOrderByPoemIdDesc();
	}

	@Override
	public List<PoemModel> findAllByUserModelOrderByPoemIdDesc(UserModel userModel) {
		return poemRepo.findAllByUserModelOrderByPoemIdDesc(userModel);
	}

	@Override
	public PoemModel findByPoemId(int poemId) {
		return poemRepo.findByPoemId(poemId);
	}

	@Override
	public void deletePoem(PoemModel poemModel) {
		poemRepo.delete(poemModel);
	}

}
