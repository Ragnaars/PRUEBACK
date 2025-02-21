package org.dgac.cl.model.service;


import java.util.List;

import org.dgac.cl.model.dao.UsuarioDAO;
import org.dgac.cl.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO dao;

    @Override
    public List<Usuario> findAll(){
        return dao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Integer id){
        return dao.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario){
        return dao.save(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(Integer id){
        dao.deleteById(id);
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable){
        return dao.findAll(pageable);
    }




}
