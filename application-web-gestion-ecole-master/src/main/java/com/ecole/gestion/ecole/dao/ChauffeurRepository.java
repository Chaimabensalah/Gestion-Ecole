package com.ecole.gestion.ecole.dao;

 

 

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.Chauffeur;






//@Repository
@RepositoryRestResource
public interface ChauffeurRepository extends CrudRepository<Chauffeur, Long> {
	
	@Query("select p from Chauffeur p where p.cin=:x ")                                        
	Chauffeur findByCin(@Param("x") String cin);
	
	@Query("select e from Chauffeur e where e.active=:x ")                                        
    List<Chauffeur> findActive(@Param("x") boolean active);
  

}
