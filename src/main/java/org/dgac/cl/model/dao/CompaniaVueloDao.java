package org.dgac.cl.model.dao;
import java.util.List;

import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.CompaniaVueloId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniaVueloDao extends JpaRepository<CompaniaVuelo, CompaniaVueloId>{
    public List<CompaniaVuelo> findByCompaniaAerea(Integer companiaAerea);
}
