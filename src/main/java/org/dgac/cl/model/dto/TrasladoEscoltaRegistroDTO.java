package org.dgac.cl.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrasladoEscoltaRegistroDTO {
    private List<Long> formularios;
    private String avsecTica;
    private Boolean avsecTicaProvisorio;
    private String avsecEvidencia;
    private String avsecTurno;
    private String horaInicioEscolta;
    private Integer puenteEmbarque;
    private LocalDateTime fechaHora;
}
