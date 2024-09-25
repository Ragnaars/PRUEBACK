package org.dgac.cl.model.view;

import java.time.LocalDateTime;
import org.dgac.cl.model.entity.CompaniaVuelo;

import lombok.Data;

@Data
public class FormularioPendienteView {
    private Long idFormulario;
    private LocalDateTime fechaHoraVuelo;
    private CompaniaVuelo companiaVuelo;
    private Boolean requiereEscolta;
    private Long totalTickets;
    private PuenteEmbarqueView puenteEmbarque;
    private String origen;
    private String destino;
    private TrasladoPendienteView traslado;
    
    public FormularioPendienteView(LocalDateTime fechaHoraVuelo, CompaniaVuelo companiaVuelo, Boolean requiereEscolta, Long totalTickets, PuenteEmbarqueView puenteEmbarque, String origen, String destino, TrasladoPendienteView traslado) {
        this.fechaHoraVuelo = fechaHoraVuelo;
        this.companiaVuelo = companiaVuelo;
        this.requiereEscolta = requiereEscolta;
        this.totalTickets = totalTickets;
        this.puenteEmbarque = puenteEmbarque;
        this.origen = origen;
        this.destino = destino;
        this.traslado = traslado;
    }

    public FormularioPendienteView(Long idFormulario, LocalDateTime fechaHoraVuelo, CompaniaVuelo companiaVuelo,
            Boolean requiereEscolta, PuenteEmbarqueView puenteEmbarque, String origen, String destino, TrasladoPendienteView traslado) {
        this.idFormulario = idFormulario;
        this.fechaHoraVuelo = fechaHoraVuelo;
        this.companiaVuelo = companiaVuelo;
        this.requiereEscolta = requiereEscolta;
        this.puenteEmbarque = puenteEmbarque;
        this.origen = origen;
        this.destino = destino;
        this.traslado = traslado;
    }
}
