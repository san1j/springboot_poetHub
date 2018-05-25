package com.poethub.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poethub.demo.model.PoemModel;

public interface PoemRepo extends JpaRepository<PoemModel,Integer> {
}
