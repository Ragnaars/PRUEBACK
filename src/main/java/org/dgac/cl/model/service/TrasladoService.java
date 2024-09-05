package org.dgac.cl.model.service;

import java.util.List;
import org.dgac.cl.model.entity.Traslado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface TrasladoService {
    public List<Traslado> findAll();
    public Traslado findById(Integer id);
    public Page<Traslado> findAllPage(Specification<Traslado> specification, Pageable pageable);
    public Traslado save(Traslado traslado);
}
