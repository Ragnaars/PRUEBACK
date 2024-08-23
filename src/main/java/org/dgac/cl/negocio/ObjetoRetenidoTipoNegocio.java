package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.ObjetoRetenidoTipo;
import org.dgac.cl.model.service.ObjetoRetenidoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjetoRetenidoTipoNegocio {

    @Autowired
    private ObjetoRetenidoTipoService service;

    public List<ObjetoRetenidoTipo> findAll(){
        return service.findAll();
    }

    public ObjetoRetenidoTipo findById(Integer id){
        return service.findById(id);
    }

    public ObjetoRetenidoTipo save(ObjetoRetenidoTipo objetoRetenidoTipo){
        return service.save(objetoRetenidoTipo);
    }

    public String deleteById(Integer id) throws Exception{
        ObjetoRetenidoTipo objRetTipoExistente = service.findById(id);
        if(objRetTipoExistente == null){
            throw new Exception("Objeto Retenido Tipo no encontrado");
        }else{
            service.deleteById(id);
            return "Objeto Retenido Tipo con ID " +id+ " Ha sido eliminado correctamente";
        }
    }

}
