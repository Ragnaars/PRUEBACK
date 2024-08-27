package org.dgac.cl.filter;

import java.io.Serializable;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.PuenteEmbarque;

import lombok.Data;

@Data
public class PuenteEmbarqueFilter implements Serializable, Filtro {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private Integer unidadAeroportuaria;
    private String creadoPor;
    private Boolean habilitado;

    public GenericSpecification<?> generarFiltro(){
        GenericSpecification<PuenteEmbarque> ge = new GenericSpecification<>();

        if(nombre != null && !nombre.isEmpty()){
            ge.add(new SearchCriteria("nombre",nombre, SearchOperation.MATCH));
        }

        if(unidadAeroportuaria != null ){
            ge.add(new SearchCriteria("nombre",nombre,SearchOperation.MATCH));
        }

        if(creadoPor != null && !creadoPor.isEmpty()){
            ge.add(new SearchCriteria("creadoPor",creadoPor, SearchOperation.EQUAL));
        }

        if(habilitado != null){
            ge.add(new SearchCriteria("habilitado", habilitado, SearchOperation.EQUAL));
        }
        return ge;
    }



}
