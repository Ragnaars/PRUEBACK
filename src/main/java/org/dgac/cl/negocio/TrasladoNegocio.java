package org.dgac.cl.negocio;

import org.dgac.cl.model.dto.TrasladoNoEscoltaRegistroDTO;
import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.entity.Traslado;
import org.dgac.cl.model.service.FormularioService;
import org.dgac.cl.model.service.TrasladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrasladoNegocio {

    @Autowired TrasladoService trasladoService;
    @Autowired FormularioService formularioService;

    /**
     * 
     * @param trasladoRegistro
     * @return Traslado
     * @throws Exception
     */
    public Traslado registroTrasladoNoEscolta(TrasladoNoEscoltaRegistroDTO trasladoRegistro) throws Exception {

        // registrar traslado
        Traslado traslado = Traslado.builder()
            .usroCompTica(trasladoRegistro.getUsroCompTica())
            .usroCompTicaProvisorio(trasladoRegistro.getUsroCompTicaProvisorio())
            .usroCompEvidencia(trasladoRegistro.getUsroCompEvidencia())
            .fechaHora(trasladoRegistro.getFechaHora())
            .requiereEscolta(false)
            .build();

        final Traslado trasladoFinal = trasladoService.save(traslado);

        // asociar formularios
        formularioService.findAllById(trasladoRegistro.getFormularios()).forEach(f -> {
            f.setTraslado(Traslado.builder().id(trasladoFinal.getId()).build());
            f.setRequiereEscolta(trasladoFinal.getRequiereEscolta());
        });

        // notificar

        // retornar objeto
        return trasladoFinal;
    }

    public Formulario registroTrasladoEscolta(Formulario formulario) throws Exception {
        return null;
    }
}
