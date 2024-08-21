package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.EstadoFormularioDAO;
import org.dgac.cl.model.entity.EstadoFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoFormularioServiceImpl implements EstadoFormularioService{

    @Autowired
    private EstadoFormularioDAO dao;

    @Override
    public List<EstadoFormulario> findAll(){
        return dao.findAll();
    }
    @Override
    public EstadoFormulario findById(Integer id){
        return dao.findById(id).orElse(null);
    }
    @Override
    public EstadoFormulario save(EstadoFormulario estadoFormulario){
        return dao.save(estadoFormulario);
    }
    
    @Override
    public void deleteById(Integer id){
        dao.deleteById(id);
    }


    

}
