package com.ecole.gestion.ecole.service;

import com.ecole.gestion.ecole.dao.TarifsRepository;
import com.ecole.gestion.ecole.model.Tarif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

@Service
public class TarifsMetierImpl implements TarifsService  {
	
	@Autowired
	private TarifsRepository tarifRepository;

	@Override
	public long count() {
		return tarifRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		tarifRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Tarif> arg0) {
		tarifRepository.delete(arg0);
	}

	@Override
	public void delete(Tarif arg0) {
		tarifRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		tarifRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return tarifRepository.exists(arg0);
	}

	@Override
	public Iterable<Tarif> findAll() {
		return tarifRepository.findAll();
	}

	@Override
	public Iterable<Tarif> findAll(Iterable<Integer> arg0) {
		return tarifRepository.findAll(arg0);
	}

	@Override
	public Tarif findOne(Integer arg0) {
		return tarifRepository.findOne(arg0);
	}

	@Override
	public <S extends Tarif> Iterable<S> save(Iterable<S> arg0) {
		return tarifRepository.save(arg0);
	}

	@Override
	public <S extends Tarif> S save(S arg0) {
		return tarifRepository.save(arg0);
	}

	@Override
	public Tarif findByService(String service) {
		 Tarif tarif =tarifRepository.findParservice(service);
		 return tarif;
	 
	}

	
	
	
}
