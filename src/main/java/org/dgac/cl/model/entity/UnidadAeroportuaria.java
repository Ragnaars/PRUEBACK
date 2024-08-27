package org.dgac.cl.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_unidad_aeroportuaria")
public class UnidadAeroportuaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="unar_id")
    private Integer id;

    @Column(name="unar_oaci")
    private String oaci;

    @Column(name="unar_nombre")
    private String nombre;

    @Column(name="unar_fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name="unar_creado_por", insertable=false, updatable=false)
    private String creadoPor;

    @Column(name="unar_habilitado")
    private Boolean habilitado;
    
    @Column(name="unar_iata")
    private String iata;


}
