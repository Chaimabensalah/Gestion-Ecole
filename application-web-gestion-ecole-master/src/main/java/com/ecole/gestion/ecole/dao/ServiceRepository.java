package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Servicee;

@Repository
public interface ServiceRepository extends JpaRepository<Servicee, Integer> {
	
	@Query("select s from Servicee s where s.nomService=:x and s.eleve=:y ")                                        
    Servicee findByEleve(@Param("x") String nomService,@Param("y") Eleve eleve);

	@Query("select s from Servicee s where s.eleve=:y ")                                        
    List<Servicee>findServicesParEleve(@Param("y") Eleve eleve);


}
