package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.model.*;
import com.ecole.gestion.ecole.dao.*;

@Service
public class ExamenMetierImpl implements  ExamenService  {
	@Autowired
	private ExamenRepository examenRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private EleveRepository eleveRepository;

	@Override
	public long count() {
		return examenRepository.count();
	}

	@Override
	public void delete(Examen arg0) {
		examenRepository.delete(arg0);
	}

	@Override
	public void delete(Integer arg0) {
		examenRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Examen> arg0) {
		examenRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		examenRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return examenRepository.exists(arg0);
	}

	@Override
	public Iterable<Examen> findAll() {
		return examenRepository.findAll();
	}

	@Override
	public Iterable<Examen> findAll(Iterable<Integer> arg0) {
		return examenRepository.findAll(arg0);
	}

	@Override
	public Examen findOne(Integer arg0) {
		return examenRepository.findOne(arg0);
	}

	@Override
	public <S extends Examen> Iterable<S> save(Iterable<S> arg0) {
		return examenRepository.save(arg0);
	}

	@Override
	public <S extends Examen> S save(S arg0) {
		return examenRepository.save(arg0);
	}

	@Override
	public <S extends Examen> S saveExam(S arg0,String matiere,String classe) {
		//arg0.setEleve(eleveRepository.findByMatricule(matriculeEleve));
		arg0.setMatiere(matiereRepository.findByNom(matiere));
		arg0.setClasse(classeRepository.findByNom(classe));
		arg0.setValide(false);
		return examenRepository.save(arg0);
	}

	@Override
	public List<Examen> findByEleve( String matricule) {
		Eleve eleve =eleveRepository.findByMatricule(matricule);
		Classe classe=eleve.getClasse();
		return examenRepository.findByEleve(classe);
	}

	@Override
	public List<Examen> findParMatiere(String nomMatiere) {
		Matiere matiere =matiereRepository.findByNom(nomMatiere);
		return examenRepository.findParMatiere(matiere);
		 
	}
	
	
}
