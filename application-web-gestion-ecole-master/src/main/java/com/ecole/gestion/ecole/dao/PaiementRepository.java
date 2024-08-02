package com.ecole.gestion.ecole.dao;

 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Paiement;










@Repository
public interface PaiementRepository extends CrudRepository<Paiement, Integer> {

}
