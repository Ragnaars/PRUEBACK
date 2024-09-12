package org.dgac.cl.model.view;

import java.time.LocalDateTime;

import org.dgac.cl.model.entity.CompaniaVuelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormularioPendiente {
    private LocalDateTime fechaHoraVuelo;
    private CompaniaVuelo companiaVuelo;
    private Boolean requiereEscolta;
    private Long totalTickets;
    
    public FormularioPendiente(CompaniaVuelo companiaVuelo, Boolean requiereEscolta, Long totalTickets) {
        this.companiaVuelo = companiaVuelo;
        this.requiereEscolta = requiereEscolta;
        this.totalTickets = totalTickets;
    }

    
}
