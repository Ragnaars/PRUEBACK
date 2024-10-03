package org.dgac.cl.controller;

import org.dgac.cl.siscred.model.service.SolicitudSiscredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/ntica/{id}")
    public ResponseEntity<?> findByNtica(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findByNtica(id));
    }
}
