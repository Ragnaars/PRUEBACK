package org.dgac.cl.model.dto;

import java.time.LocalDateTime;
import org.dgac.cl.model.entity.UnidadAeroportuaria;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PuenteEmbarqueDTO {
    private Integer id;
    private String nombre;
    private UnidadAeroportuaria unidadAeroportuaria;
    private LocalDateTime fechaCreacion;
    private String creadoPor;
    private Boolean habilitado;
}
