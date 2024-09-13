package org.dgac.cl.model.dto;

import java.time.LocalDate;

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
}
