package org.dgac.cl.controller;

import org.dgac.cl.siscred.model.service.SolicitudSiscredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/solicitud-siscred")
public class SolicitudSiscredController {

    @Autowired
    private SolicitudSiscredService service;

    @GetMapping("/")
    public ResponseEntity<?> getSolicitud() {
        return ResponseEntity.ok(service.findAll());
    }
    

}
