package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.ObjetoRetenidoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ObjetoRetenidoTipoDAO extends JpaRepository<ObjetoRetenidoTipo, Integer>, JpaSpecificationExecutor<ObjetoRetenidoTipo> {}
