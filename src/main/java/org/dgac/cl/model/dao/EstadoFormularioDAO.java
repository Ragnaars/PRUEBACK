
package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.EstadoFormulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstadoFormularioDAO extends JpaRepository<EstadoFormulario, Integer>, JpaSpecificationExecutor<EstadoFormulario> {}

