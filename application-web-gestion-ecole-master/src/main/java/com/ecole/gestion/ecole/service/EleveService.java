package com.ecole.gestion.ecole.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Inscription;

public interface EleveService {

	void delete(Eleve arg0);

	void delete(Long arg0);

	List<Eleve> findAll();

	Eleve findOne(Long arg0);

	<S extends Eleve> S save( S e);
	
	void saveEleve(Eleve e);
	
	public Page<Eleve> findAll(Pageable arg0);
	
	//Eleve findOne(Eleve arg0);
	
   // public Eleve findLast(Long id);
    
   // public long getMax();
    
	public Page<Eleve> chercherEleves(String x, Pageable pageable) ;
	
	public Eleve findByMatricule(String arg0) ;
	
	List<Eleve> findElevesParClasse(Classe classe)	;

	Eleve saveEleve2(Eleve eleve);
	
	Eleve saveEleve(Eleve eleve,String cin);

	Eleve findByemail(String email);
	
	Inscription findCurrentInscription(Eleve eleve);
//	Eleve saveEleve(String cin, String email);

	List<Eleve> findActive();
	
	
}