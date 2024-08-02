package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Garde;
import com.ecole.gestion.ecole.model.Professeur;

public interface GardeService {

 

	void delete(Garde arg0);

	void delete(Long arg0);

	void delete(Iterable<? extends Garde> arg0);

	void deleteAll();

	boolean exists(Long arg0);

	List<Garde> findAll();

	Iterable<Garde> findAll(Iterable<Long> arg0);

	Garde findOne(Long arg0);

	<S extends Garde> Iterable<S> save(Iterable<S> arg0);

	<S extends Garde> S save(S arg0);
	
	<S extends Garde> S save(S arg0,String matricule,String matriculeAide);

	List<Garde> findActive();

	Professeur findProf(long id);

}