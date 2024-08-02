package com.ecole.gestion.ecole.service;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.model.*;
import com.ecole.gestion.ecole.dao.*;
 

@Service
public class HoraireMetierImpl implements HoraireService  {
	@Autowired
	private HoraireRepository HoraireRepository;

	@Override
	public long count() {
		return HoraireRepository.count();
	}

	@Override
	public void delete(Horaire arg0) {
		HoraireRepository.delete(arg0);
	}

	@Override
	public void delete(Integer arg0) {
		HoraireRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Horaire> arg0) {
		HoraireRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		HoraireRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return HoraireRepository.exists(arg0);
	}

	@Override
	public Iterable<Horaire> findAll() {
		return HoraireRepository.findAll();
	}

	@Override
	public Iterable<Horaire> findAll(Iterable<Integer> arg0) {
		return HoraireRepository.findAll(arg0);
	}

	@Override
	public Horaire findOne(Integer arg0) {
		return HoraireRepository.findOne(arg0);
	}

	@Override
	public <S extends Horaire> Iterable<S> save(Iterable<S> arg0) {
		return HoraireRepository.save(arg0);
	}

	@Override
	public <S extends Horaire> S save(S arg0) {
		return HoraireRepository.save(arg0);
	}

	
	
}
