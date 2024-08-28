package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.model.entity.CompaniaAerea;
import org.dgac.cl.model.service.CompaniaAereaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompaniaAereaNegocio  {

    @Autowired
    private CompaniaAereaService service;

    public List<CompaniaAerea> findAll(){
        return service.findAll();
    }

    public CompaniaAerea findById(Integer id){
        return service.findById(id);
    }

    public CompaniaAerea save(CompaniaAerea companiaAerea){
        return service.save(companiaAerea);
    }

    public String deleteById(Integer id) throws Exception{
        CompaniaAerea companiaExistente = service.findById(id);

        if(companiaExistente == null){
            throw new Exception("Compania no existe");
        }else{
            service.deleteById(id);
            return "Compania con ID " +id+ " Ha sido eliminado correctamente";
        }
    }

    public String findByNombre(String nombre){
        List<CompaniaAerea> companiaExistente = service.findByNombre(nombre);

        if(companiaExistente.isEmpty()){
            CompaniaAerea nuevaCompania = new CompaniaAerea();
            nuevaCompania.setNombre(nombre);
            nuevaCompania.setHabilitado(true);

            service.save(nuevaCompania);
            return "Nueva compañia creada : " + nuevaCompania.getNombre();
        }else{
            return "Compañia ya existente, no se necesita crear";
        }

    }

    



}
