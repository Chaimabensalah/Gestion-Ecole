package com.ecole.gestion.ecole.service;


import com.ecole.gestion.ecole.model.Paiement;

public interface PaiementService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Paiement> arg0);

	void delete(Paiement arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	Iterable<Paiement> findAll();

	Iterable<Paiement> findAll(Iterable<Integer> arg0);

	Paiement findOne(Integer arg0);

	<S extends Paiement> Iterable<S> save(Iterable<S> arg0);

	<S extends Paiement> S save(S arg0);

	Paiement save(Paiement paiement, String email,int typePaiement);
	//List<Integer> getPaiementParEleve(String matricule);

	Paiement save(Paiement paiement, long id, String nomService);

}