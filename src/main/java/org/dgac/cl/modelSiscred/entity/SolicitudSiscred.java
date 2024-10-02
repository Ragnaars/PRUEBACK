package org.dgac.cl.modelSiscred.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Column(name = "sltd_id")
    private Integer id;

    @Column(name = "sltd_fingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "sltd_ntica")
    private Integer nroTica;
    
}
