package org.dgac.cl.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_perfil")
public class Perfil {

    @Id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="prfl_id")
    private Integer id;

    @Column(name="prfl_nombre")
    private String nombre;



}
