package org.dgac.cl.model.service;


import java.util.List;

import org.dgac.cl.model.entity.Parametro;

public interface ParametroService {

    public List<Parametro> findAll();
    public Parametro findById(String id);
    public Parametro save(Parametro parametro);
    public void deleteById(String id);

}
