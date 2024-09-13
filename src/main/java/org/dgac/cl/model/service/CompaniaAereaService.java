package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.CompaniaAerea;

public interface CompaniaAereaService {

    public List<CompaniaAerea> findAll();
    public CompaniaAerea findById(Integer id);
    public CompaniaAerea save(CompaniaAerea companiaAerea);
    public void deleteById(Integer id);
    public List<CompaniaAerea> findByNombre(String nombre);
    

}
