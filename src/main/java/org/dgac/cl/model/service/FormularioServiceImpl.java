package org.dgac.cl.model.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.dgac.cl.model.dao.FormularioDAO;
import org.dgac.cl.model.dto.FormularioPendienteFiltro;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendienteView;
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
    public List<Formulario> findAllById(List<Long> ids) {

        return dao.findAllById(ids);
    }

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
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Set<FormularioPendienteView> getCountFormulario(FormularioPendienteFiltro filtro) {

        return dao.getCountFormulario(filtro.getCompaniaAerea(), filtro.getNumeroVuelo(), null);
    }

    @Override
    public Set<FormularioPendienteView> getCountFormularioPendiente(FormularioPendienteFiltro filtro) {

        return dao.getCountFormularioPendiente(filtro.getCompaniaAerea(), filtro.getNumeroVuelo(), null);
    }

    @Override
    public Set<FormularioPendienteView> findFormularioByTraslado(Integer traslado) {
        
        return dao.findFormularioByTraslado(traslado);
    }

    @Override
    public Set<FormularioPendienteView> findFormulario(FormularioPendienteFiltro filtro) {

        return dao.findFormulario(filtro.getPuenteEmbarque(), filtro.getFechaHoraVuelo(), filtro.getOrigen(), filtro.getDestino(), filtro.getEscolta(), filtro.getCompaniaAerea(), filtro.getNumeroVuelo());

    }

    @Override
    public Set<Formulario> filtrarFormularios(Integer companiaAerea, Integer numeroVuelo, Integer estadoTraslado, String origen, String destino, Boolean requiereEscolta, LocalDate fechaVuelo) {
        return dao.filtrarFormularios(companiaAerea, numeroVuelo, estadoTraslado, origen, destino, requiereEscolta, fechaVuelo);
    }

    @Override
    public List<Formulario> findAll(Specification<Formulario> specification) {

        return dao.findAll(specification);
    }

    @Override
    public Set<FormularioPendienteView> filtrarTraslados(Integer companiaAerea, Integer numeroVuelo, Integer puenteEmbarque, Integer estadoTraslado, LocalDate fechaVuelo, String origen, String destino) {
        return dao.filtrarTraslados(companiaAerea, numeroVuelo, puenteEmbarque, estadoTraslado, fechaVuelo, origen, destino);
    }

}
