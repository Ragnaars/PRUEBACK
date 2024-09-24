package org.dgac.cl.model.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendienteView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormularioDAO extends JpaRepository<Formulario, Long>, JpaSpecificationExecutor<Formulario> {
    
    /*
     * + "AND (:fechaDesde IS NULL OR CAST(f.fechaHoraVuelo AS java.time.LocalDate) >= :fechaDesde)"
    + "AND (:fechaHasta IS NULL OR CAST(f.fechaHoraVuelo AS java.time.LocalDate) <= :fechaHasta)")
     */
    // formularios pendientes agrupados
    @Query("SELECT new org.dgac.cl.model.view.FormularioPendienteView(" 
    + "f.fechaHoraVuelo, "
    + "f.companiaVuelo, "
    + "f.requiereEscolta, "
    + "COUNT(f) OVER (PARTITION BY f.companiaVuelo), "
    + "new org.dgac.cl.model.view.PuenteEmbarqueView(f.puenteEmbarque.id, f.puenteEmbarque.nombre), "
    + "f.origen, "
    + "f.destino, "
    + "new org.dgac.cl.model.view.TrasladoPendienteView(f.traslado.id, f.traslado.estadoTraslado)) FROM Formulario f WHERE " 
    + "f.traslado is null " 
    + "AND f.requiereEscolta = :escolta "
    + "AND (:companiaAerea IS NULL OR f.companiaVuelo.companiaAerea = :companiaAerea)"
    + "AND (:numeroVuelo IS NULL OR f.companiaVuelo.numeroVuelo = :numeroVuelo)"
    + "AND (:puenteEmbarque IS NULL OR f.puenteEmbarque = :puenteEmbarque)")
    public Set<FormularioPendienteView> getCountFormularioPendienteByCompaniaVuelo(
        @Param("escolta") Boolean escolta,
        @Param("companiaAerea") Integer companiaAerea,
        @Param("numeroVuelo") Integer numeroVuelo,
        @Param("puenteEmbarque") Integer puenteEmbarque);

    // formularios pendientes no agrupados con detalle de formulario
    @Query("SELECT new org.dgac.cl.model.view.FormularioPendienteView("
    + "f.id, "
    + "f.fechaHoraVuelo, "
    + "f.companiaVuelo, "
    + "f.requiereEscolta, "
    + "new org.dgac.cl.model.view.PuenteEmbarqueView(f.puenteEmbarque.id, f.puenteEmbarque.nombre), "
    + "f.origen, " 
    + "f.destino) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = :escolta and f.companiaVuelo = :companiaVuelo")
    public Set<FormularioPendienteView> getFormularioPendienteByCompaniaVuelo(@Param("escolta") Boolean escolta, @Param("companiaVuelo") CompaniaVuelo companiaVuelo);

    // formularios asignados a traslado

    @Query("SELECT new org.dgac.cl.model.view.FormularioPendienteView(" 
    + "f.fechaHoraVuelo, "
    + "f.companiaVuelo, "
    + "f.requiereEscolta, "
    + "COUNT(f) OVER (PARTITION BY f.companiaVuelo, f.fechaHoraVuelo, f.traslado), "
    + "new org.dgac.cl.model.view.PuenteEmbarqueView(f.puenteEmbarque.id, f.puenteEmbarque.nombre), "
    + "f.origen, "
    + "f.destino, "
    + "new org.dgac.cl.model.view.TrasladoPendienteView(f.traslado.id, f.traslado.estadoTraslado)) FROM Formulario f WHERE " 
    + "(:companiaAerea IS NULL OR f.companiaVuelo.companiaAerea = :companiaAerea)"
    + "AND (:numeroVuelo IS NULL OR f.companiaVuelo.numeroVuelo = :numeroVuelo)"
    + "AND (:puenteEmbarque IS NULL OR f.puenteEmbarque = :puenteEmbarque)")
    public Set<FormularioPendienteView> getCountFormularioTrasladoByCompaniaVuelo(
        @Param("companiaAerea") Integer companiaAerea,
        @Param("numeroVuelo") Integer numeroVuelo,
        @Param("puenteEmbarque") Integer puenteEmbarque);
}
