package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.ObjetoRetenidoTipoDAO;
import org.dgac.cl.model.entity.ObjetoRetenidoTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetoRetenidoTipoImpl implements ObjetoRetenidoTipoService {

    @Autowired
    private ObjetoRetenidoTipoDAO dao;

    @Override
    public List<ObjetoRetenidoTipo> findAll(){
        return dao.findAll();
    }

    @Override
    public ObjetoRetenidoTipo findById(Integer id){
        return dao.findById(id).orElse(null);
    }

    @Override
    public ObjetoRetenidoTipo save(ObjetoRetenidoTipo objetoRetrnidoTipo){
        return dao.save(objetoRetrnidoTipo);
    }

    @Override
    public void deleteById(Integer id){
        dao.deleteById(id);
    }

    @Override
    public ObjetoRetenidoTipo findByNombre(String nombre){
        return dao.findByNombre(nombre);
    }





    

}
