package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.Formulario;
import org.dgac.cl.model.service.FormularioService;
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
@RequestMapping("/formulario")
public class FormularioController {

    @Autowired
    private FormularioService service;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Formulario formulario){
        return ResponseEntity.ok(service.save(formulario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Formulario formularioExistente = service.findById(id);

        if(formularioExistente != null){
            service.deleteById(id);
            return ResponseEntity.ok("Formulario eliminado correctamente");
        }else{
            return ResponseEntity.ok("Formulario no encontrado");
        }
    }

}
