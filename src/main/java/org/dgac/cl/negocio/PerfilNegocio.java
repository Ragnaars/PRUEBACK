package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.Perfil;
import org.dgac.cl.model.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerfilNegocio {

    @Autowired 
    private PerfilService service;

    public List<Perfil> findAll(){
        return service.findAll();
    }

    public Perfil findById(Integer id){
        return service.findById(id);
    }

    public Perfil save(Perfil perfil){
        return service.save(perfil);
    }	

    public String deleteById(Integer id) throws Exception{
        Perfil perfilExistente = service.findById(id);

        if(perfilExistente == null){
            throw new Exception("Perfil no encontrado");
        }else{
            service.deleteById(id);
            return "Perfil con ID " + id + " eliminado";
        }
    }

}
