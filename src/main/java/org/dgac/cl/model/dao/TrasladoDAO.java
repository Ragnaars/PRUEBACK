package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.Traslado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TrasladoDAO extends JpaRepository<Traslado, Integer>, JpaSpecificationExecutor<Traslado>{

}
