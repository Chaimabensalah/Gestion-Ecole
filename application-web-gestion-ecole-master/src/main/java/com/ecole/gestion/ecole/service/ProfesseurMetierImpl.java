package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.model.*;
import com.ecole.gestion.ecole.dao.*;

@Service
public class ProfesseurMetierImpl implements ProfesseurService  {
	@Autowired
	private ProfesseurRepository professeurRepository;

	@Override
	public long count() {
		return professeurRepository.count();
	}

	@Override
	public void delete(Long arg0) {
		professeurRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Professeur> arg0) {
		professeurRepository.delete(arg0);
	}

	@Override
	public void delete(Professeur arg0) {
		professeurRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		professeurRepository.deleteAll();
	}

 
	@Override
	public Iterable<Professeur> findAll() {
		return professeurRepository.findAll();
	}

	@Override
	public Iterable<Professeur> findAll(Iterable<Long> arg0) {
		return professeurRepository.findAll(arg0);
	}

	@Override
	public Professeur findOne(Long arg0) {
		return professeurRepository.findOne(arg0);
	}

	@Override
	public <S extends Professeur> Iterable<S> save(Iterable<S> arg0) {
		return professeurRepository.save(arg0);
	}

	@Override
	public <S extends Professeur> S save(S arg0) {
		return professeurRepository.save(arg0);
	}

	@Override
	public Professeur findByCin(String arg0) {
		return professeurRepository.findByCin(arg0);
	}

	@Override
	public List<Professeur> findActive() {
		return professeurRepository.findActive(true);
	}

	
	
}
