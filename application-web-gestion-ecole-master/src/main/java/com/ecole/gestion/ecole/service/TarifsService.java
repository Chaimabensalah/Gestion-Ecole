package com.ecole.gestion.ecole.service;

import com.ecole.gestion.ecole.model.Tarif;

public interface TarifsService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Tarif> arg0);

	void delete(Tarif arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	Iterable<Tarif> findAll();

	Iterable<Tarif> findAll(Iterable<Integer> arg0);

	Tarif findOne(Integer arg0);

	<S extends Tarif> Iterable<S> save(Iterable<S> arg0);

	<S extends Tarif> S save(S arg0);

	Tarif findByService(String service);

}