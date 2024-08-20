package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.UnidadAeroportuariaDao;
import org.dgac.cl.model.entity.UnidadAeroportuaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UnidadAeroportuariaServiceImpl implements UnidadAeroportuariaService{

    @Autowired
    private UnidadAeroportuariaDao dao;

    @Override
    public List<UnidadAeroportuaria> findAll(){
        return dao.findAll();
    }
    
    @Override
    public UnidadAeroportuaria findById(Integer id){
        return dao.findById(id).orElse(null);
    }

    @Override
    public UnidadAeroportuaria save(UnidadAeroportuaria unidadAeroportuaria){
        return dao.save(unidadAeroportuaria);
    }

    @Override
    public void deleteById(Integer id){
        dao.deleteById(id);
    }

    @Override
    public Page<UnidadAeroportuaria> findAll(Pageable pageable){
        return dao.findAll(pageable);
    }

}
