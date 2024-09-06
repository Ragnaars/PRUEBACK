package org.dgac.cl.model.dto;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UnidadAeroportuariaDTO {
    private Integer id;
    private String oaci;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private String creadoPor;
    private Boolean habilitado;
    private String iata;
}
