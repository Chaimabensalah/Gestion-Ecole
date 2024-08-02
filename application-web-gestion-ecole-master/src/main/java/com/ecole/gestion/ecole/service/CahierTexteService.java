package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.*;

public interface CahierTexteService {

	long count();

	void delete(CahierTexte arg0);

	void delete(Integer arg0);

	void delete(Iterable<? extends CahierTexte> arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	List<CahierTexte> findAll();

	Iterable<CahierTexte> findAll(Iterable<Integer> arg0);

	CahierTexte findOne(Integer arg0);

	<S extends CahierTexte> Iterable<S> save(Iterable<S> arg0);

	<S extends CahierTexte> S save(S arg0);
	
	public <S extends CahierTexte> S saveCahierText(S arg0,String matiere,String classe) ;
	
	public CahierTexte findCahierParClasse(Classe classe);

	List<CahierTexte> findCahierParMatiere(String nomMatiere);
		

}