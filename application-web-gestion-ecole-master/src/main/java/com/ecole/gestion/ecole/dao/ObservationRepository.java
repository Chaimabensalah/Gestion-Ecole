package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Observation;









@Repository
public interface ObservationRepository extends JpaRepository<Observation, Integer> {


	@Query("select o from Observation o where o.eleve=:x ")                                        
    List<Observation>findByEleve(@Param("x") Eleve eleve);

}
