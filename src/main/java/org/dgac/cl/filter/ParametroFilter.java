package org.dgac.cl.filter;

import java.io.Serializable;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.Parametro;

import lombok.Data;

@Data
public class ParametroFilter implements Serializable, Filtro {

    private static final long serialVersionUID= 1L;
    private String id;  
    private String valor;

    @Override
    public GenericSpecification<Parametro> generarFiltro(){
        GenericSpecification<Parametro> ge = new GenericSpecification<>();

        if(id != null && !id.isEmpty()){
            ge.add(new SearchCriteria("id",id, SearchOperation.MATCH));
        }

        if(valor != null && !valor.isEmpty()){
            ge.add(new SearchCriteria("valor",valor,SearchOperation.MATCH));
        }

        return ge;

    }

}
