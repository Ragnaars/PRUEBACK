package org.dgac.cl.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_estado_formulario")
public class EstadoFormulario {

    @Id
    @Column(name="esfr_id")
    private Integer id;

    @Column(name="esfr_nombre")
    private String nombre;

    @Column(name="esfr_habilitado")
    private Boolean habilitado;

    @Column(name="esfr_fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

}
