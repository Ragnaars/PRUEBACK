package org.dgac.cl.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_parametro")
@Data
public class Parametro {

    @Id
    @Column(name="prmt_id")
    private String id;

    @Column(name="prmt_valor")
    private String valor;

}
