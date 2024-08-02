package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Vehicule;









@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
	
	 @Query("select p from Vehicule p where p.matricule=:x ")                                        
		Vehicule findByMatricule(@Param("x") String matricule);
	 
	 @Query("select e from Vehicule e where e.active=:x ")                                        
	    List<Vehicule> findActive(@Param("x") boolean active);

}
