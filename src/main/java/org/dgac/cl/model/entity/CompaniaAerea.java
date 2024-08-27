package org.dgac.cl.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_compania_aerea")
@Data
public class CompaniaAerea {

    @Id
    @Column(name="cpar_id")
    private Integer id;

    @Column(name="cpar_nombre")
    private String nombre;

    @Column(name="cpar_fecha_creacion", insertable=false, updatable=false)
    private LocalDateTime fechaCreacion;

    @Column(name="cpar_habilitado")
    private Boolean habilitado;

}
