package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.ObjetoRetenido;
import org.dgac.cl.model.service.ObjetoRetenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjetoRetenidoNegocio {

    @Autowired ObjetoRetenidoService service;

    public List<ObjetoRetenido> findAll(){
        return service.findAll();
    }

    public ObjetoRetenido findById(Long id){
        return service.findById(id);
    }

    public ObjetoRetenido save(ObjetoRetenido objetoRetenido){
        return service.save(objetoRetenido);
    }

    public String deleteById(Long id) throws Exception{
        ObjetoRetenido objRetExistente = service.findById(id);

        if(objRetExistente == null){
            throw new Exception("ObjetoRetenido no encontrado");
        }else{
            service.deleteById(id);
            return "Objeto retenido con ID " + id + " eliminado";
        }
    }

}
