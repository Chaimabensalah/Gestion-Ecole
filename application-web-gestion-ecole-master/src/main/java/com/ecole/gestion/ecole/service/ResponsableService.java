package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.*;

public interface ResponsableService {

	void deleteAll();
	void delete(Long i);

	boolean exists(Long arg0);

	List<Responsable> findAll();

	Responsable findOne(Long arg0);
	//Responsable findOne(int arg0);

	<S extends Responsable> S save(S arg0);
	
	Responsable findParCin(String cin);
	 

}