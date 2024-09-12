package org.dgac.cl.model.dao;

import java.util.Set;

import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.view.FormularioPendiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface FormularioDAO extends JpaRepository<Formulario, Long>, JpaSpecificationExecutor<Formulario> {
    
    // formularios pendientes agrupados
    @Query("SELECT new org.dgac.cl.model.view.FormularioPendiente(f.fechaHoraVuelo, f.companiaVuelo, f.requiereEscolta, COUNT(f) OVER (PARTITION BY f.companiaVuelo)) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = ?1")
    public Set<FormularioPendiente> getCountFormularioPendienteByCompaniaVuelo(Boolean escolta);

    // formularios pendientes no agrupados con detalle de formulario
    @Query("SELECT new org.dgac.cl.model.view.FormularioPendiente(f.id, f.fechaHoraVuelo, f.companiaVuelo, f.requiereEscolta) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = ?1 and f.companiaVuelo = ?2")
    public Set<FormularioPendiente> getFormularioPendienteByCompaniaVuelo(Boolean escolta, CompaniaVuelo companiaVuelo);

    // formularios asignados a traslado
}
