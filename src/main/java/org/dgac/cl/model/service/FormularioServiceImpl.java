package org.dgac.cl.model.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.dgac.cl.model.dao.FormularioDAO;
import org.dgac.cl.model.dto.FormularioPendienteFiltro;
import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendiente;
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
    public Set<FormularioPendiente> getCountFormularioPendienteByCompaniaVuelo(FormularioPendienteFiltro filtro) {
        
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //Date fechaDesde = Date.from(filtro.getFechaDesde().atStartOfDay(defaultZoneId).toInstant());
        //Date fechaHasta = filtro.getFechaHasta() != null? Date.from(filtro.getFechaHasta().atStartOfDay(defaultZoneId).toInstant()) : null;

        Timestamp fechaDesde = Timestamp.valueOf(filtro.getFechaDesde().atStartOfDay());
        Timestamp fechaHasta = Timestamp.valueOf(filtro.getFechaHasta().atStartOfDay());

        /*
         * return dao.getCountFormularioPendienteByCompaniaVuelo(filtro.getEscolta(), filtro.getCompaniaAerea(),
            filtro.getNumeroVuelo(), filtro.getPuenteEmbarque(), filtro.getFechaDesde(), filtro.getFechaHasta());
         */

        return dao.getCountFormularioPendienteByCompaniaVuelo(filtro.getEscolta(), filtro.getCompaniaAerea(),
            filtro.getNumeroVuelo(), filtro.getPuenteEmbarque(), fechaDesde, fechaHasta);
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
    public Set<FormularioPendiente> getFormularioPendienteByCompaniaVuelo(Boolean escolta, CompaniaVuelo companiaVuelo) {
        
        return dao.getFormularioPendienteByCompaniaVuelo(escolta, companiaVuelo);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

}
