package org.dgac.cl.controller;

import org.dgac.cl.model.entity.Parametro;
import org.dgac.cl.model.service.ParametroService;
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
@RequestMapping("/parametro")
public class ParametroController {

    @Autowired
    private ParametroService service;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Parametro parametro){
        return ResponseEntity.ok().body(service.save(parametro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Parametro parametroExistente = service.findById(id);
        if(parametroExistente != null ){
            service.deleteById(id);
            return ResponseEntity.ok().body("Parametro eliminado correctamente");
        }else{
            return ResponseEntity.ok().body("Parametro no encontrado");
        }
    }


}
