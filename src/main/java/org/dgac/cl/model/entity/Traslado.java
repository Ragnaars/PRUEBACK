package org.dgac.cl.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_traslado")
public class Traslado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trsd_id")
    private Integer id;

    @Column(name = "trsd_avsec_tica")
    private String avsecTica;

    @Column(name = "trsd_avsec_tica_provisorio")
    private Boolean avsecTicaProvisorio;

    @Column(name = "trsd_avsec_evidencia")
    private String avsecEvidencia;

    @Column(name = "trsd_avsec_turno")
    private String avsecTurno;

    @Column(name = "trsd_avsec_nombre")
    private String avsecNombre;

    @Column(name = "trsd_usro_comp_tica")
    private String usroCompTica;

    @Column(name = "trsd_usro_comp_tica_provisorio")
    private Boolean usroCompTicaProvisorio;

    @Column(name = "trsd_usro_comp_evidencia")
    private String usroCompEvidencia;

    @Column(name = "trsd_usro_comp_nombre")
    private String usroCompNombre;

    @ManyToOne
    @JoinColumn(name = "trsd_puente_embarque")
    private PuenteEmbarque puenteEmbarque;

    @Column(name = "trsd_hora_inicio_escolta")
    private LocalTime horaInicioEscolta;

    @Column(name = "trsd_hora_fin_escolta")
    private LocalTime horaFinEscolta;

    @Column(name = "trsd_hora_llegada_puente_embarque")
    private LocalTime horaLlegadaPuenteEmbarque;
    
    @Column(name = "trsd_matricula_aeronave")
    private String matriculaAeronave;

    @Column(name = "trsd_zz_receptor_tica")
    private String receptorZZTica;

    @Column(name = "trsd_zz_receptor_tica_provisorio")
    private Boolean receptorZZTicaProvisorio;

    @Column(name = "trsd_zz_receptor_evidencia")
    private String receptorZZEvidencia;

    @Column(name = "trsd_zz_receptor_nombre")
    private String receptorZZNombre;

    @Column(name = "trsd_cot_tica")
    private String cotTica;

    @Column(name = "trsd_cot_tica_provisorio")
    private Boolean cotTicaProvisorio;

    @Column(name = "trsd_cot_evidencia")
    private String cotEvidencia;

    @Column(name = "trsd_cot_nombre")
    private String cotNombre;

    @Column(name = "trsd_bodega_tica")
    private String bodegaTica;

    @Column(name = "trsd_bodega_tica_provisorio")
    private Boolean bodegaTicaProvisorio;

    @Column(name = "trsd_bodega_evidencia")
    private String bodegaEvidencia;

    @Column(name = "trsd_bodega_nombre")
    private String bodegaNombre;

    @Column(name = "trsd_observacion")
    private String observacion;

    @Column(name = "trsd_requiere_escolta")
    private Boolean requiereEscolta;

    @Column(name = "trsd_fecha_hora", insertable = false, updatable = false)
    private LocalDateTime fechaHora;

    @Column(name = "trsd_fecha_hora_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaHoraCreacion;

    @Column(name = "trsd_habilitado")
    private Boolean habilitado;

    @ManyToOne
    @JoinColumn(name = "trsd_estado")
    private EstadoFormulario estadoTraslado;

    @OneToMany(mappedBy = "traslado")
    @JsonIgnoreProperties({"traslado"})
    private List<Formulario> formularios;
}
