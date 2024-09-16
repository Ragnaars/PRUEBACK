package org.dgac.cl.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_puente_embarque")
public class PuenteEmbarque {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ptem_id")
    private Integer id;

    @Column(name="ptem_nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="ptem_unidad_aeroportuaria")
    private UnidadAeroportuaria unidadAeroportuaria;

    @Column(name="ptem_fecha_creacion", insertable=false, updatable=false)
    private LocalDateTime fechaCreacion;
    
    @Column(name="ptem_creado_por", insertable=false, updatable=false)
    private String creadoPor;

    @Column(name="ptem_habilitado")
    private Boolean habilitado;
    

}
