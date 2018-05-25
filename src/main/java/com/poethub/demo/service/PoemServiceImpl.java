package com.poethub.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poethub.demo.model.PoemModel;
import com.poethub.demo.repo.PoemRepo;

@Service
public class PoemServiceImpl implements PoemService{
	@Autowired
	private PoemRepo poemRepo;
	
	@Override
	public void savePoem(PoemModel poemModel) {
		poemRepo.save(poemModel);
		
	}

}
