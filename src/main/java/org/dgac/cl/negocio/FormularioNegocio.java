package org.dgac.cl.negocio;

import java.util.List;
import java.util.Set;

import org.dgac.cl.constantes.ConstantesEstadoFormulario;
import org.dgac.cl.filter.FormularioFilter;
import org.dgac.cl.model.dto.FormularioPendienteFiltro;
import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.EstadoFormulario;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.service.CompaniaVueloService;
import org.dgac.cl.model.service.FormularioService;
import org.dgac.cl.model.service.ObjetoRetenidoService;
import org.dgac.cl.model.view.FormularioPendiente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class FormularioNegocio {

    @Autowired FormularioService service;
    @Autowired CompaniaVueloService companiaVueloService;
    @Autowired ObjetoRetenidoService objetosRetenidosService;
    
    public List<Formulario> findAll(){
        return service.findAll();
    }

    public Page<Formulario> findAllPage(FormularioFilter filtro, Pageable pageable) {
        return service.findAllPage(filtro.generarFiltro(), pageable);
    }

    public Formulario findById(Long id){
        return service.findById(id);
    }

    public Formulario save(Formulario formulario){
        return service.save(formulario);
    }

    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            Formulario formularioExistente = service.findById(id);
            
            if (formularioExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formulario con ID " + id + " no encontrado");
            }

            service.deleteById(id);
            return ResponseEntity.ok("Formulario con ID " + id + " eliminado exitosamente");
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el formulario: " + e.getMessage());
        }
    }

    public Formulario registroFase1(Formulario formulario) throws Exception {
    
        // validar formulario
        if(formulario.getEstado() != null) {
            throw new Exception("Estado no válido");
        }

        // registro companiaVuelo;
        companiaVueloService.save(formulario.getCompaniaVuelo());

        // registro formulario y fijar estado pendiente
        formulario.setEstado(EstadoFormulario.builder().id(ConstantesEstadoFormulario.PENDIENTE).build());
        final Formulario formAux = service.save(formulario);

        // añadir lista de objetos
        formulario.getObjetosRetenidos().forEach(o -> {
            o.setFormulario(Formulario.builder().id(formAux.getId()).build());
        });

        objetosRetenidosService.saveAll(formulario.getObjetosRetenidos());

        // generar notificaciones


        return formulario;
    }

    /**
     * deshabilita un formulario
     * @param id
     * @throws Exception 
     */
    public void deshabilitarFormulario(Long id) throws Exception {
        // buscar formulario
        Formulario formulario = service.findById(id);
        if(formulario == null) {
            throw new Exception("formulario no encontrado");
        }

        // deshabilitar formulario
        formulario.setHabilitado(false);
        service.save(formulario);
    }

    public Set<FormularioPendiente> getCountFormularioPendienteNoEscoltaByCompaniaVuelo(FormularioPendienteFiltro filtro) {
        filtro.setEscolta(false);
        return service.getCountFormularioPendienteByCompaniaVuelo(filtro);
    }

    public Set<FormularioPendiente> getCountFormularioPendienteEscoltaByCompaniaVuelo(FormularioPendienteFiltro filtro) {
        filtro.setEscolta(true);
        return service.getCountFormularioPendienteByCompaniaVuelo(filtro);
    }
    
    public Set<FormularioPendiente> getFormularioPendienteNoEscoltaByCompaniaVuelo(Integer companiaAerea, Integer numeroVuelo) {
        return service.getFormularioPendienteByCompaniaVuelo(false, CompaniaVuelo.builder().numeroVuelo(numeroVuelo).companiaAerea(companiaAerea).build());
    }

    public Set<FormularioPendiente> getFormularioPendienteEscoltaByCompaniaVuelo(Integer companiaAerea, Integer numeroVuelo) {
        return service.getFormularioPendienteByCompaniaVuelo(true, CompaniaVuelo.builder().numeroVuelo(numeroVuelo).companiaAerea(companiaAerea).build());
    }

    public Set<FormularioPendiente> getCountFormularioTrasladoByCompaniaVuelo(FormularioPendienteFiltro filtro) {
        filtro.setEscolta(false);
        return service.getCountFormularioByCompaniaVuelo(filtro);
    }
}
