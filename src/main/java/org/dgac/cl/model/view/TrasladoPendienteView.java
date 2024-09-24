package org.dgac.cl.model.view;

import org.dgac.cl.model.entity.EstadoFormulario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrasladoPendienteView {
    private Integer id;
    private EstadoFormulario estadoTraslado;
    
}
