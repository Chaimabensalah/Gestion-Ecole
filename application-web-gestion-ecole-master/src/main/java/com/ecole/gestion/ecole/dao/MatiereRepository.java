package com.ecole.gestion.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Matiere;









//@Repository
@RepositoryRestResource
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

	@Query("select p from Matiere p where p.nomMatiere=:x ")                                        
	Matiere findByNom(@Param("x") String matiere);
  
}

