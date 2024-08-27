package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.PuenteEmbarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PuenteEmbarqueDAO extends JpaRepository<PuenteEmbarque, Integer>, JpaSpecificationExecutor<PuenteEmbarque>{

}
