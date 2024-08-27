package org.dgac.cl.filter;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.EstadoFormulario;

import lombok.Data;


@Data
public class EstadoFormularioFilter implements Serializable, Filtro {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private Boolean habilitado;
    private LocalDateTime fechaCreacion;

    @Override
    public GenericSpecification<?> generarFiltro() {
        GenericSpecification<EstadoFormulario> ge = new GenericSpecification<>();
        if(nombre != null && !nombre.isEmpty()) {
            ge.add(new SearchCriteria("nombre", nombre, SearchOperation.EQUAL));
        }  
        if(habilitado != null) {
            ge.add(new SearchCriteria("habilitado", habilitado, SearchOperation.EQUAL));
        }
        if(fechaCreacion != null) {
            ge.add(new SearchCriteria("fechaCreacion", fechaCreacion, SearchOperation.EQUAL));
        }
        return ge;     
    }
}
