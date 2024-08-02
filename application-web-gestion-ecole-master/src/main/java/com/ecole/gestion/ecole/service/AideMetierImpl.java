package com.ecole.gestion.ecole.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.model.*;
import com.ecole.gestion.ecole.dao.*;
@Service
public class AideMetierImpl implements AideService  {
	@Autowired
	private AideRepository AideRepository;

	@Override
	public long count() {
		return AideRepository.count();
	}

	@Override
	public void delete(Aide arg0) {
		AideRepository.delete(arg0);
	}

	@Override
	public void delete(Long arg0) {
		AideRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Aide> arg0) {
		AideRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		AideRepository.deleteAll();
	}

	@Override
	public boolean exists(Long arg0) {
		return AideRepository.exists(arg0);
	}

	@Override
	public Iterable<Aide> findAll() {
		return AideRepository.findAll();
	}

	@Override
	public Iterable<Aide> findAll(Iterable<Long> arg0) {
		return AideRepository.findAll(arg0);
	}

	@Override
	public Aide findOne(Long arg0) {
		return AideRepository.findOne(arg0);
	}

	@Override
	public <S extends Aide> Iterable<S> save(Iterable<S> arg0) {
		return AideRepository.save(arg0);
	}

	@Override
	public <S extends Aide> S save(S arg0) {
		return AideRepository.save(arg0);
	}

	@Override
	public Aide findByCin(String arg0) {
		return AideRepository.findByCin(arg0);
	}


	
	
}
