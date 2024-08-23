package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormularioNegocio {

    @Autowired FormularioService service;
    
    public List<Formulario> findAll(){
        return service.findAll();
    }

    public Formulario findById(Long id){
        return service.findById(id);
    }

    public Formulario save(Formulario formulario){
        return service.save(formulario);
    }

    public void deleteById(Long id) throws Exception{
        Formulario formularioExistente = service.findById(id);

        if(formularioExistente != null){
            service.deleteById(id);
            throw new Exception("Formulario no encontrado");
        }
    }

}
