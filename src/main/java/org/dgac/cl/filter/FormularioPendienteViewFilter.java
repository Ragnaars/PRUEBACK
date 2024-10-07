package org.dgac.cl.filter;

import java.io.Serializable;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.view.FormularioPendienteView;
import org.dgac.cl.model.view.TrasladoPendienteView;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormularioPendienteViewFilter implements Serializable, Filtro  {

    private static final long serialVersionUID = 1L; 

    private Long idFormulario;
    private CompaniaVuelo companiaVuelo;
    private Boolean requiereEscolta;
    private Long totalTickets;
    private Integer puenteEmbarque;
    private String origen;
    private String destino;
    private Integer companiaAerea;
    private TrasladoPendienteView traslado;
    private Integer vuelo;
    private Integer estadoTraslado;

    @Override
    public GenericSpecification<FormularioPendienteView> generarFiltro() {
        GenericSpecification<FormularioPendienteView> ge = new GenericSpecification<>();
        if (idFormulario != null) {
            ge.add(new SearchCriteria("idFormulario", idFormulario, SearchOperation.MATCH));
        }
        if (companiaAerea != null) {
            ge.add(new SearchCriteria("companiaVuelo", "companiaAerea", companiaAerea,
                    SearchOperation.CHAIN));
        }
        // if (companiaVuelo != null) {
        //     ge.add(new SearchCriteria("companiaVuelo", companiaVuelo, SearchOperation.MATCH));
        // }
        if (requiereEscolta != null) {
            ge.add(new SearchCriteria("requiereEscolta", requiereEscolta, SearchOperation.MATCH));
        }
        if (totalTickets != null) {
            ge.add(new SearchCriteria("totalTickets", totalTickets, SearchOperation.MATCH));
        }
        if (puenteEmbarque != null) {
            ge.add(new SearchCriteria("puenteEmbarque", puenteEmbarque, SearchOperation.MATCH));
        }
        if (origen != null) {
            ge.add(new SearchCriteria("origen", origen, SearchOperation.MATCH));
        }
        if (destino != null) {
            ge.add(new SearchCriteria("destino", destino, SearchOperation.MATCH));
        }
        if (traslado != null) {
            ge.add(new SearchCriteria("traslado", traslado, SearchOperation.MATCH));
        }
        
        if (vuelo != null && vuelo != 0) {
            ge.add(new SearchCriteria("companiaVuelo", "numeroVuelo", vuelo,
                    SearchOperation.CHAIN));
        }
        
        if (estadoTraslado != null && estadoTraslado != 0) {
            ge.add(new SearchCriteria("traslado,estadoTraslado", "id",  estadoTraslado, SearchOperation.CHAIN));
        }


        return ge;
    }

}
