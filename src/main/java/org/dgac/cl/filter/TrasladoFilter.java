package org.dgac.cl.filter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.dgac.cl.enums.SearchOperation;
import org.dgac.cl.model.entity.EstadoFormulario;
import org.dgac.cl.model.entity.PuenteEmbarque;
import org.dgac.cl.model.entity.Traslado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrasladoFilter implements Serializable, Filtro {

    private static final long serialVersionUID = 1L; 

    private Integer id;

    private String avsecTica;

    private Boolean avsecTicaProvisorio;

    private String avsecEvidencia;

    private String avsecTurno;

    private String avsecNombre;

    private String usroCompTica;

    private Boolean usroCompTicaProvisorio;

    private String usroCompEvidencia;

    private String usroCompNombre;

    private PuenteEmbarque puenteEmbarque;

    private LocalTime horaInicioEscolta;

    private LocalTime horaFinEscolta;

    private LocalTime horaLlegadaPuenteEmbarque;
    
    private String matriculaAeronave;

    private String receptorZZTica;

    private Boolean receptorZZTicaProvisorio;

    private String receptorZZEvidencia;

    private String receptorZZNombre;

    private String cotTica;

    private Boolean cotTicaProvisorio;

    private String cotEvidencia;

    private String cotNombre;

    private String bodegaTica;

    private Boolean bodegaTicaProvisorio;

    private String bodegaEvidencia;

    private String bodegaNombre;

    private String observacion;

    private Boolean requiereEscolta;

    private LocalDateTime fechaHora;

    private LocalDateTime fechaHoraCreacion;

    private Boolean habilitado;

    private EstadoFormulario estadoTraslado;




    @Override
    public GenericSpecification<Traslado> generarFiltro() {
        GenericSpecification<Traslado> ge = new GenericSpecification<Traslado>();
        if (id != null) {
            ge.add(new SearchCriteria("id", id, SearchOperation.EQUAL));
        }
        if (avsecTica != null && !avsecTica.isEmpty()) {
            ge.add(new SearchCriteria("avsecTica", avsecTica, SearchOperation.MATCH));
        }
        if (avsecTicaProvisorio != null) {
            ge.add(new SearchCriteria("avsecTicaProvisorio", avsecTicaProvisorio, SearchOperation.EQUAL));
        }
        if (avsecEvidencia != null && !avsecEvidencia.isEmpty()) {
            ge.add(new SearchCriteria("avsecEvidencia", avsecEvidencia, SearchOperation.MATCH));
        }
        if (avsecTurno != null && !avsecTurno.isEmpty()) {
            ge.add(new SearchCriteria("avsecTurno", avsecTurno, SearchOperation.MATCH));
        }
        if (avsecNombre != null && !avsecNombre.isEmpty()) {
            ge.add(new SearchCriteria("avsecNombre", avsecNombre, SearchOperation.MATCH));
        }
        if (usroCompTica != null && !usroCompTica.isEmpty()) {
            ge.add(new SearchCriteria("usroCompTica", usroCompTica, SearchOperation.MATCH));
        }
        if (usroCompTicaProvisorio != null) {
            ge.add(new SearchCriteria("usroCompTicaProvisorio", usroCompTicaProvisorio, SearchOperation.EQUAL));
        }
        if (usroCompEvidencia != null && !usroCompEvidencia.isEmpty()) {
            ge.add(new SearchCriteria("usroCompEvidencia", usroCompEvidencia, SearchOperation.MATCH));
        }
        if (usroCompNombre != null && !usroCompNombre.isEmpty()) {
            ge.add(new SearchCriteria("usroCompNombre", usroCompNombre, SearchOperation.MATCH));
        }
        if (puenteEmbarque != null) {
            ge.add(new SearchCriteria("puenteEmbarque", puenteEmbarque, SearchOperation.EQUAL));
        }
        if (horaInicioEscolta != null) {
            ge.add(new SearchCriteria("horaInicioEscolta", horaInicioEscolta, SearchOperation.EQUAL));
        }
        if (horaFinEscolta != null) {
            ge.add(new SearchCriteria("horaFinEscolta", horaFinEscolta, SearchOperation.EQUAL));
        }

        if (horaLlegadaPuenteEmbarque != null) {
            ge.add(new SearchCriteria("horaLlegadaPuenteEmbarque", horaLlegadaPuenteEmbarque, SearchOperation.EQUAL));
        }
        if (matriculaAeronave != null && !matriculaAeronave.isEmpty()) {
            ge.add(new SearchCriteria("matriculaAeronave", matriculaAeronave, SearchOperation.MATCH));
        }
        if (receptorZZTica != null && !receptorZZTica.isEmpty()) {
            ge.add(new SearchCriteria("receptorZZTica", receptorZZTica, SearchOperation.MATCH));
        }

        if (receptorZZTicaProvisorio != null) {
            ge.add(new SearchCriteria("receptorZZTicaProvisorio", receptorZZTicaProvisorio, SearchOperation.EQUAL));
        }
        if (receptorZZEvidencia != null && !receptorZZEvidencia.isEmpty()) {
            ge.add(new SearchCriteria("receptorZZEvidencia", receptorZZEvidencia, SearchOperation.MATCH));
        }
        if (receptorZZNombre != null && !receptorZZNombre.isEmpty()) {
            ge.add(new SearchCriteria("receptorZZNombre", receptorZZNombre, SearchOperation.MATCH));
        }
        if (cotTica != null && !cotTica.isEmpty()) {
            ge.add(new SearchCriteria("cotTica", cotTica, SearchOperation.MATCH));
        }
        if (cotTicaProvisorio != null) {
            ge.add(new SearchCriteria("cotTicaProvisorio", cotTicaProvisorio, SearchOperation.EQUAL));
        }
        if (cotEvidencia != null && !cotEvidencia.isEmpty()) {
            ge.add(new SearchCriteria("cotEvidencia", cotEvidencia, SearchOperation.MATCH));
        }
        if (cotNombre != null && !cotNombre.isEmpty()) {
            ge.add(new SearchCriteria("cotNombre", cotNombre, SearchOperation.MATCH));
        }
        if (bodegaTica != null && !bodegaTica.isEmpty()) {
            ge.add(new SearchCriteria("bodegaTica", bodegaTica, SearchOperation.MATCH));
        }
        if (bodegaTicaProvisorio != null) {
            ge.add(new SearchCriteria("bodegaTicaProvisorio", bodegaTicaProvisorio, SearchOperation.EQUAL));
        }
        if (bodegaEvidencia != null && !bodegaEvidencia.isEmpty()) {
            ge.add(new SearchCriteria("bodegaEvidencia", bodegaEvidencia, SearchOperation.MATCH));
        }
        if (bodegaNombre != null && !bodegaNombre.isEmpty()) {
            ge.add(new SearchCriteria("bodegaNombre", bodegaNombre, SearchOperation.MATCH));
        }
        if (observacion != null && !observacion.isEmpty()) {
            ge.add(new SearchCriteria("observacion", observacion, SearchOperation.MATCH));
        }
        if (requiereEscolta != null) {
            ge.add(new SearchCriteria("requiereEscolta", requiereEscolta, SearchOperation.EQUAL));
        }
        if (fechaHora != null) {
            ge.add(new SearchCriteria("fechaHora", fechaHora, SearchOperation.DATE_EQUAL));
        }
        if (fechaHoraCreacion != null) {
            ge.add(new SearchCriteria("fechaHoraCreacion", fechaHoraCreacion, SearchOperation.DATE_EQUAL));
        }
        if (habilitado != null) {
            ge.add(new SearchCriteria("habilitado", habilitado, SearchOperation.EQUAL));
        }
        if (estadoTraslado != null) {
            ge.add(new SearchCriteria("estadoTraslado", estadoTraslado, SearchOperation.EQUAL));
        }
        return ge;

    }
}
