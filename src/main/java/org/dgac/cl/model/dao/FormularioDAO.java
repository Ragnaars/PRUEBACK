package org.dgac.cl.model.dao;

import java.util.List;
import java.util.Set;

import org.dgac.cl.model.entity.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface FormularioDAO extends JpaRepository<Formulario, Long>, JpaSpecificationExecutor<Formulario> {
    
    @Query("SELECT new org.dgac.cl.model.view.FormularioPendiente(f.fechaHoraVuelo, f.companiaVuelo, f.requiereEscolta, COUNT(f) OVER (PARTITION BY f.companiaVuelo)) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = false")
    public Set<Object[]> getFormularioPendienteNoEscoltaByCompaniaVuelo();

    @Query("SELECT new org.dgac.cl.model.view.FormularioPendiente(f.fechaHoraVuelo, f.companiaVuelo, f.requiereEscolta, COUNT(f) OVER (PARTITION BY f.companiaVuelo)) FROM Formulario f WHERE f.traslado is null AND f.requiereEscolta = false")
    public Set<Object[]> getFormularioPendienteEscoltaByCompaniaVuelo();
}
