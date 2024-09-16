package org.dgac.cl.model.entity;
import java.time.LocalDateTime;
import java.util.List;

import org.dgac.cl.model.dto.FormularioDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_formulario")
public class Formulario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="frml_id")
    private Long id;

    //Preguntar a andres el pq una sola hora de registro
    @Column(name="frml_fecha_hora_registro" , insertable = false, updatable = false)
    private LocalDateTime fechaHoraRegistro;

    @Column(name="frml_asiento_pax")
    private Integer asientoPax;

    @Column(name="frml_origen")
    private String origen;

    @Column(name="frml_destino")
    private String destino;

    //foranea
    @ManyToOne
    @JoinColumn(name="frml_puente_embarque")
    private PuenteEmbarque puenteEmbarque;

    @Column(name="frml_particular")
    private String particular;

    @Column(name="frml_pax_nombre")
    private String paxNombre;

    @Column(name="frml_ticket")
    private String ticket;

    //foranea
    @ManyToOne
    @JoinColumn(name="frml_user_avsec")
    private Usuario userAvsec;

    @Column(name="frml_pax_numero_telefono")
    private String paxNumeroTelefono;

    //foranea
    @ManyToOne
    @JoinColumn(name="frml_estado")
    private EstadoFormulario estado; 

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
    
    @Column(name="frml_escala_destino")
    private String escalaDestino;

    @Column(name="frml_escala_fecha")
    private LocalDateTime escalaFecha;

    //foranea
    @ManyToOne
    @JoinColumn(name="frml_user_avsec_ingresa")
    private Usuario userAvsecIngresa;

    @Column(name="frml_user_avsec_ingresa_firma")
    private String userAvsecIngresaFirma;

    //foranea
    @ManyToOne
    @JoinColumn(name="frml_user_avsec_retira")
    private Usuario userAvsecRetira;


    @Column(name="frml_user_avsec_retira_tica")
    private String userAvsecRetiraTica;

    @Column(name="frml_user_avsec_retira_nombre")
    private String userAvsecRetiraNombre;

    @Column(name="frml_user_avsec_retira_firma")
    private String userAvsecRetiraFirma;



    //foranea
    @ManyToOne
    @JoinColumn(name="frml_unidad_aeroportuaria")
    private UnidadAeroportuaria unidadAeroportuaria;

    @ManyToOne
    @JoinColumn(name = "frml_traslado")
    @JsonIgnoreProperties("formularios")
    private Traslado traslado;

    @Column(name = "frml_observacion")
    private String observacion;

    @Column(name = "frml_usuario_compania_tica")
    private String usuarioCompaniaTica;

    @Column(name = "frml_usuario_compania_firma")
    private String usuarioCompaniaFirma;

    @Column(name = "frml_usuario_compania_nombre")
    private String usuarioCompaniaNombre;

    @Column(name = "frml_fecha_hora_retiro")
    private LocalDateTime fechaHoraRetiro;

    @Column(name = "frml_pax_firma")
    private String paxFirma;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "frml_vuelo", referencedColumnName = "cpvl_numero_vuelo"),
        @JoinColumn(name = "frml_compania_aerea", referencedColumnName = "cpvl_compania_aerea")})
    private CompaniaVuelo companiaVuelo;

    @Column(name = "frml_habilitado")
    private Boolean habilitado;

    @Column(name = "frml_fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "frml_fecha_hora_vuelo")
    private LocalDateTime fechaHoraVuelo;

    @OneToMany(mappedBy = "formulario")
    @JsonIgnoreProperties("formulario")
    private List<ObjetoRetenido> objetosRetenidos;

    @Column(name="frml_requiere_traslado")
    private Boolean requiereEscolta;

    public Formulario(FormularioDTO formulario) {}
}
