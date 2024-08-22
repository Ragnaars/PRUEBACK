package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.Formulario;

public interface FormularioService {
    public List<Formulario> findAll();
    public Formulario findById(Long id);
    public Formulario save(Formulario formulario);
    public void deleteById(Long id);
    


}
