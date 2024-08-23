package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.PuenteEmbarque;
import org.dgac.cl.model.service.PuenteEmbarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PuenteEmbarqueNegocio {

    @Autowired
    private PuenteEmbarqueService service;

    public List<PuenteEmbarque> findAll(){
        return service.findAll();
    }

    public PuenteEmbarque findById(Integer id){
        return service.findById(id);
    }

    public PuenteEmbarque save(PuenteEmbarque puenteEmbarque){
        return service.save(puenteEmbarque);
    }

    public String deleteById(Integer id) throws Exception{
        PuenteEmbarque puenteEmbExistente = service.findById(id);

        if(puenteEmbExistente == null){
            throw new Exception("Puente Embarque no encontrado");
        }else{
            service.deleteById(id);
            return "Puente Embarque con ID " +id+" Ha sido eliminado correctamente";
        }
    }




}
