package org.dgac.cl.filter;

import java.io.Serializable;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.UnidadAeroportuaria;

import lombok.Data;

@Data
public class UnidadAeroportuariaFilter implements Serializable, Filtro {

    private static final long serialVersionUID = 1L;
    private String oaci;
    private String nombre;
    private String creadoPor; 
    private Boolean habilitado;
    private String iata;

    @Override
    public GenericSpecification<?> generarFiltro(){
        GenericSpecification<UnidadAeroportuaria> ge = new GenericSpecification<>();
        if(oaci != null && !oaci.isEmpty()){
            ge.add(new SearchCriteria("oaci",oaci, SearchOperation.MATCH));
        }

        if(nombre != null && !nombre.isEmpty()){
            ge.add(new SearchCriteria("noombre", nombre, SearchOperation.MATCH));
        }
        if(creadoPor != null && !creadoPor.isEmpty()){
            ge.add(new SearchCriteria("creadoPor", creadoPor, SearchOperation.MATCH));
        }
        if(habilitado !=null){
            ge.add(new SearchCriteria("habilitado",habilitado, SearchOperation.EQUAL));
        }

        if(iata !=null && !iata.isEmpty()){
            ge.add(new SearchCriteria("iata",iata, SearchOperation.MATCH));
        }   
        return ge;
    }



}
