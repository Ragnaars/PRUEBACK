package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.ParametroDAO;
import org.dgac.cl.model.entity.Parametro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametroServiceImpl implements ParametroService {

    @Autowired
    private ParametroDAO dao;

    @Override
    public List<Parametro> findAll(){
        return dao.findAll();
    }

    @Override
    public Parametro findById(String id){
        return dao.findById(id).orElse(null);
    }

    @Override
    public Parametro save(Parametro parametro){
        return dao.save(parametro);
    }

    @Override
    public void deleteById(String id){
        dao.deleteById(id);
    }
}
