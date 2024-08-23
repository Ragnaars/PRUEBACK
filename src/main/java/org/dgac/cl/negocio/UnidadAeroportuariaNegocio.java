package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.UnidadAeroportuaria;
import org.dgac.cl.model.service.UnidadAeroportuariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnidadAeroportuariaNegocio {

    @Autowired 
    private UnidadAeroportuariaService service;

    public List<UnidadAeroportuaria> findAll(){
        return service.findAll();
    }

    public UnidadAeroportuaria findById(Integer id){
        return service.findById(id);
    }

    public UnidadAeroportuaria save(UnidadAeroportuaria unidadAeroportuaria){
        return service.save(unidadAeroportuaria);
    }

    public String deleteById(Integer id) throws Exception{
        UnidadAeroportuaria unidadAeroportuariaExistente = service.findById(id);

        if(unidadAeroportuariaExistente == null){
            throw new Exception("Unidad Aeroportuaria no encontrada");
        }else{
            service.deleteById(id);
            return "Unidad Aeroportuaria con ID " +id+" Ha sido eliminado correctamente";
        }
    }

}
