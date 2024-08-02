package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Absence;
import com.ecole.gestion.ecole.model.Eleve;

public interface AbsenceService {

	long count();

	void delete(Absence arg0);

	void delete(Integer arg0);

	void delete(Iterable<? extends Absence> arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	List<Absence> findAll();

	Iterable<Absence> findAll(Iterable<Integer> arg0);

	Absence findOne(Integer arg0);

	<S extends Absence> Iterable<S> save(Iterable<S> arg0);

	<S extends Absence> S save(S arg0);

	<S extends Absence> S  saveAbsence(S arg0, String matriculeEleve,String matiere);

	 

	List<Absence> findParELeve(Eleve eleve);

	List<Absence> findParClasse(String nomclasse);
	

}