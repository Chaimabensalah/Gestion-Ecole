package com.ecole.gestion.ecole.service;

import com.ecole.gestion.ecole.model.Matiere;

public interface MatiereService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Matiere> arg0);

	void delete(Matiere arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	Iterable<Matiere> findAll();

	Iterable<Matiere> findAll(Iterable<Integer> arg0);

	Matiere findOne(Integer arg0);

	<S extends Matiere> Iterable<S> save(Iterable<S> arg0);

	<S extends Matiere> S save(S arg0);
	
	Matiere findByNom(String nom);

}