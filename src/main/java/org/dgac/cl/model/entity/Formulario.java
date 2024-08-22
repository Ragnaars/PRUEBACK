package org.dgac.cl.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_formulario")
@Data
public class Formulario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="frml_id")
    private Long id;


    //Preguntar a andres el pq una sola hora de registro
    @Column(name="frml_fecha_hora_registro")
    private LocalDateTime fechaHoraRegistro;


    //Preguntar a andres por que el asiento es string, siendo que podría traer letras
    @Column(name="frml_asiento_pax")
    private Integer asientoPax;

    @Column(name="frml_compania_nombre")
    private String companiaNombre;

    @Column(name="frml_origen")
    private String origen;

    @Column(name="frml_destino")
    private String destino;

    @Column(name="frml_vuelo")
    private String vuelo;

    //Preguntar a andres el porque el tipo de dato es entero siendo que podria traer letras
    //foranea
    @Column(name="frml_puente_embarque")
    private Integer puenteEmbarque;

    @Column(name="frml_particular")
    private String particular;

    @Column(name="frml_pax_nombre")
    private String paxNombre;

    @Column(name="frml_tiket")
    private String tiket;

    //foranea
    @Column(name="frml_user_avsec")
    private Integer userAvsec;

    @Column(name="frml_pax_numero_telefono")
    private String paxNumeroTelefono;

    //foranea
    @Column(name="frml_estado")
    private Integer estado; 

    @Column(name="frml_pax_rut")
    private String paxRut;

    @Column(name="frml_pax_pasaporte")
    private String paxPasaporte;

    @Column(name="frml_pax_email")
    private String paxEmail;

    @Column(name="frml_escala_vuelo")
    private String escalaVuelo;

    @Column(name="frml_escala_compania")
    private String escalaCompania;

    @Column(name="frml_escala_origen")
    private String escalaOrigen;
    
    //Preguntar a andres por el (4) que se ve en el nombre de la tabla en dbeaver
    @Column(name="frml_escala_destino")
    private String escalaDestino;

    @Column(name="frml_escala_fecha")
    private LocalDateTime escalaFecha;

    //foranea
    @Column(name="frml_user_avsec_ingresa")
    private Integer userAvsecIngresa;

    @Column(name="frml_user_avsec_ingresa_firma")
    private String userAvsecIngresaFirma;

    //foranea
    @Column(name="frml_user_avsec_retira")
    private Integer userAvsecRetira;

    @Column(name="frml_user_avsec_retira_firma")
    private String userAvsecRetiraFirma;

    //foranea
    @Column(name="frml_unidad_aeroportuaria")
    private Integer unidadAeroportuaria;






    




}
