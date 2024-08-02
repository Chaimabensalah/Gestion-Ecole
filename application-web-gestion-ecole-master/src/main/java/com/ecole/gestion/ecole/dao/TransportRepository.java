package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Transport;

 







@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {
	
	@Query("select e from Transport e where e.active=:x ")                                        
    List<Transport> findActive(@Param("x") boolean active);

}
