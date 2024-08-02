package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Facture;

public interface FactureService {

	long count();

	void delete(Facture arg0);

	void delete(Long arg0);

	void delete(Iterable<? extends Facture> arg0);

	void deleteAll();

	boolean exists(Long arg0);

	List<Facture> findAll();

	Iterable<Facture> findAll(Iterable<Long> arg0);

	Facture findOne(Long arg0);

	<S extends Facture> Iterable<S> save(Iterable<S> arg0);

	<S extends Facture> S save(S arg0);

	Facture save(Facture facture, String nomFournisseur);

	List<Facture> findActive();

}