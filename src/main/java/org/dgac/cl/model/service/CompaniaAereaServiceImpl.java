package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.CompaniaAereaDAO;
import org.dgac.cl.model.entity.CompaniaAerea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniaAereaServiceImpl implements CompaniaAereaService{

    @Autowired
    private CompaniaAereaDAO dao;

    @Override
    public List<CompaniaAerea> findAll(){
        return dao.findAll();
    }

    @Override
    public CompaniaAerea findById(Integer id){
        return dao.findById(id).orElse(null);
    }

    @Override
    public CompaniaAerea save(CompaniaAerea companiaAerea){
        return dao.save(companiaAerea);
    }

    @Override
    public void deleteById(Integer id){        
        dao.deleteById(id);
    }

    @Override
    public List<CompaniaAerea> findByNombre(String nombre){
        return dao.findByNombre(nombre);
    }
    

}
