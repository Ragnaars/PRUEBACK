package org.dgac.cl.model.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usro_id")
    private Integer id;

    @Column(name="usro_username")
    private String username;

    @Column(name="usro_nombre")
    private String nombre;

    @Column(name="usro_apellido_paterno")
    private String apellido_paterno;

    @Column(name="usro_apellido_materno")
    private String apellido_materno;

    @Column(name="usro_email")
    private String email;

    @Column(name="usro_interno")
    private Boolean interno;

    @Column(name="usro_fecha_creacion", insertable=false, updatable=false)
    private LocalDateTime fecha_creacion;

    @Column(name="usro_habilitado")
    private Boolean habilitado;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private Set<UsuarioUnidadAeroportuariaPerfil> unidadesPerfiles;

}
