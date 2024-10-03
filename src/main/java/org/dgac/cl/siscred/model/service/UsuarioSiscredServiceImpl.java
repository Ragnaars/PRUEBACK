package org.dgac.cl.siscred.model.service;

import java.util.List;

import org.dgac.cl.siscred.model.dao.UsuarioSiscredDAO;
import org.dgac.cl.siscred.model.entity.UsuarioSiscred;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSiscredServiceImpl implements UsuarioSiscredService{

    @Autowired
    private UsuarioSiscredDAO dao;

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);    
    }

    @Override
    public List<UsuarioSiscred> findAll() {
        return dao.findAll();
    }

    @Override
    public List<UsuarioSiscred> findAllById(List<Integer> ids) {
        return dao.findAllById(ids);
    }

    @Override
    public UsuarioSiscred findById(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public UsuarioSiscred save(UsuarioSiscred usuarioSiscred) {
        return dao.save(usuarioSiscred);
    }


    
    
}
