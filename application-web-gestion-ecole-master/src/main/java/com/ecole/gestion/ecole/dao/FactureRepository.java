package com.ecole.gestion.ecole.dao;

 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.Facture;







//@Repository
@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long> {
	@Query("select e from Facture e where e.active=:x ")                                        
	List<Facture> findActive(@Param("x") boolean active);

}
