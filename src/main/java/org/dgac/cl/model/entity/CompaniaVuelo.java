package org.dgac.cl.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_compania_vuelo")
@IdClass(CompaniaVueloId.class)
public class CompaniaVuelo {

    @Id
    @Column(name = "cpvl_compania_aerea")
    private Integer companiaAerea;

    @Id
    @Column(name = "cpvl_numero_vuelo")
    private Integer numeroVuelo;

    @ManyToOne
    @JoinColumn(name = "cpvl_compania_aerea")
    private CompaniaAerea companiaAereaData;
}
