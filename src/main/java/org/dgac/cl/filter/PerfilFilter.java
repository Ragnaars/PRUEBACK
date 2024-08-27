package org.dgac.cl.filter;

import java.io.Serializable;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.Perfil;

import lombok.Data;

@Data
public class PerfilFilter implements Serializable, Filtro {

    private static final long serialVersionUID = 1L;
    private String nombre;

    @Override
    public GenericSpecification<?> generarFiltro(){
        GenericSpecification<Perfil> ge = new GenericSpecification<>();

        if(nombre != null && !nombre.isEmpty()){
            ge.add(new SearchCriteria("nombre",nombre,SearchOperation.MATCH));
        }
        return ge;
        
    }
    

}
