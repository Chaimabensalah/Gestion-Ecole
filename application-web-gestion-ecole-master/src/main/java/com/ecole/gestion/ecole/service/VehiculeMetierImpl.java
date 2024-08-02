package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.dao.VehiculeRepository;
import com.ecole.gestion.ecole.model.Vehicule;


@Service
public class VehiculeMetierImpl implements VehiculeService {
	@Autowired
	private VehiculeRepository vehiculeRepository;

	@Override
	public long count() {
		return vehiculeRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		vehiculeRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Vehicule> arg0) {
		vehiculeRepository.delete(arg0);
	}

	@Override
	public void delete(Vehicule arg0) {
		vehiculeRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		vehiculeRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return vehiculeRepository.exists(arg0);
	}

	@Override
	public List<Vehicule> findAll() {
		return vehiculeRepository.findAll();
	}

	@Override
	public Iterable<Vehicule> findAll(Iterable<Integer> arg0) {
		return vehiculeRepository.findAll(arg0);
	}

	@Override
	public Vehicule findOne(Integer arg0) {
		return vehiculeRepository.findOne(arg0);
	}

	@Override
	public <S extends Vehicule> Iterable<S> save(Iterable<S> arg0) {
		return vehiculeRepository.save(arg0);
	}

	@Override
	public <S extends Vehicule> S save(S arg0) {
		return vehiculeRepository.save(arg0);
	}

	@Override
	public Vehicule findbyMatricule(String matricule) {
		return vehiculeRepository.findByMatricule(matricule);
	}

	@Override
	public List<Vehicule> findActive() {
		return vehiculeRepository.findActive(true);
				
	}

	
	
}
