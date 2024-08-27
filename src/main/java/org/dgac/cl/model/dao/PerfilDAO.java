package org.dgac.cl.model.dao;

import org.dgac.cl.model.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PerfilDAO extends JpaRepository<Perfil, Integer>, JpaSpecificationExecutor<Perfil>{}
