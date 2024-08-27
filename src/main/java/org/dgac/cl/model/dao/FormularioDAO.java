package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FormularioDAO extends JpaRepository<Formulario, Long>, JpaSpecificationExecutor<Formulario> {}
