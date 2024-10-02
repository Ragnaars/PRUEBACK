package org.dgac.cl.controller;

import org.dgac.cl.modelSiscred.service.UsuarioSiscredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario-siscred")
public class UsuarioSiscredController {

    @Autowired
    private UsuarioSiscredService service;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    
    
}
