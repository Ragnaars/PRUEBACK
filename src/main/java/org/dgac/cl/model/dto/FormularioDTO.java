package org.dgac.cl.model.dto;

import java.time.LocalDateTime;
import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.EstadoFormulario;
import org.dgac.cl.model.entity.PuenteEmbarque;
import org.dgac.cl.model.entity.Traslado;
import org.dgac.cl.model.entity.UnidadAeroportuaria;
import org.dgac.cl.model.entity.Usuario;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FormularioDTO {
    private Long id;
    private LocalDateTime fechaHoraRegistro;
    private Integer asientoPax;
    private String origen;
    private String destino;
    private PuenteEmbarqueDTO puenteEmbarque;
    private String particular;
    private String paxNombre;
    private String ticket;
    private Usuario userAvsec;
    private String paxNumeroTelefono;
    private EstadoFormulario estado; 
    private String paxRut;
    private String paxPasaporte;
    private String paxEmail;
    private String escalaVuelo;
    private String escalaCompania;
    private String escalaOrigen;
    private String escalaDestino;
    private LocalDateTime escalaFecha;
    private Usuario userAvsecIngresa;
    private String userAvsecIngresaFirma;
    private Usuario userAvsecRetira;
    private String userAvsecRetiraFirma;
    private UnidadAeroportuariaDTO unidadAeroportuaria;
    private Traslado traslado;
    private String observacion;
    private String ticaUsuarioCompania;
    private String firmaUsuarioCompania;
    private CompaniaVuelo companiaVuelo;
    private Boolean habilitado;
    private LocalDateTime fechaCreacion;
}
