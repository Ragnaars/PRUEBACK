package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.ObjetoRetenido;
import org.dgac.cl.model.service.ObjetoRetenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody ObjetoRetenido objetoRetenido){
		ObjetoRetenido nuevoObjeto = service.save(objetoRetenido);
		return ResponseEntity.ok(nuevoObjeto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		ObjetoRetenido objetoExistente = service.findById(id);
		if(objetoExistente != null) {
			service.delete(objetoExistente);
			return ResponseEntity.ok("Objeto eliminado correctamente");
		}else {
			return ResponseEntity.ok("Objeto no encontrado");
		}
	}

}
