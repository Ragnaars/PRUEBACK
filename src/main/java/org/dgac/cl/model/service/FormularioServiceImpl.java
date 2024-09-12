package org.dgac.cl.model.service;

import java.util.List;
import java.util.Set;

import org.dgac.cl.model.dao.FormularioDAO;
import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendiente;
import org.dgac.cl.model.view.FormularioPendienteDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FormularioServiceImpl implements FormularioService {

    @Autowired
    private FormularioDAO dao;

    @Override
    public List<Formulario> findAll() {
        return dao.findAll();
    }

    @Override
    public Page<Formulario> findAllPage(Specification<Formulario> specification, Pageable pageable) {
        return dao.findAll(specification, pageable);
    }

    @Override
    public Formulario findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Formulario save(Formulario formulario) {
        return dao.save(formulario);
    }

    
    @Override
    public Set<FormularioPendiente> getCountFormularioPendienteByCompaniaVuelo(Boolean escolta) {
        
        return dao.getCountFormularioPendienteByCompaniaVuelo(escolta);
    }

    @Override
    public Set<FormularioPendiente> getFormularioPendienteByCompaniaVuelo(Boolean escolta, CompaniaVuelo companiaVuelo) {
        
        return dao.getFormularioPendienteByCompaniaVuelo(escolta, companiaVuelo);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

}
