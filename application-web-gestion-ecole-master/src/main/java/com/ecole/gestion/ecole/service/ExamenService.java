package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Examen;

public interface ExamenService {

	long count();

	void delete(Examen arg0);

	void delete(Integer arg0);

	void delete(Iterable<? extends Examen> arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	Iterable<Examen> findAll();

	Iterable<Examen> findAll(Iterable<Integer> arg0);

	Examen findOne(Integer arg0);

	<S extends Examen> Iterable<S> save(Iterable<S> arg0);

	<S extends Examen> S save(S arg0);
	
	public <S extends Examen> S saveExam(S arg0,String matiere,String classe);

	List<Examen> findByEleve(String matricule);

	List<Examen> findParMatiere(String nomMatiere);

}