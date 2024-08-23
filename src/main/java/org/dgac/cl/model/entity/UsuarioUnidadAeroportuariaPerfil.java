package org.dgac.cl.model.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_usuario_unidad_aeroportuaria_perfil")
@IdClass(UsuarioUnidadAeroportuariaPerfilId.class)
public class UsuarioUnidadAeroportuariaPerfil {

    @Id
    @Column(name = "usro_id")
    private Integer usuario;

    @Id
    @Column(name = "unar_id")
    private Integer unidadAeroportuaria;
    
    @Id
    @Column(name = "prfl_id")
    private Integer perfil;

    @ManyToOne
    @JoinColumn(name = "unar_id")
    private UnidadAeroportuaria unidadAeroportuariaData;

    @ManyToOne
    @JoinColumn(name = "prfl_id")
    private Perfil perfilData;
}
