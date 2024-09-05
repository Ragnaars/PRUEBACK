package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.TrasladoDAO;
import org.dgac.cl.model.entity.Traslado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TrasladoServiceImpl implements TrasladoService{

    @Autowired TrasladoDAO dao;

    @Override
    public List<Traslado> findAll() {
        return dao.findAll();
    }

    @Override
    public Page<Traslado> findAllPage(Specification<Traslado> specification, Pageable pageable) {
        return dao.findAll(specification, pageable);
    }

    @Override
    public Traslado findById(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Traslado save(Traslado traslado) {
        return dao.save(traslado);
    }

}
