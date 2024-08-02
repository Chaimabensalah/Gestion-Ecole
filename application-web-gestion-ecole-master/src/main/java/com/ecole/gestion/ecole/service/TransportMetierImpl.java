package com.ecole.gestion.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.dao.TransportRepository;
import com.ecole.gestion.ecole.model.Aide;
import com.ecole.gestion.ecole.model.Chauffeur;
import com.ecole.gestion.ecole.model.Transport;
import com.ecole.gestion.ecole.model.Vehicule;


@Service
public class TransportMetierImpl implements TransportService {
	@Autowired
	private TransportRepository transportRepository;
	
	@Autowired 
	private AideService aideService;
	
	@Autowired 
	private ChauffeurService chauffeurService;
	
	@Autowired 
	private VehiculeService vehiculeService;

	@Override
	public long count() {
		return transportRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		transportRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Transport> arg0) {
		transportRepository.delete(arg0);
	}

	@Override
	public void delete(Transport arg0) {
		transportRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		transportRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return transportRepository.exists(arg0);
	}

	@Override
	public List<Transport> findAll() {
		return transportRepository.findAll();
	}

	@Override
	public Iterable<Transport> findAll(Iterable<Integer> arg0) {
		return transportRepository.findAll(arg0);
	}

	@Override
	public Transport findOne(Integer arg0) {
		return transportRepository.findOne(arg0);
	}

	@Override
	public <S extends Transport> Iterable<S> save(Iterable<S> arg0) {
		return transportRepository.save(arg0);
	}

	@Override
	public <S extends Transport> S save(S arg0) {
		return transportRepository.save(arg0);
	}
	
	@Override
	public <S extends Transport> S save(S transport,String cin,String cinAide,String voiture) {
		Chauffeur chauffeur=chauffeurService.findByCin(cin);
     	Aide aide=aideService.findByCin(cinAide); 
     	Vehicule v=vehiculeService.findbyMatricule(voiture);
     	
		transport.setChauffeur(chauffeur);
		 transport.setAide(aide);
		 transport.setVehicule(v);
		return transportRepository.save(transport);
		 
	}

	@Override
	public List<Transport> findActive() {
		return transportRepository.findActive(true);
	}
	

	
	
	
}
