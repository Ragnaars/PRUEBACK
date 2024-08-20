package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.UnidadAeroportuaria;
import org.dgac.cl.model.service.UnidadAeroportuariaService;
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
@RequestMapping("/unidadAeroportuaria")
public class UnidadAeroportuariaController {

    @Autowired 
    private UnidadAeroportuariaService service;
    
    @GetMapping("/")
    private ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}") 
    private ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/")
    private ResponseEntity<?> save(@RequestBody UnidadAeroportuaria unidadAeroportuaria){
        return ResponseEntity.ok(service.save(unidadAeroportuaria));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable Integer id){
        UnidadAeroportuaria unidadAeroportuariaExistente = service.findById(id);

        if(unidadAeroportuariaExistente != null){
            service.deleteById(id);
            return ResponseEntity.ok("Unidad Aeroportuaria eliminada correctamente");
        }else{
            return ResponseEntity.ok("Unidad Aeroportuaria no encontrada");
        }
    }

}
