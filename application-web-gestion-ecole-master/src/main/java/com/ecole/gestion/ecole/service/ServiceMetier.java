package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Servicee;

public interface ServiceMetier {

	long count();

	void delete(Integer arg0);

	void delete(com.ecole.gestion.ecole.model.Servicee arg0);

	void deleteAll();

	List<com.ecole.gestion.ecole.model.Servicee> findAll();

	com.ecole.gestion.ecole.model.Servicee findOne(Integer arg0);

	<S extends com.ecole.gestion.ecole.model.Servicee> List<S> save(Iterable<S> arg0);

	<S extends com.ecole.gestion.ecole.model.Servicee> S save(S arg0);

	<S extends com.ecole.gestion.ecole.model.Servicee> S saveAndFlush(S arg0);

	Servicee save(Servicee service, long id);

	Servicee findByEleve(String nomService, Eleve eleve);
	int findMoisNomPaye(long id,String service);

	List<Servicee> findServiceParEleve(long idPersonne);

}