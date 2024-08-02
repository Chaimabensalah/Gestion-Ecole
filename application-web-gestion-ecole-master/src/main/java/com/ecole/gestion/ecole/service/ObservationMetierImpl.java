package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Observation;

@Service
public class ObservationMetierImpl implements ObservationService  {
	@Autowired
	private ObservationRepository observationRepository;
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;


	@Override
	public long count() {
		return observationRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		observationRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Observation> arg0) {
		observationRepository.delete(arg0);
	}

	@Override
	public void delete(Observation arg0) {
		observationRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		observationRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return observationRepository.exists(arg0);
	}

	@Override
	public Iterable<Observation> findAll() {
		return observationRepository.findAll();
	}

	@Override
	public Iterable<Observation> findAll(Iterable<Integer> arg0) {
		return observationRepository.findAll(arg0);
	}

	@Override
	public Observation findOne(Integer arg0) {
		return observationRepository.findOne(arg0);
	}

	@Override
	public <S extends Observation> Iterable<S> save(Iterable<S> arg0) {
		return observationRepository.save(arg0);
	}

	@Override
	public <S extends Observation> S save(S arg0) {
		return observationRepository.save(arg0);
	}
	
	@Override
	public <S extends Observation> S saveObservation(S arg0,String matiere ,String eleve) {
		arg0.setEleve(eleveRepository.findByMatricule(eleve));
		arg0.setMatiere(matiereRepository.findByNom(matiere));
		return observationRepository.save(arg0);
	}

	@Override
	public List<Observation> findByEleve(Eleve eleve) {
		return observationRepository.findByEleve(eleve);
	}
	

	
}
