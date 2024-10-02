package org.dgac.cl.modelSiscred.service;

import java.util.List;

import org.dgac.cl.modelSiscred.entity.SolicitudSiscred;

public interface SolicitudSiscredService {

    public List<SolicitudSiscred> findAll();
    public List<SolicitudSiscred> findAllById(List<Integer> ids);
    public SolicitudSiscred findById(Integer id);
    public SolicitudSiscred save(SolicitudSiscred solicitudSiscred);
    public void deleteById(Integer id);
    
}
