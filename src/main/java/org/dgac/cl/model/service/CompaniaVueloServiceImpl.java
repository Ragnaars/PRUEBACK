package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.CompaniaVueloDao;
import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.CompaniaVueloId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniaVueloServiceImpl implements CompaniaVueloService {

    @Autowired CompaniaVueloDao dao;

    @Override
    public List<CompaniaVuelo> findByCompaniaAerea(Integer companiaAerea) {

        return dao.findByCompaniaAerea(companiaAerea);
    }

    @Override
    public CompaniaVuelo findById(CompaniaVueloId id) {

        return dao.findById(id).orElse(null);
    }

    @Override
    public CompaniaVuelo save(CompaniaVuelo companiaVuelo) {

        return dao.save(companiaVuelo);
    }

}
