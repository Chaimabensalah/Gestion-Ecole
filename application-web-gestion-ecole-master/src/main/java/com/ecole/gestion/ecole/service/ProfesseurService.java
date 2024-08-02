package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Professeur;

public interface ProfesseurService {

	long count();

	void delete(Long arg0);

	void delete(Iterable<? extends Professeur> arg0);

	void delete(Professeur arg0);

	void deleteAll();
 

	Iterable<Professeur> findAll();

	Iterable<Professeur> findAll(Iterable<Long> arg0);

	Professeur findOne(Long arg0);
	
	Professeur findByCin(String arg0);

	<S extends Professeur> Iterable<S> save(Iterable<S> arg0);

	<S extends Professeur> S save(S arg0);

	List<Professeur> findActive();

}