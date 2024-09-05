package org.dgac.cl.negocio;

import org.dgac.cl.model.entity.CompaniaVuelo;
import org.dgac.cl.model.service.CompaniaVueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CompaniaVueloNegocio {

    @Autowired CompaniaVueloService service;

    public List<CompaniaVuelo> findByCompaniaAerea(Integer companiaAerea) {
        return service.findByCompaniaAerea(companiaAerea);
    }
}
