package com.ecole.gestion.ecole.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.dao.ChauffeurRepository;
import com.ecole.gestion.ecole.model.Chauffeur;


@Service
public class ChauffeurMetierImpl implements ChauffeurService  {
	@Autowired
	private ChauffeurRepository chauffeurRepository;

	@Override
	public long count() {
		return chauffeurRepository.count();
	}

	@Override
	public void delete(Chauffeur arg0) {
		chauffeurRepository.delete(arg0);
	}

	@Override
	public void delete(long arg0) {
		chauffeurRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Chauffeur> arg0) {
		chauffeurRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		chauffeurRepository.deleteAll();
	}

	@Override
	public boolean exists(long arg0) {
		return chauffeurRepository.exists(arg0);
	}

	@Override
	public Iterable<Chauffeur> findAll() {
		return chauffeurRepository.findAll();
	}

	 

	@Override
	public Chauffeur findOne(long arg0) {
		return chauffeurRepository.findOne(arg0);
	}

	@Override
	public <S extends Chauffeur> Iterable<S> save(Iterable<S> arg0) {
		return chauffeurRepository.save(arg0);
	}

	@Override
	public <S extends Chauffeur> S save(S arg0) {
		return chauffeurRepository.save(arg0);
	}

	@Override
	public Chauffeur findByCin(String cin) {
		return chauffeurRepository.findByCin(cin);
				
	}

	
}
