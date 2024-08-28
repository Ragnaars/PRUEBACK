package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.ObjetoRetenidoTipo;

public interface ObjetoRetenidoTipoService {

    public List<ObjetoRetenidoTipo> findAll();

    public ObjetoRetenidoTipo findById(Integer id);

    public ObjetoRetenidoTipo save(ObjetoRetenidoTipo objetoRetenidoTipo);

    public void deleteById(Integer id);

    public ObjetoRetenidoTipo findByNombre(String nombre);

}
