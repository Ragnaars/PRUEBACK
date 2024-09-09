package org.dgac.cl.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "trsd_tica_cot")
    private String ticaCot;

    @Column(name = "trsd_tica_zz")
    private String ticaZz;

    @Column(name = "trsd_tica_guardia")
    private String ticaGuardia;

    @Column(name = "trsd_evidencia")
    private String evidencia;

    @Column(name = "trsd_fecha_hora_entrega")
    private LocalDateTime fechaHoraEntrega;

    @Column(name = "trsd_habilitado")
    private Boolean habilitado;

    @Column(name = "trsd_fecha_creacion")
    private LocalDateTime fechaCreacion;
}
