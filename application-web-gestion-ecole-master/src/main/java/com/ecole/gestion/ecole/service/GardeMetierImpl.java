package com.ecole.gestion.ecole.service;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.dao.GardeRepository;
import com.ecole.gestion.ecole.model.Aide;
import com.ecole.gestion.ecole.model.Garde;
import com.ecole.gestion.ecole.model.Professeur;
 
@Service
public class GardeMetierImpl implements GardeService   {
	@Autowired
	private GardeRepository gardeRepository;
	@Autowired AideService aideService;
	@Autowired ProfesseurService profService;

 

	@Override
	public void delete(Garde arg0) {
		gardeRepository.delete(arg0);
	}

	@Override
	public void delete(Long arg0) {
		gardeRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Garde> arg0) {
		gardeRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		gardeRepository.deleteAll();
	}

	@Override
	public boolean exists(Long arg0) {
		return gardeRepository.exists(arg0);
	}

	@Override
	public List<Garde> findAll() {
		return gardeRepository.findAll();
	}

	@Override
	public Iterable<Garde> findAll(Iterable<Long> arg0) {
		return gardeRepository.findAll(arg0);
	}

	@Override
	public Garde findOne(Long arg0) {
		return gardeRepository.findOne(arg0);
	}

	@Override
	public <S extends Garde> Iterable<S> save(Iterable<S> arg0) {
		return gardeRepository.save(arg0);
	}

	@Override
	public <S extends Garde> S save(S arg0) {
		return gardeRepository.save(arg0);
	}

	
	@Override
	public <S extends Garde> S save(S arg0,String cin,String cinAide) {
		Professeur prof=profService.findByCin(cin);
     	Aide aide=aideService.findByCin(cinAide); 
     	
		arg0.setProfesseur(prof);
		arg0.setAide(aide);
		return gardeRepository.save(arg0);
		 
	}

	@Override
	public List<Garde> findActive() {
		return gardeRepository.findActive(true);
	}

	@Override
	public Professeur findProf(long id) {
		 Garde g=gardeRepository.findOne(id);
		return g.getProfesseur();
	}
	
	
	
}
