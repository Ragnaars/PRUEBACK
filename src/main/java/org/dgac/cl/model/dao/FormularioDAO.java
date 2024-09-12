package org.dgac.cl.model.dao;

import java.util.Set;

import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormularioDAO extends JpaRepository<Formulario, Long>, JpaSpecificationExecutor<Formulario> {

    // formularios pendientes agrupados
    @Query("SELECT new org.dgac.cl.model.view.FormularioPendiente(" 
    + "f.fechaHoraVuelo, "
    + "f.companiaVuelo, "
    + "f.requiereEscolta, "
    + "COUNT(f) OVER (PARTITION BY f.companiaVuelo), "
    + "f.puenteEmbarque, "
    + "f.origen, "
    + "f.destino) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = :escolta")
    public Set<FormularioPendiente> getCountFormularioPendienteByCompaniaVuelo(@Param("escolta") Boolean escolta);

    // formularios pendientes no agrupados con detalle de formulario
    @Query("SELECT new org.dgac.cl.model.view.FormularioPendiente("
    + "f.id, "
    + "f.fechaHoraVuelo, "
    + "f.companiaVuelo, "
    + "f.requiereEscolta, "
    + "f.puenteEmbarque, "
    + "f.origen, " 
    + "f.destino) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = :escolta and f.companiaVuelo = :companiaVuelo")
    public Set<FormularioPendiente> getFormularioPendienteByCompaniaVuelo(@Param("escolta") Boolean escolta, @Param("companiaVuelo") CompaniaVuelo companiaVuelo);

    // formularios asignados a traslado
}
