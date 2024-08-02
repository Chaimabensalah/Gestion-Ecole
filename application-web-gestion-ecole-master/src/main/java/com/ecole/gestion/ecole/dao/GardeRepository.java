package com.ecole.gestion.ecole.dao;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Garde;
 

@Repository
public interface GardeRepository extends JpaRepository<Garde, Long> {
	
	@Query("select e from Garde e where e.active=:x ")                                        
    List<Garde> findActive(@Param("x") boolean active);

}
