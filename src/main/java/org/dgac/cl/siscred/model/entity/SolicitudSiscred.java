package org.dgac.cl.siscred.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sca_solicitud")
public class SolicitudSiscred {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sltd_id")
    private Integer id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="sltd_idusuario", referencedColumnName="usro_id")
    private UsuarioSiscred usuario;

    @Column(name = "sltd_fingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "sltd_ntica")
    private Integer nTica;
    
}
