package org.dgac.cl.model.entity;

import java.io.Serializable;

import org.hibernate.annotations.Collate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "tbl_objeto_retenido")
public class ObjetoRetenido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "objr_id")
	private Long id; 
	
	@Column(name = "objr_nombre")
	private String nombre;
}
