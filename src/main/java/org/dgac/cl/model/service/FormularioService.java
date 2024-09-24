package org.dgac.cl.model.service;

import java.util.List;
import java.util.Set;

import org.dgac.cl.model.dto.FormularioPendienteFiltro;
import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendienteView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface FormularioService {
    public List<Formulario> findAll();
    public List<Formulario> findAllById(List<Long> ids);
    public Page<Formulario> findAllPage(Specification<Formulario> specification, Pageable pageable);
    public Formulario findById(Long id);
    public Formulario save(Formulario formulario);
    public void deleteById(Long id);
    public Set<FormularioPendienteView> getCountFormularioPendienteByCompaniaVuelo(FormularioPendienteFiltro filtro);
    public Set<FormularioPendienteView> getFormularioPendienteByCompaniaVuelo(Boolean escolta, CompaniaVuelo companiaVuelo);
    public Set<FormularioPendienteView> getCountFormularioByCompaniaVuelo(FormularioPendienteFiltro filtro);
    public Set<FormularioPendienteView> getFormularioByCompaniaVuelo(FormularioPendienteFiltro filtro);
}
