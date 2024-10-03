package org.dgac.cl.siscred.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sca_usuario")
public class UsuarioSiscred {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "usro_id")
    private Integer id;

    @Column(name = "usro_nombre")
    private String nombre;

    @Column(name = "usro_apaterno")
    private String apellidoPaterno;

    @Column(name = "usro_amaterno")
    private String apellidoMaterno;


}
