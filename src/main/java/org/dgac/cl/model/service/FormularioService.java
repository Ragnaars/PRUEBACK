package org.dgac.cl.model.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.dgac.cl.model.dto.FormularioPendienteFiltro;
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
    public Set<FormularioPendienteView> getCountFormularioPendiente(FormularioPendienteFiltro filtro);
    public Set<FormularioPendienteView> getCountFormulario(FormularioPendienteFiltro filtro);
    public Set<FormularioPendienteView> findFormulario(FormularioPendienteFiltro filtro);
    public Set<FormularioPendienteView> findFormularioByTraslado(Integer traslado);
    public Set<Formulario> filtrarFormularios(
        Integer companiaAerea, 
        Integer numeroVuelo, 
        Integer estadoTraslado, 
        String origen, 
        String destino, 
        Boolean requiereEscolta, 
        LocalDate fechaVuelo);
    public List<Formulario> findAll(Specification<Formulario> specification);
    public Set<FormularioPendienteView> filtrarTraslados (
        Integer companiaAerea,
        Integer numeroVuelo,
        Integer puenteEmbarque,    
        Integer estadoTraslado,
        LocalDate fechaVuelo,
        String origen,
        String destino
    );
        
}
