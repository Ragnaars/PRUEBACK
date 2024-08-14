package org.dgac.cl.model.controller;

import org.dgac.cl.model.service.ObjetoRetenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetoRetenido")
public class ObjetoRetenidoController {
	
	@Autowired ObjetoRetenidoService service;
	
	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
}
