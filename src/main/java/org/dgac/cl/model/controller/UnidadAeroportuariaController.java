package org.dgac.cl.model.controller;

import org.dgac.cl.model.entity.UnidadAeroportuaria;
import org.dgac.cl.negocio.UnidadAeroportuariaNegocio;
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
@RequestMapping("/unidadAeroportuaria")
public class UnidadAeroportuariaController {

    @Autowired 
    private UnidadAeroportuariaNegocio negocio;
    
    @GetMapping("/")
    private ResponseEntity<?> findAll(){
        return ResponseEntity.ok(negocio.findAll());
    }

    @GetMapping("/{id}") 
    private ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(negocio.findById(id));
    }

    @PostMapping("/")
    private ResponseEntity<?> save(@RequestBody UnidadAeroportuaria unidadAeroportuaria){
        return ResponseEntity.ok(negocio.save(unidadAeroportuaria));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable Integer id){
        try {
            String result = negocio.deleteById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
