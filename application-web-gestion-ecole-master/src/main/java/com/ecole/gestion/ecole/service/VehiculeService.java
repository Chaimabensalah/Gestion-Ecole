package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Vehicule;

public interface VehiculeService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Vehicule> arg0);

	void delete(Vehicule arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	List<Vehicule> findAll();

	Iterable<Vehicule> findAll(Iterable<Integer> arg0);

	Vehicule findOne(Integer arg0);

	<S extends Vehicule> Iterable<S> save(Iterable<S> arg0);

	<S extends Vehicule> S save(S arg0);
	
	Vehicule findbyMatricule(String matricule);

	List<Vehicule> findActive();

}