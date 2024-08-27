package org.dgac.cl.filter;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.ObjetoRetenido;

import lombok.Data;

@Data
public class ObjetoRetenidoFilter implements Serializable, Filtro {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String marca;
    private String modelo;
    private String serie;
    private Integer cantidad;
    private String observacion;
    private LocalDateTime fechaCreacion;
    private Integer encargado;
    private Boolean habilitado;
    private Integer formulario ;
    private String datosAdicionales;
    private Integer tipo;

    @Override
    public GenericSpecification<?> generarFiltro(){
        GenericSpecification<ObjetoRetenido> ge = new GenericSpecification<>();
        if(nombre != null && !nombre.isEmpty()){
            ge.add(new SearchCriteria("nombre", nombre, SearchOperation.MATCH));
        }

        if(marca != null && !marca.isEmpty()){
            ge.add(new SearchCriteria("marca", marca, SearchOperation.MATCH));
        }

        if(modelo != null && !modelo.isEmpty()){
            ge.add(new SearchCriteria("modelo", modelo, SearchOperation.MATCH));
        }

        if(serie != null && !serie.isEmpty()){
            ge.add(new SearchCriteria("serie", serie, SearchOperation.MATCH));
        }

        if(cantidad != null){
            ge.add(new SearchCriteria("cantidad", cantidad, SearchOperation.EQUAL));
        }

        if(observacion != null && !observacion.isEmpty()){
            ge.add(new SearchCriteria("observacion", observacion, SearchOperation.MATCH));
        }

        if(fechaCreacion != null){
            ge.add(new SearchCriteria("fechaCreacion", fechaCreacion, SearchOperation.EQUAL));
        }

        if(encargado != null){
            ge.add(new SearchCriteria("encargado", encargado, SearchOperation.EQUAL));
        }

        if(habilitado != null){
            ge.add(new SearchCriteria("habilitado", habilitado, SearchOperation.EQUAL));
        }

        if(formulario != null){
            ge.add(new SearchCriteria("formulario", formulario, SearchOperation.EQUAL));
        }

        if(datosAdicionales != null && !datosAdicionales.isEmpty()){
            ge.add(new SearchCriteria("datosAdicionales", datosAdicionales, SearchOperation.MATCH));
        }

        if(tipo != null){
            ge.add(new SearchCriteria("tipo", tipo, SearchOperation.EQUAL));
        }

        return ge;
        
    }




}
