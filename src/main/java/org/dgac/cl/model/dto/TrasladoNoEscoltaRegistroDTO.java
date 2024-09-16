package org.dgac.cl.model.dto;

import java.time.LocalDateTime;
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
    private LocalDateTime fechaHora;
}
