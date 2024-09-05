package org.dgac.cl.controller;

import org.dgac.cl.negocio.CompaniaVueloNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companiaVuelo")
public class CompaniaVueloController {

    @Autowired CompaniaVueloNegocio negocio;

    @GetMapping("/vuelos/{id}")
    public ResponseEntity<?> findByCompaniaVuelo(@PathVariable Integer id) {
        return ResponseEntity.ok(negocio.findByCompaniaAerea(id));
    }
}
