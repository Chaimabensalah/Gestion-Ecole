package com.ecole.gestion.ecole.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.Matiere;
 
@Service
public class MatiereMetierImpl implements MatiereService {
	@Autowired
	private MatiereRepository matiereRepository;

	@Override
	public long count() {
		return matiereRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		matiereRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Matiere> arg0) {
		matiereRepository.delete(arg0);
	}

	@Override
	public void delete(Matiere arg0) {
		matiereRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		matiereRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return matiereRepository.exists(arg0);
	}

	@Override
	public Iterable<Matiere> findAll() {
		return matiereRepository.findAll();
	}

	@Override
	public Iterable<Matiere> findAll(Iterable<Integer> arg0) {
		return matiereRepository.findAll(arg0);
	}

	@Override
	public Matiere findOne(Integer arg0) {
		return matiereRepository.findOne(arg0);
	}

	@Override
	public <S extends Matiere> Iterable<S> save(Iterable<S> arg0) {
		return matiereRepository.save(arg0);
	}

	@Override
	public <S extends Matiere> S save(S arg0) {
		return matiereRepository.save(arg0);
	}

	@Override
	public Matiere findByNom(String nom) {
		return  matiereRepository.findByNom(nom);
	}

	
	
}
