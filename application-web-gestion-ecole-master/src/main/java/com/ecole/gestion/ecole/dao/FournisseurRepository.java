package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Fournisseur;







@Repository
//@RepositoryRestResource
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
	
	@Query("Select d from Fournisseur d where d.nom=:x")
	Fournisseur findByNom(@Param("x") String nom);
	
	@Query("select e from Fournisseur e where e.active=:x ")                                        
    List<Fournisseur> findActive(@Param("x") boolean active);
	
	

}
