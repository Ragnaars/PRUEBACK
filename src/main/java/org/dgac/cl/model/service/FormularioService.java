package org.dgac.cl.model.service;

import java.util.List;
import java.util.Set;

import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendiente;
import org.dgac.cl.model.view.FormularioPendienteDetalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface FormularioService {
    public List<Formulario> findAll();
    public Page<Formulario> findAllPage(Specification<Formulario> specification, Pageable pageable);
    public Formulario findById(Long id);
    public Formulario save(Formulario formulario);
    public void deleteById(Long id);
    public Set<FormularioPendiente> getCountFormularioPendienteByCompaniaVuelo(Boolean escolta);
    public Set<FormularioPendiente> getFormularioPendienteByCompaniaVuelo(Boolean escolta);
}
