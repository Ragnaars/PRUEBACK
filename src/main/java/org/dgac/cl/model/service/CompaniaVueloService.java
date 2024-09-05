package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.CompaniaVueloId;

public interface CompaniaVueloService {
    public List<CompaniaVuelo> findByCompaniaAerea(Integer companiaAerea);
    public CompaniaVuelo findById(CompaniaVueloId id);
    public CompaniaVuelo save(CompaniaVuelo companiaVuelo);
}
