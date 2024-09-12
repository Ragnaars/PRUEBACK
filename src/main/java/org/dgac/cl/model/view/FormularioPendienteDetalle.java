package org.dgac.cl.model.view;

import java.time.LocalDateTime;

import org.dgac.cl.model.entity.CompaniaVuelo;

import lombok.Data;

@Data
public class FormularioPendienteDetalle {
    private Long idFormulario;
    private LocalDateTime fechaHoraVuelo;
    private CompaniaVuelo companiaVuelo;
    private Boolean requiereEscolta;
    private Long totalTickets;
    
    public FormularioPendienteDetalle(Long idFormulario, LocalDateTime fechaHoraVuelo, CompaniaVuelo companiaVuelo,
            Boolean requiereEscolta) {
        this.idFormulario = idFormulario;
        this.fechaHoraVuelo = fechaHoraVuelo;
        this.companiaVuelo = companiaVuelo;
        this.requiereEscolta = requiereEscolta;
    }

    
}
