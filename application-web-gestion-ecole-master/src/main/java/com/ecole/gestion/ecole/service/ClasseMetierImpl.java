package com.ecole.gestion.ecole.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.Classe;

@Service
public class ClasseMetierImpl implements ClasseService {
	@Autowired
	private ClasseRepository classeRepository;

	@Override
	public long count() {
		return classeRepository.count();
	}

	@Override
	public void delete(Classe arg0) {
		classeRepository.delete(arg0);
	}

	@Override
	public void delete(Integer arg0) {
		classeRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Classe> arg0) {
		classeRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		classeRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return classeRepository.exists(arg0);
	}

	@Override
	public Iterable<Classe> findAll() {
		return classeRepository.findAll();
	}

	@Override
	public Iterable<Classe> findAll(Iterable<Integer> arg0) {
		return classeRepository.findAll(arg0);
	}

	@Override
	public Classe findOne(Integer arg0) {
		return classeRepository.findOne(arg0);
	}

	@Override
	public <S extends Classe> Iterable<S> save(Iterable<S> arg0) {
		return classeRepository.save(arg0);
	}

	@Override
	public <S extends Classe> S save(S arg0) {
		return classeRepository.save(arg0);
	}
	
	@Override
	public Classe findByNom(String name) {
		return classeRepository.findByNom(name);
	}

	
	
	
}
