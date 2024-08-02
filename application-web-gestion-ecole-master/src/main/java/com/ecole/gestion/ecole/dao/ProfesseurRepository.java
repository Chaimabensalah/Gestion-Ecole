package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.Professeur;

 

//@Repository
@RepositoryRestResource
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
  
	  @Query("select p from Professeur p where p.cin=:x ")                                        
		Professeur findByCin(@Param("x") String matricule);
	  
	  @Query("select e from Professeur  e where e.active=:x ")                                        
      List<Professeur> findActive(@Param("x") boolean active);
	  
}
