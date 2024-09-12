package org.dgac.cl.model.view;

import java.time.LocalDateTime;
import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.PuenteEmbarque;

import lombok.Data;

@Data
public class FormularioPendiente {
    private Long idFormulario;
    private LocalDateTime fechaHoraVuelo;
    private CompaniaVuelo companiaVuelo;
    private Boolean requiereEscolta;
    private Long totalTickets;
    private PuenteEmbarque puenteEmbarque;
    private String origen;
    private String destino;
    
    public FormularioPendiente(LocalDateTime fechaHoraVuelo, CompaniaVuelo companiaVuelo, Boolean requiereEscolta, Long totalTickets, PuenteEmbarque puenteEmbarque, String origen, String destino) {
        this.fechaHoraVuelo = fechaHoraVuelo;
        this.companiaVuelo = companiaVuelo;
        this.requiereEscolta = requiereEscolta;
        this.totalTickets = totalTickets;
        this.puenteEmbarque = puenteEmbarque;
        this.origen = origen;
        this.destino = destino;
    }

    public FormularioPendiente(Long idFormulario, LocalDateTime fechaHoraVuelo, CompaniaVuelo companiaVuelo,
            Boolean requiereEscolta, PuenteEmbarque puenteEmbarque, String origen, String destino) {
        this.idFormulario = idFormulario;
        this.fechaHoraVuelo = fechaHoraVuelo;
        this.companiaVuelo = companiaVuelo;
        this.requiereEscolta = requiereEscolta;
        this.puenteEmbarque = puenteEmbarque;
        this.origen = origen;
        this.destino = destino;
    }
}
