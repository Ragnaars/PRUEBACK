package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.filter.FormularioFilter;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class FormularioNegocio {

    @Autowired FormularioService service;
    
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

    public String deleteById(Long id) throws Exception{
        Formulario formularioExistente = service.findById(id);

        if(formularioExistente == null){
            throw new Exception("Formulario no encontrado");
        }else{
            service.deleteById(id);
            return "Formulario con ID " + id + " eliminado";
        }
    }

    public void registroFase1(Formulario formulario) {

        // registro formulario

        // añadir lista de objetos

        // generar notificaciones

        // actualizar estado formulario
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
}
