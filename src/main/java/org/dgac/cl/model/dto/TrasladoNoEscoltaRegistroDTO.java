package org.dgac.cl.model.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrasladoNoEscoltaRegistroDTO {
    private List<Long> formularios;
    private String usroCompTica;
    private Boolean usroCompTicaProvisorio;
    private String usroCompEvidencia;
    private String usroCompNombre;

    private String avsecTica;
    private Boolean avsecTicaProvisorio;
    private String avsecEvidencia;
    private String avsecNombre;
    
    private LocalDateTime fechaHora;
    private LocalTime horaVuelo;
}
