package org.dgac.cl.siscred.model.service;

import java.util.List;

import org.dgac.cl.siscred.model.dao.SolicitudSiscredDAO;
import org.dgac.cl.siscred.model.entity.SolicitudSiscred;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudSiscredServiceImpl implements SolicitudSiscredService {   

    @Autowired
    private SolicitudSiscredDAO dao;

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);    
    }

    @Override
    public List<SolicitudSiscred> findAll() {
        return dao.findAll();
    }

    @Override
    public List<SolicitudSiscred> findAllById(List<Integer> ids) {
        return dao.findAllById(ids);
    }

    @Override
    public SolicitudSiscred findById(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public SolicitudSiscred save(SolicitudSiscred solicitudSiscred) {
        return dao.save(solicitudSiscred);
    }

    @Override
    public SolicitudSiscred findByNtica(Integer id) {

        return dao.findByNtica(id);
    }

 
    
    

    
}
