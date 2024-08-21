package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.PerfilDAO;
import org.dgac.cl.model.entity.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilDAO dao;

    @Override
    public List<Perfil> findAll(){
        return dao.findAll();
    }

    @Override
    public Perfil findById(Integer id){
        return dao.findById(id).orElse(null);
    }

    @Override
    public Perfil save(Perfil perfil){
        return dao.save(perfil);
    }

    @Override
    public void deleteById(Integer id){
        dao.deleteById(id);
    }

    

}
