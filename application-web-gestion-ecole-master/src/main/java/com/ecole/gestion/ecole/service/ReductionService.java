package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Reduction;

public interface ReductionService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Reduction> arg0);

	void delete(Reduction arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	List<Reduction> findAll();

	Iterable<Reduction> findAll(Iterable<Integer> arg0);

	Reduction findOne(Integer arg0);

	<S extends Reduction> Iterable<S> save(Iterable<S> arg0);

	<S extends Reduction> S save(S arg0);

}