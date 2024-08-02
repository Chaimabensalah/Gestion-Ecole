package com.ecole.gestion.ecole.service;

import com.ecole.gestion.ecole.model.Chauffeur;

public interface ChauffeurService {

	long count();

	void delete(Chauffeur arg0);

	void delete(long arg0);

	void delete(Iterable<? extends Chauffeur> arg0);

	void deleteAll();

	boolean exists(long arg0);

	Iterable<Chauffeur> findAll();

	//Iterable<Chauffeur> findAll(Iterable<Integer> arg0);

	Chauffeur findOne(long arg0);

	<S extends Chauffeur> Iterable<S> save(Iterable<S> arg0);

	<S extends Chauffeur> S save(S arg0);

	Chauffeur findByCin(String cin);

}