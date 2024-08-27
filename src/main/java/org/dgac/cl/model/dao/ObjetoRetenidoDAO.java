package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.ObjetoRetenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ObjetoRetenidoDAO extends JpaRepository<ObjetoRetenido, Long>, JpaSpecificationExecutor<ObjetoRetenido> {   
	
}
