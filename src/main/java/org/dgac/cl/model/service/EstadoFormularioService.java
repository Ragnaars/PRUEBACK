package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.EstadoFormulario;

public interface EstadoFormularioService {

    public List<EstadoFormulario> findAll();
    public EstadoFormulario findById(Integer id);
    public EstadoFormulario save(EstadoFormulario estadoFormulario);
    public void deleteById(Integer id);


}
