package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.UnidadAeroportuaria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnidadAeroportuariaService {
    public List<UnidadAeroportuaria> findAll();
    public UnidadAeroportuaria findById(Integer id);
    public UnidadAeroportuaria save(UnidadAeroportuaria unidadAeroportuaria);
    public void deleteById(Integer id);
    public Page<UnidadAeroportuaria> findAll(Pageable pageable);

}
