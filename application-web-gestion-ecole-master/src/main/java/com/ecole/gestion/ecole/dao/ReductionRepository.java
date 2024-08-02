package com.ecole.gestion.ecole.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Reduction;










@Repository
public interface ReductionRepository extends JpaRepository<Reduction, Integer> {

}
