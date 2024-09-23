package org.dgac.cl.negocio;

import java.util.List;

import org.dgac.cl.constantes.ConstantesEstadoTraslado;
import org.dgac.cl.model.dto.TrasladoEscoltaRegistroDTO;
import org.dgac.cl.model.dto.TrasladoNoEscoltaRegistroDTO;
import org.dgac.cl.model.entity.EstadoFormulario;
import org.dgac.cl.model.entity.PuenteEmbarque;
import org.dgac.cl.model.entity.Traslado;
import org.dgac.cl.model.service.FormularioService;
import org.dgac.cl.model.service.TrasladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrasladoNegocio {

    @Autowired
    TrasladoService trasladoService;
    @Autowired
    FormularioService formularioService;

    /**
     * 
     * @param trasladoRegistro
     * @return Traslado
     * @throws Exception
     */
    public Traslado registroTrasladoNoEscolta(TrasladoNoEscoltaRegistroDTO trasladoRegistro) throws Exception {

        List<Formulario> formularios = formularioService.findAllById(trasladoRegistro.getFormularios());

        if(formularios.isEmpty()) {
            throw new Exception("No se encontraron formularios asociados al traslado");
        }

        // registrar traslado
        Traslado traslado = Traslado.builder()
                .usroCompNombre(trasladoRegistro.getUsroCompNombre())
                .usroCompTica(trasladoRegistro.getUsroCompTica())
                .usroCompTicaProvisorio(trasladoRegistro.getUsroCompTicaProvisorio())
                .usroCompEvidencia(trasladoRegistro.getUsroCompEvidencia())
                //.fechaHora(trasladoRegistro.getFechaHora())
                .requiereEscolta(false)
                .estadoTraslado(EstadoFormulario.builder().id(ConstantesEstadoTraslado.ENTREGADO).build())
                .build();

        final Traslado trasladoFinal = trasladoService.save(traslado);

        // asociar formularios
        formularios.forEach(f -> {
            f.setTraslado(Traslado.builder().id(trasladoFinal.getId()).build());
            f.setRequiereEscolta(trasladoFinal.getRequiereEscolta());
            f.setFechaHoraVuelo(f.getFechaHoraVuelo().with(trasladoRegistro.getHoraVuelo()));
            f.setUsuarioCompaniaFirma(trasladoFinal.getUsroCompEvidencia());
            f.setUsuarioCompaniaNombre(trasladoFinal.getUsroCompNombre());
            f.setUsuarioCompaniaTica(trasladoFinal.getUsroCompTica());

            formularioService.save(f);
        });

        // notificar

        // retornar objeto
        return trasladoFinal;

    }

    public Traslado registroTrasladoEscolta(TrasladoEscoltaRegistroDTO trasladoRegistro) throws Exception {

        List<Formulario> formularios = formularioService.findAllById(trasladoRegistro.getFormularios());

        // valdiar formularios
        if(formularios.isEmpty()) {
            throw new Exception("No se encontraron formularios asociados al traslado");
        }

        // registrar traslado
        Traslado traslado = Traslado.builder()
                .avsecNombre(trasladoRegistro.getAvsecNombre())
                .avsecTica(trasladoRegistro.getAvsecTica())
                .avsecTicaProvisorio(trasladoRegistro.getAvsecTicaProvisorio())
                .avsecTurno(trasladoRegistro.getAvsecTurno())
                .horaInicioEscolta(trasladoRegistro.getHoraInicioEscolta())
                .puenteEmbarque(PuenteEmbarque.builder().id(trasladoRegistro.getPuenteEmbarque()).build())
                //.fechaHora(trasladoRegistro.getFechaHora())
                .requiereEscolta(true)
                .estadoTraslado(EstadoFormulario.builder().id(ConstantesEstadoTraslado.EN_TRASLADO).build())
                .build();

        final Traslado trasladoFinal = trasladoService.save(traslado);

        // asociar formularios
        formularioService.findAllById(trasladoRegistro.getFormularios()).forEach(f -> {
            f.setTraslado(Traslado.builder().id(trasladoFinal.getId()).build());
            f.setRequiereEscolta(trasladoFinal.getRequiereEscolta());
            f.setFechaHoraVuelo(f.getFechaHoraVuelo().with(trasladoRegistro.getHoraVuelo()));
            formularioService.save(f);
        });

        // notificar

        // retornar objeto
        return trasladoFinal;
    }
}
