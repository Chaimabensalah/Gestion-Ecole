package com.ecole.gestion.ecole.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.CahierTexte;
import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Matiere;




@Repository
public interface CahierTexteRepository extends JpaRepository<CahierTexte, Integer> {

	@Query("select c from CahierTexte c where c.classe=:x ")                                        
     CahierTexte findCahierParClasse(@Param("x") Classe classe);
	
	@Query("select c from CahierTexte c where c.matiere=:x ")                                        
    List<CahierTexte> findCahierParMatiere(@Param("x") Matiere matiere);

}
