package org.dgac.cl.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrasladoFinalizarDTO {
    private Integer id;
    private LocalDateTime fechaHora;
    private String usroCompTica;
    private Boolean usroCompTicaProvisorio;
    private String usroCompEvidencia;
    private String usroCompNombre;
    private String receptorZZTica;
    private Boolean receptorZZTicaProvisorio;
    private String receptorZZEvidencia;
    private String receptorZZNombre;
    private String cotTica;
    private Boolean cotTicaProvisorio;
    private String cotEvidencia;
    private String cotNombre;
    private String bodegaTica;
    private Boolean bodegaTicaProvisorio;
    private String bodegaEvidencia;
    private String bodegaNombre;
    private LocalTime horaLlegadaPuenteEmbarque;
    private LocalTime horaFinEscolta;
    private String matriculaAeronave;
    private String observacion;
    private List<String> evidencias;
}
