package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.FemmeDeMenage;

public interface FemmeDeMenageService {

	void delete(FemmeDeMenage arg0);

	void delete(Long arg0);

	void deleteAll();

	List<FemmeDeMenage> findAll();

	FemmeDeMenage findOne(Long arg0);

	<S extends FemmeDeMenage> S save(S arg0);

}