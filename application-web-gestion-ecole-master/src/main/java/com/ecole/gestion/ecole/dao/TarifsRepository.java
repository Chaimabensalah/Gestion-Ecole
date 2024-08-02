package com.ecole.gestion.ecole.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 
import com.ecole.gestion.ecole.model.Tarif;

 

@Repository
public interface TarifsRepository extends JpaRepository<Tarif, Integer> {
	 @Query("select p from Tarif p where p.nomTarif=:x ")                                        
		Tarif findParservice(@Param("x") String nomTarif);

}
