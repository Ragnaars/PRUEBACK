package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.ObjetoRetenido;
import org.dgac.cl.negocio.ObjetoRetenidoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@Autowired ObjetoRetenidoNegocio negocio;
	
	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(negocio.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.ok(negocio.findById(id));
	}

	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody ObjetoRetenido objetoRetenido){
		ObjetoRetenido nuevoObjeto = negocio.save(objetoRetenido);
		return ResponseEntity.ok(nuevoObjeto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try{
			String result = negocio.deleteById(id);
			return ResponseEntity.ok(result);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}

}
