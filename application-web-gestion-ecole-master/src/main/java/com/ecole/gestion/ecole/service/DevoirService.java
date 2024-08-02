package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Devoir;
import com.ecole.gestion.ecole.model.Matiere;

public interface DevoirService {

	long count();

	void delete(Devoir arg0);

	void delete(Integer arg0);

	void delete(Iterable<? extends Devoir> arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	Iterable<Devoir> findAll();

	Iterable<Devoir> findAll(Iterable<Integer> arg0);

	Devoir findOne(Integer arg0);

	<S extends Devoir> Iterable<S> save(Iterable<S> arg0);

	<S extends Devoir> S save(S arg0);
	
	public <S extends Devoir> S saveDevoir(S arg0,String matiere,String classe);

	List<Devoir> findDevoirsParMatiere(Matiere matiere);

	List<Devoir> findDevoirsParEleve(String matricule);
}