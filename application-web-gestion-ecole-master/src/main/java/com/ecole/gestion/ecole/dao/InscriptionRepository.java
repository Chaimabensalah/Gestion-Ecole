package com.ecole.gestion.ecole.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.*;

@RepositoryRestResource
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
	
	@Query("select e from Inscription e where e.eleve=:x ")                                        
	List<Inscription> getInscriptionsParEleve(@Param("x") Eleve eleve);
}
