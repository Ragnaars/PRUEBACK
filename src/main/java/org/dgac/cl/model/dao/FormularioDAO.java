package org.dgac.cl.model.dao;

import java.util.List;
import java.util.Set;

import org.dgac.cl.model.entity.CompaniaVueloId;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendiente;
import org.dgac.cl.model.view.FormularioPendienteDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface FormularioDAO extends JpaRepository<Formulario, Long>, JpaSpecificationExecutor<Formulario> {
    
    // formularios pendientes
    @Query("SELECT new org.dgac.cl.model.view.FormularioPendiente(f.fechaHoraVuelo, f.companiaVuelo, f.requiereEscolta, COUNT(f) OVER (PARTITION BY f.companiaVuelo)) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = ?1")
    public Set<FormularioPendiente> getCountFormularioPendienteByCompaniaVuelo(Boolean escolta);

    @Query("SELECT new org.dgac.cl.model.view.FormularioPendiente(f.id, f.fechaHoraVuelo, f.companiaVuelo, f.requiereEscolta) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = ?1")
    public Set<FormularioPendiente> getFormularioPendienteByCompaniaVuelo(Boolean escolta);

    // formularios asignados a traslado
}
