package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Transport;

public interface TransportService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Transport> arg0);

	void delete(Transport arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	List<Transport> findAll();

	Iterable<Transport> findAll(Iterable<Integer> arg0);

	Transport findOne(Integer arg0);

	<S extends Transport> Iterable<S> save(Iterable<S> arg0);

	<S extends Transport> S save(S arg0);
	
	<S extends Transport> S save(S arg0,String cin,String cinAide,String voiture) ;

	List<Transport> findActive();

}