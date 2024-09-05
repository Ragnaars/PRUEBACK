package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.CompaniaVueloId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniaVueloServiceImpl implements CompaniaVueloService {

    @Autowired CompaniaVueloService service;

    @Override
    public List<CompaniaVuelo> findByCompaniaAerea(Integer companiaAerea) {

        return service.findByCompaniaAerea(companiaAerea);
    }

    @Override
    public CompaniaVuelo findById(CompaniaVueloId id) {

        return service.findById(id);
    }

    @Override
    public CompaniaVuelo save(CompaniaVuelo companiaVuelo) {

        return service.save(companiaVuelo);
    }

}
