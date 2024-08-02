package com.ecole.gestion.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.dao.EleveRepository;
import com.ecole.gestion.ecole.dao.ServiceRepository;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Servicee;

@Service
public class ServiceMetierImpl implements ServiceMetier {
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private EleveRepository eleveRepository;
	
//	@Autowired
//	private TarifsRepository tarifRepository;

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#count()
	 */
	@Override
	public long count() {
		return serviceRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer arg0) {
		serviceRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#delete(com.ecole.gestion.ecole.model.Service)
	 */
	@Override
	public void delete(com.ecole.gestion.ecole.model.Servicee arg0) {
		serviceRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#deleteAll()
	 */
	@Override
	public void deleteAll() {
		serviceRepository.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#findAll()
	 */
	@Override
	public List<com.ecole.gestion.ecole.model.Servicee> findAll() {
		return serviceRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#findOne(java.lang.Integer)
	 */
	@Override
	public com.ecole.gestion.ecole.model.Servicee findOne(Integer arg0) {
		return serviceRepository.findOne(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#save(java.lang.Iterable)
	 */
	@Override
	public <S extends com.ecole.gestion.ecole.model.Servicee> List<S> save(Iterable<S> arg0) {
		return serviceRepository.save(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#save(S)
	 */
	@Override
	public <S extends com.ecole.gestion.ecole.model.Servicee> S save(S arg0) {
		return serviceRepository.save(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ServiceMetier#saveAndFlush(S)
	 */
	@Override
	public <S extends com.ecole.gestion.ecole.model.Servicee> S saveAndFlush(S arg0) {
		return serviceRepository.saveAndFlush(arg0);
	}

	@Override
	public Servicee save(Servicee service, long id) {
		Eleve eleve =eleveRepository.findOne(id);
		
	   if(serviceRepository.findByEleve(service.getNomService(),eleve) == null);
	   { service.setRestAPye(10);
		
		service.setEleve(eleve);
		return serviceRepository.save(service);}
		
	}

	public Servicee findByEleve(String nomService, Eleve eleve) {
		 
		return serviceRepository.findByEleve(nomService,eleve);
	}

	@Override
	public int findMoisNomPaye(long id, String service) {
		Eleve eleve=eleveRepository.findOne(id);
		return serviceRepository.findByEleve(service, eleve).getRestAPye();
		 
		
	}

	@Override
	public List<Servicee> findServiceParEleve(long id) {
		Eleve eleve=eleveRepository.findOne(id);
		return serviceRepository.findServicesParEleve(eleve);
	}
	
	
	

}
