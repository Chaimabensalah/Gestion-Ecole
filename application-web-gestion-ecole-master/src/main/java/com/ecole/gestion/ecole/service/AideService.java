package com.ecole.gestion.ecole.service;

import com.ecole.gestion.ecole.model.Aide;

public interface AideService {

	long count();

	void delete(Aide arg0);

	void delete(Long arg0);

	void delete(Iterable<? extends Aide> arg0);

	void deleteAll();

	boolean exists(Long arg0);

	Iterable<Aide> findAll();

	Iterable<Aide> findAll(Iterable<Long> arg0);

	Aide findOne(Long arg0);

	<S extends Aide> Iterable<S> save(Iterable<S> arg0);

	<S extends Aide> S save(S arg0);
	
	Aide findByCin(String arg0);
}