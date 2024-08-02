package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.*;

public interface InscriptionService {

	void delete(Inscription arg0);

	void delete(Integer arg0);

	void deleteAll();

	List<Inscription> findAll();

	Inscription findOne(Integer arg0);

	<S extends Inscription> S save(S arg0);

	<S extends Inscription> S saveAndFlush(S arg0);
	
	Inscription save(Inscription ins,String email);

}