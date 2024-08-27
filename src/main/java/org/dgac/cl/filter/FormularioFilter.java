package org.dgac.cl.filter;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.entity.Usuario;

import lombok.Data;


@Data
public class FormularioFilter implements Serializable, Filtro {

    private static final long serialVersionUID = 1L;

    private LocalDateTime fechaHoraRegistro;

    private Integer asientoPax;

    private String companiaNombre;

    private String origen;

    private String destino;

    private String vuelo;

    private Integer puenteEmbarque;

    private String particular;

    private String paxNombre;

    private String ticket;

    private Usuario userAvsec;

    private String paxNumeroTelefono;

    private Integer estado; 

    private String paxRut;

    private String paxPasaporte;

    private String paxEmail;

    private String escalaVuelo;

    private String escalaCompania;

    private String escalaOrigen;

    private String escalaDestino;

    private Integer escalaFecha;

    private Usuario userAvsecIngresa;

    private String userAvsecIngresaFirma;

    private Usuario userAvsecRetira;

    private String userAvsecRetiraFirma;

    private Integer unidadAeroportuaria;

    @Override    
    public GenericSpecification<Formulario> generarFiltro(){
        GenericSpecification<Formulario> ge = new GenericSpecification<>();
        if(fechaHoraRegistro != null ){
            ge.add(new SearchCriteria("fechaHoraRegistro", fechaHoraRegistro, SearchOperation.MATCH));
        }
        if(asientoPax != null && asientoPax != 0){
            ge.add(new SearchCriteria("asientoPax", asientoPax, SearchOperation.MATCH));
        }

        if(companiaNombre != null && !companiaNombre.isEmpty()){
            ge.add(new SearchCriteria("companiaNombre", companiaNombre, SearchOperation.MATCH));
        }

        if(origen != null && !origen.isEmpty()){
            ge.add(new SearchCriteria("origen", origen, SearchOperation.MATCH));
        }

        if(destino != null && !destino.isEmpty()){
            ge.add(new SearchCriteria("destino", destino, SearchOperation.MATCH));
        }

        if(vuelo != null && !vuelo.isEmpty()){
            ge.add(new SearchCriteria("vuelo", vuelo, SearchOperation.MATCH));
        }

        if(puenteEmbarque != null && puenteEmbarque != 0){
            ge.add(new SearchCriteria("puenteEmbarque", puenteEmbarque, SearchOperation.MATCH));
        }

        if(particular != null && !particular.isEmpty()){
            ge.add(new SearchCriteria("particular", particular, SearchOperation.MATCH));
        }


        if(paxNombre != null && !paxNombre.isEmpty()){
            ge.add(new SearchCriteria("paxNombre", paxNombre, SearchOperation.MATCH));
        }

        if(ticket != null && !ticket.isEmpty()){
            ge.add(new SearchCriteria("tiket", ticket, SearchOperation.MATCH));
        }

        if(userAvsec != null){
            ge.add(new SearchCriteria("userAvsec", userAvsec, SearchOperation.MATCH));
        }

        if(paxNumeroTelefono != null && !paxNumeroTelefono.isEmpty()){
            ge.add(new SearchCriteria("paxNumeroTelefono", paxNumeroTelefono, SearchOperation.MATCH));
        }

        if(estado != null && estado != 0){
            ge.add(new SearchCriteria("estado", estado, SearchOperation.MATCH));
        }

        if(paxRut != null && !paxRut.isEmpty()){
            ge.add(new SearchCriteria("paxRut", paxRut, SearchOperation.MATCH));
        }

        if(paxPasaporte != null && !paxPasaporte.isEmpty()){
            ge.add(new SearchCriteria("paxPasaporte", paxPasaporte, SearchOperation.MATCH));
        }

        if(paxEmail != null && !paxEmail.isEmpty()){
            ge.add(new SearchCriteria("paxEmail", paxEmail, SearchOperation.MATCH));
        }

        if(escalaVuelo != null && !escalaVuelo.isEmpty()){
            ge.add(new SearchCriteria("escalaVuelo", escalaVuelo, SearchOperation.MATCH));
        }

        if(escalaCompania != null && !escalaCompania.isEmpty()){
            ge.add(new SearchCriteria("escalaCompania", escalaCompania, SearchOperation.MATCH));
        }

        if(escalaOrigen != null && !escalaOrigen.isEmpty()){
            ge.add(new SearchCriteria("escalaOrigen", escalaOrigen, SearchOperation.MATCH));
        }

        if(escalaDestino != null && !escalaDestino.isEmpty()){
            ge.add(new SearchCriteria("escalaDestino", escalaDestino, SearchOperation.MATCH));
        }

        if(escalaFecha != null && escalaFecha != 0){
            ge.add(new SearchCriteria("escalaFecha", escalaFecha, SearchOperation.MATCH));
        }

        if(userAvsecIngresa != null){
            ge.add(new SearchCriteria("userAvsecIngresa", userAvsecIngresa, SearchOperation.MATCH));
        }

        if(userAvsecIngresaFirma != null && !userAvsecIngresaFirma.isEmpty()){
            ge.add(new SearchCriteria("userAvsecIngresaFirma", userAvsecIngresaFirma, SearchOperation.MATCH));
        }

        if(userAvsecRetira != null){
            ge.add(new SearchCriteria("userAvsecRetira", userAvsecRetira, SearchOperation.MATCH));
        }

        if(userAvsecRetiraFirma != null && !userAvsecRetiraFirma.isEmpty()){
            ge.add(new SearchCriteria("userAvsecRetiraFirma", userAvsecRetiraFirma, SearchOperation.MATCH));
        }

        if(unidadAeroportuaria != null && unidadAeroportuaria != 0){
            ge.add(new SearchCriteria("unidadAeroportuaria", unidadAeroportuaria, SearchOperation.MATCH));
        }

        return ge;


    }

}
