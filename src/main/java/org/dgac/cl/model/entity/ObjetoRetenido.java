package org.dgac.cl.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private String marca;

	@Column(name="objr_modelo")
	private String modelo;

	@Column(name="objr_serie")
	private String serie;

	@Column(name="objr_cantidad")
	private Integer cantidad;

	@Column(name="objr_observacion")
	private String observacion;

	@Column(name="objr_fecha_creacion", insertable = false, updatable = false)
	private LocalDateTime fechaCreacion;

	@Column(name="objr_encargado")
	private Integer encargado;

	@Column(name="objr_habilitado")
	private Boolean habilitado;

	@Column(name="objr_formulario") 
	private Integer formulario;

	@Column(name="objr_datos_adicionales")
	private String datosAdicionales;

	@ManyToOne
	@JoinColumn(name = "objr_tipo")
	private ObjetoRetenidoTipo tipo;


}
