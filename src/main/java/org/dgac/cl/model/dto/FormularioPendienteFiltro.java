package org.dgac.cl.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormularioPendienteFiltro {
    private Boolean escolta;
    private Integer companiaAerea;
    private Integer numeroVuelo;
    private Integer puenteEmbarque;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalDateTime fechaHoraVuelo;
    private Integer traslado;
    private String origen;
    private String destino;
}
