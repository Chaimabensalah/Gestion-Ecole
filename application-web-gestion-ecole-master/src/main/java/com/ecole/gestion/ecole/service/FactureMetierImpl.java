package com.ecole.gestion.ecole.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.dao.FactureRepository;
import com.ecole.gestion.ecole.model.Facture;
import com.ecole.gestion.ecole.model.Fournisseur;
 

@Service
public class FactureMetierImpl implements FactureService   {
	
	@Autowired
	private FactureRepository factureRepository;
	
	@Autowired
	FournisseurService fournisseurService;

	@Override
	public long count() {
		return factureRepository.count();
	}

	@Override
	public void delete(Facture arg0) {
		factureRepository.delete(arg0);
	}

	@Override
	public void delete(Long arg0) {
		factureRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Facture> arg0) {
		factureRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		factureRepository.deleteAll();
	}

	@Override
	public boolean exists(Long arg0) {
		return factureRepository.exists(arg0);
	}

	@Override
	public List<Facture> findAll() {
		return factureRepository.findAll();
	}

	@Override
	public Iterable<Facture> findAll(Iterable<Long> arg0) {
		return factureRepository.findAll(arg0);
	}

	@Override
	public Facture findOne(Long arg0) {
		return factureRepository.findOne(arg0);
	}

	@Override
	public <S extends Facture> Iterable<S> save(Iterable<S> arg0) {
		return factureRepository.save(arg0);
	}

	@Override
	public <S extends Facture> S save(S arg0) {
		return factureRepository.save(arg0);
	}

	@Override
	public Facture save(Facture facture, String nomFournisseur) {
		 Fournisseur f=fournisseurService.findByNom(nomFournisseur);
		 facture.setFournisseur(f);
		 
		 facture.setTotalHT(facture.getNombreProduit()*facture.getPrixHT());
		 facture.setActive(true);
		 
		return factureRepository.save(facture);
	}

	@Override
	public List<Facture> findActive() {
		 return factureRepository.findActive(true);
	}

	
	
	
}
