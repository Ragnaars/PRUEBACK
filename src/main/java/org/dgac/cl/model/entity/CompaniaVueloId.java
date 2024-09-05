package org.dgac.cl.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompaniaVueloId {
    private Integer companiaAerea;
    private Integer numeroVuelo;
}
