package org.dgac.cl.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_objeto_retenido_tipo")
public class ObjetoRetenidoTipo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="obrt_id")
    private Integer id;

    @Column(name="obrt_nombre")
    private String nombre;

    @Column(name="obrt_datos_adicionales")
    private String datosAdicionales;

    @Column(name="obrt_fecha_creacion", insertable = false, updatable = false)
    private String fechaCreacion;

    @Column(name="obrt_habilitado")
    private Boolean habilitado;


}
