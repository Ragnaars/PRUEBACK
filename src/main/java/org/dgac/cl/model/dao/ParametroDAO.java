package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ParametroDAO extends JpaRepository<Parametro,String>, JpaSpecificationExecutor<Parametro>{}
