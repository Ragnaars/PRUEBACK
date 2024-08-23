package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.EstadoFormulario;
import org.dgac.cl.model.service.EstadoFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoFormularioNegocio {

    @Autowired
    private EstadoFormularioService service;

    public List<EstadoFormulario> findAll(){
        return service.findAll();
    }

    public EstadoFormulario findById(Integer id){
        return service.findById(id);
    }

    public EstadoFormulario save(EstadoFormulario estadoFormulario){
        return save(estadoFormulario);
    }

    public String deleteById(Integer id) throws Exception{
        EstadoFormulario estadoFormularioExistente = service.findById(id);

        if(estadoFormularioExistente == null){
            throw new Exception("Estado formulario no existe");
        }else{
            service.deleteById(id);
            return "Estado Formulario con ID " +id+ " Ha sido eliminado correctamente";
        }
    }

}
