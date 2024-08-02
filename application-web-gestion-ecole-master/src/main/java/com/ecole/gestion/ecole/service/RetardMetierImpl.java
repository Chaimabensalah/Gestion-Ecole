package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.dao.ClasseRepository;
import com.ecole.gestion.ecole.dao.EleveRepository;
import com.ecole.gestion.ecole.dao.MatiereRepository;
import com.ecole.gestion.ecole.dao.RetardRepository;
import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Retard;

 
@Service
public class RetardMetierImpl implements RetardService  {
	@Autowired
	private RetardRepository retardRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;

	@Override
	public long count() {
		return retardRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		retardRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Retard> arg0) {
		retardRepository.delete(arg0);
	}

	@Override
	public void delete(Retard arg0) {
		retardRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		retardRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return retardRepository.exists(arg0);
	}

	@Override
	public Iterable<Retard> findAll() {
		return retardRepository.findAll();
	}

	@Override
	public Iterable<Retard> findAll(Iterable<Integer> arg0) {
		return retardRepository.findAll(arg0);
	}

	@Override
	public Retard findOne(Integer arg0) {
		return retardRepository.findOne(arg0);
	}

	@Override
	public <S extends Retard> Iterable<S> save(Iterable<S> arg0) {
		return retardRepository.save(arg0);
	}

	@Override
	public <S extends Retard> S save(S arg0) {
		return retardRepository.save(arg0);
	}
	
	@Override
	public <S extends Retard> S saveRetard(S arg0,String matriculeEleve,String matiere) {
		arg0.setEleve(eleveRepository.findByMatricule(matriculeEleve));
		arg0.setMatiere(matiereRepository.findByNom(matiere));
		return retardRepository.save(arg0);
	}

	@Override
	public List<Retard> findParClasse(String nomclasse) {
		Classe classe=classeRepository.findByNom(nomclasse);
		return retardRepository.findParClasse(classe);
	}

	
	
}
