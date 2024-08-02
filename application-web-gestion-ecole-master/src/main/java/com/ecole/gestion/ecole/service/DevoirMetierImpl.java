package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Devoir;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Matiere;
@Service
public class DevoirMetierImpl implements DevoirService  {
	@Autowired
	private DevoirRepository devoirRepository;

	@Autowired
	private MatiereRepository matiereRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private EleveService eleveService;
	
	
	@Override
	public long count() {
		return devoirRepository.count();
	}

	@Override
	public void delete(Devoir arg0) {
		devoirRepository.delete(arg0);
	}

	@Override
	public void delete(Integer arg0) {
		devoirRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Devoir> arg0) {
		devoirRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		devoirRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return devoirRepository.exists(arg0);
	}

	@Override
	public Iterable<Devoir> findAll() {
		return devoirRepository.findAll();
	}

	@Override
	public Iterable<Devoir> findAll(Iterable<Integer> arg0) {
		return devoirRepository.findAll(arg0);
	}

	@Override
	public Devoir findOne(Integer arg0) {
		return devoirRepository.findOne(arg0);
	}

	@Override
	public <S extends Devoir> Iterable<S> save(Iterable<S> arg0) {
		return devoirRepository.save(arg0);
	}

	@Override
	public <S extends Devoir> S save(S arg0) {
		return devoirRepository.save(arg0);
	}
	
	@Override
	public <S extends Devoir> S saveDevoir(S arg0,String matiere,String classe) {
		//arg0.setEleve(eleveRepository.findByMatricule(matriculeEleve));
		arg0.setMatiere(matiereRepository.findByNom(matiere));
		arg0.setClasse(classeRepository.findByNom(classe));
		arg0.setValide(true);
		return devoirRepository.save(arg0);
	}
	
	@Override
	public List<Devoir> findDevoirsParMatiere(Matiere matiere) {
		return devoirRepository.findDevoirsParMatiere(matiere);
		
	}

	@Override
	public List<Devoir> findDevoirsParEleve(String matricule) {
		Eleve eleve=eleveService.findByMatricule(matricule);
		Classe classe=eleve.getClasse();
		
		return devoirRepository.findDevoirParClasse(classe,true);
		
	}
}
