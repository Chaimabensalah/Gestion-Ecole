package com.ecole.gestion.ecole.service;
import com.ecole.gestion.ecole.model.*;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.dao.*;
@Service
public class PaiementMetierImpl implements PaiementService {
	@Autowired
	private PaiementRepository paiementRepository;
	
//	@Autowired
//	private InscriptionRepository inscriptionRepository;
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private EleveService eleveService;
	
	@Autowired
	private ServiceMetier serviceMetier;

	@Override
	public long count() {
		return paiementRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		paiementRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Paiement> arg0) {
		paiementRepository.delete(arg0);
	}

	@Override
	public void delete(Paiement arg0) {
		paiementRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		paiementRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return paiementRepository.exists(arg0);
	}

	@Override
	public Iterable<Paiement> findAll() {
		return paiementRepository.findAll();
	}

	@Override
	public Iterable<Paiement> findAll(Iterable<Integer> arg0) {
		return paiementRepository.findAll(arg0);
	}

	@Override
	public Paiement findOne(Integer arg0) {
		return paiementRepository.findOne(arg0);
	}

	@Override
	public <S extends Paiement> Iterable<S> save(Iterable<S> arg0) {
		return paiementRepository.save(arg0);
	}

	@Override
	public <S extends Paiement> S save(S arg0) {
		 
		
		return paiementRepository.save(arg0);
	}

	@Override
	public Paiement save(Paiement paiement, String email,int typePaiement) {
		
		Eleve eleve=eleveRepository.findParEmail(email);
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		Servicee service=new Servicee();
		Servicee scolarite=new Servicee();
		
		service.setNomService("inscription");
		//service.setTypePaiement(1);
		service.setPaye(1);
		service.setRestAPye(0);
		service.setEleve(eleve);
		serviceMetier.save(service);
		
		scolarite.setNomService("scolarite");
		scolarite.setPaye(0);
		scolarite.setEleve(eleve);
		scolarite.setRestAPye(typePaiement);
		//scolarite.setTypePaiement(type);
		serviceMetier.save(scolarite);
				
		serviceMetier.save(service);
		
		eleve.setTypePaiement(typePaiement);
		eleveService.save(eleve);
		Inscription inscription=eleveService.findCurrentInscription(eleve);
	    paiement.setInscription(inscription);
	    paiement.setDatePaiment(date);
		return paiementRepository.save(paiement);
	}

	public Paiement save(Eleve eleve,Paiement paiement) {
		//int total=eleve.getTypePaiement();
		//paiement.getResteAPaye()-
		 
	
		return paiementRepository.save(paiement);
	}

	 
	
	public int getRestPaiement(int typePaiement,int paye) {
		return typePaiement-paye;
	}

	@Override
	public Paiement save(Paiement paiement, long id, String nomService) {
		Eleve eleve=eleveRepository.findOne(id);
		Servicee service=serviceMetier.findByEleve(nomService,eleve);
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		service.setPaye(service.getPaye()+1);
		service.setRestAPye(service.getRestAPye()-1);
		
		
		
		paiement.setEleve(eleve);
		paiement.setTypeService(nomService);
		paiement.setDatePaiment(date);
		paiementRepository.save(paiement);
		serviceMetier.save(service);
		return null;
	}
	
	
	
}
