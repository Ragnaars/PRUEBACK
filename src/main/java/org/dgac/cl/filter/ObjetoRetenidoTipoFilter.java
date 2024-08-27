package org.dgac.cl.filter;

import java.io.Serializable;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.ObjetoRetenidoTipo;

import lombok.Data;

@Data
public class ObjetoRetenidoTipoFilter implements Serializable, Filtro {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String datosAdicionales;
    private String fechaCreacion;
    private Boolean habilitado;

    @Override
    public GenericSpecification<?> generarFiltro() {
        GenericSpecification<ObjetoRetenidoTipo> ge = new GenericSpecification<>();
        if(nombre != null && !nombre.isEmpty()) {
            ge.add(new SearchCriteria("nombre", nombre, SearchOperation.EQUAL));
        }  
        if(datosAdicionales != null && !datosAdicionales.isEmpty()) {
            ge.add(new SearchCriteria("datosAdicionales", datosAdicionales, SearchOperation.EQUAL));
        }
        if(fechaCreacion != null && !fechaCreacion.isEmpty()) {
            ge.add(new SearchCriteria("fechaCreacion", fechaCreacion, SearchOperation.EQUAL));
        }
        if(habilitado != null) {
            ge.add(new SearchCriteria("habilitado", habilitado, SearchOperation.EQUAL));
        }
        return ge;     
    }

}
