package com.ecole.gestion.ecole.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecole.gestion.ecole.model.Fournisseur;

public interface FournisseurService {

	void delete(Fournisseur arg0);

	void delete(int arg0);

	List<Fournisseur> findAll();

	Fournisseur findByNom(String nom);

	Fournisseur findOne(int arg0);

	<S extends Fournisseur> S save(S arg0,String cin);
	
	<S extends Fournisseur> S save(S arg0);
	
	public Page<Fournisseur> findAll(Pageable arg0);

	List<Fournisseur> findActive();



}