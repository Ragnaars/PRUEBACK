package org.dgac.cl.siscred.model.dao;

import org.dgac.cl.siscred.model.entity.SolicitudSiscred;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudSiscredDAO extends JpaRepository<SolicitudSiscred, Integer>  {
    
}
