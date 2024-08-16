package org.dgac.cl.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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

	@Column(name = "objr_marca")
	private String marcaString;

	@Column(name="objr_modelo")
	private String modelo;

	@Column(name="objr_serie")
	private String serie;

	@Column(name="objr_cantidad")
	private Integer cantidad;

	@Column(name="objr_observacion")
	private String observacion;

	@Column(name="objr_fecha_ceracion")
	private LocalDateTime fechaCreacion;

	@Column(name="objr_encargado")
	private Integer encargado;

	@Column(name="objr_habilitado")
	private Boolean habilitado;

	@Column(name="objr_formulario") 
	private Integer formulario;


}
