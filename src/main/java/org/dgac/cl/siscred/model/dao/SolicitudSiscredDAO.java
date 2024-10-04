package org.dgac.cl.siscred.model.dao;

import java.util.List;

import org.dgac.cl.siscred.model.entity.SolicitudSiscred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolicitudSiscredDAO extends JpaRepository<SolicitudSiscred, Integer>  {
    @Query("select s from SolicitudSiscred s where s.fechaVencimiento > CURRENT_DATE and s.estado = 18 and s.ntica = :id")
    public List<SolicitudSiscred> findByNtica(Integer id);

    @Query("select s from SolicitudSiscred s where s.fechaVencimiento > CURRENT_DATE and s.estado = 18")
    public List<SolicitudSiscred> findByEstado();
}
