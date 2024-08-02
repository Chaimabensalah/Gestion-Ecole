package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.dao.CahierTexteRepository;
import com.ecole.gestion.ecole.dao.ClasseRepository;
import com.ecole.gestion.ecole.dao.MatiereRepository;
import com.ecole.gestion.ecole.model.*;


@Service
public class CahiertexteMetierImpl implements CahierTexteService  {
	@Autowired
	private CahierTexteRepository cahierTexteRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	@Autowired
	private ClasseRepository classeRepository;

	@Override
	public long count() {
		return cahierTexteRepository.count();
	}

	@Override
	public void delete(CahierTexte arg0) {
		cahierTexteRepository.delete(arg0);
	}

	@Override
	public void delete(Integer arg0) {
		cahierTexteRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends CahierTexte> arg0) {
		cahierTexteRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		cahierTexteRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return cahierTexteRepository.exists(arg0);
	}

	@Override
	public List<CahierTexte> findAll() {
		return cahierTexteRepository.findAll();
	}

	@Override
	public Iterable<CahierTexte> findAll(Iterable<Integer> arg0) {
		return cahierTexteRepository.findAll(arg0);
	}

	@Override
	public CahierTexte findOne(Integer arg0) {
		return cahierTexteRepository.findOne(arg0);
	}

	@Override
	public <S extends CahierTexte> Iterable<S> save(Iterable<S> arg0) {
		return cahierTexteRepository.save(arg0);
	}

	@Override
	public <S extends CahierTexte> S save(S arg0) {
		return cahierTexteRepository.save(arg0);
		
	}

	@Override
	public <S extends CahierTexte> S saveCahierText(S arg0,String matiere,String classe) {
		//arg0.setEleve(eleveRepository.findByMatricule(matriculeEleve));
		arg0.setMatiere(matiereRepository.findByNom(matiere));
		arg0.setClasse(classeRepository.findByNom(classe));
		return cahierTexteRepository.save(arg0);
	}
	
	@Override
	public CahierTexte findCahierParClasse(Classe classe) {
		return cahierTexteRepository.findCahierParClasse(classe);
		
	}

	@Override
	public List<CahierTexte> findCahierParMatiere(String nomMatiere) {
		Matiere matiere =matiereRepository.findByNom(nomMatiere);
		return cahierTexteRepository.findCahierParMatiere(matiere);
	}

	
	
	
}
