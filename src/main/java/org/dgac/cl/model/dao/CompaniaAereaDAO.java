package org.dgac.cl.model.dao;

import java.util.List;

import org.dgac.cl.model.entity.CompaniaAerea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniaAereaDAO extends JpaRepository<CompaniaAerea, Integer> {
    public List<CompaniaAerea> findByNombre(String nombre);
    

}


