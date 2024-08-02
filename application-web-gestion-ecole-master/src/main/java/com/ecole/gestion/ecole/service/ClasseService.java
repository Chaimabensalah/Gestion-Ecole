package com.ecole.gestion.ecole.service;

import com.ecole.gestion.ecole.model.Classe;

public interface ClasseService {

	long count();

	void delete(Classe arg0);

	void delete(Integer arg0);

	void delete(Iterable<? extends Classe> arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	Iterable<Classe> findAll();

	Iterable<Classe> findAll(Iterable<Integer> arg0);

	Classe findOne(Integer arg0);

	<S extends Classe> Iterable<S> save(Iterable<S> arg0);

	<S extends Classe> S save(S arg0);
	
	public Classe findByNom(String name);

}