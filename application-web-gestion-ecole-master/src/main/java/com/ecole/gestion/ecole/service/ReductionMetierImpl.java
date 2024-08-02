package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.Reduction;

@Service
public class ReductionMetierImpl implements ReductionService {
	@Autowired
	private ReductionRepository ReductionRepository;

	@Override
	public long count() {
		return ReductionRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		ReductionRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Reduction> arg0) {
		ReductionRepository.delete(arg0);
	}

	@Override
	public void delete(Reduction arg0) {
		ReductionRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		ReductionRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return ReductionRepository.exists(arg0);
	}

	@Override
	public List<Reduction> findAll() {
		return ReductionRepository.findAll();
	}

	@Override
	public Iterable<Reduction> findAll(Iterable<Integer> arg0) {
		return ReductionRepository.findAll(arg0);
	}

	@Override
	public Reduction findOne(Integer arg0) {
		return ReductionRepository.findOne(arg0);
	}

	@Override
	public <S extends Reduction> Iterable<S> save(Iterable<S> arg0) {
		return ReductionRepository.save(arg0);
	}

	@Override
	public <S extends Reduction> S save(S arg0) {
		return ReductionRepository.save(arg0);
	}

	
	
	
}
