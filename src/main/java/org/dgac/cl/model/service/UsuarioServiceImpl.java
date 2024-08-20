package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.UsuarioDAO;
import org.dgac.cl.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO dao;

    @Override
    public List<Usuario> findAll(){
        return dao.findAll();
    }
    
    @Override
    public Usuario findById(Integer id){
        return dao.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario){
        return dao.save(usuario);
    }

    @Override
    public void deleteById(Integer id){
        dao.deleteById(id);
    }

}
